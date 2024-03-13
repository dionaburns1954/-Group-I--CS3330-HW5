package edu.mu.pizzaOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to manage pizza orders.
 * 
 * @author Logan Bird
 * @author Dion Burns
 * @author Ryan Esparza
 * @author Albert Zhou
 * @version 1.0
 * 
 * @see AbstractPizza
 * @see PizzaCookingFactory
 */
public class PizzaOrder {
	
	private PizzaCookingFactory pizzaFactory;
	private ICookingStrategy cookingStrategy;
	private List<AbstractPizza> pizzaOrderList;
	
	public PizzaOrder() {
		this.pizzaFactory = new PizzaCookingFactory();
		this.pizzaOrderList = new ArrayList<AbstractPizza>();
	}
	
    /**
     * Searches through {@link #pizzaOrderList} for a pizza with the specified order ID, and returns it.
     * @param orderID the order ID of the pizza to find
     * @return the pizza in the orderList with the specified order ID. If no pizza is found, returns null.
     */
    private AbstractPizza getRealPizzaByOrderID(int orderID) {
    	// Loops through the order list and returns the pizza matching the order ID.
    	for(AbstractPizza p : pizzaOrderList) {
    		if(p.getPizzaOrderID() == orderID) {
    			return p;
    		}
    	}
    	
    	return null; //returns null if not pizza matching ID was found
    }
	
	/**
	 * Searches through the pizza order list for the order with the given ID and prints the toppings of the order.
	 * 
	 * @param orderID the order ID of the pizza to find
	 */
    public void printListOfToppingsByPizzaOrderID(int orderID) {
    	
    	// Get the pizza with the order ID, and print the topping list if it exists.
    	AbstractPizza pizza = getRealPizzaByOrderID(orderID);
    	if(pizza != null) {
    		System.out.println(pizza.getToppingList());
    	}
    }

    /**
     * Prints the details of all pizzas in {@link PizzaOrder#pizzaOrderList}
     * 
     * @param orderID 
     */	
    public void printPizzaOrderCart(int orderID) { // NOTE: What is the parameter here for?
    	for(AbstractPizza p : pizzaOrderList) {
    		System.out.println(p.toString()); // Print the details of each pizza
    	}
    }

    /**
     * Searches through {@link #pizzaOrderList} for a pizza with the specified order ID, and returns a copy of it.
     * 
     * @param orderID the order ID of the pizza to find
     * @return a copy of pizza with the specified order ID. If no pizza is found, returns null.
     */
    public AbstractPizza getPizzaByOrderID(int orderID) {
    	// Call getRealPizzaByOrderID to get the pizza, and return a copy if it's not null. Otherwise return null.
    	return getRealPizzaByOrderID(orderID) != null ? getRealPizzaByOrderID(orderID).copy() : null;
  
    }
    
    /**
     * Adds a pizza of given {@link PizzaType} to the cart.
     * 
     * @param pizzaType the type of pizza to add
     * @return true if the pizza was successfully added, false otherwise.
     */
    public boolean addPizzaToCart(PizzaType pizzaType) {

    	AbstractPizza p; // Pizza to be returned
    	
    	// Finds a match in the PizzaType enum and creates the corresponding pizza
    	switch(pizzaType) {
    	case HAWAIIAN:
    		p = pizzaFactory.createPizza(PizzaType.HAWAIIAN);
    		break;
    	case MARGHERITA:
    		p = pizzaFactory.createPizza(PizzaType.MARGHERITA);
    		break;
    	case SUPREME:
    		p = pizzaFactory.createPizza(PizzaType.SUPREME);
    		break;
    	case VEGETARIAN:
    		p = pizzaFactory.createPizza(PizzaType.VEGETARIAN);
    		break;
    	default:
    		return false;
    	}
    	
    	// If the pizza is successfully added to the order list, returns true, otherwise false.
    	if(pizzaOrderList.add(p)) {
    		return true;
    	} else {
    		return false;
    	}
    }

    /**
     * Adds a {@link Topping} to a given pizza and updates the price.
     * 
     * @param orderID the order ID of the pizza to add toppings to
     * @param topping the topping to add to the pizza
     * @return true if the topping was successfully added, false otherwise.
     */
    public boolean addNewToppingToPizza(int orderID, Toppings topping) {
    	
    	// Return false if the pizza with specified order ID doesn't exist
    	AbstractPizza pizza = getRealPizzaByOrderID(orderID);
    	if(pizza == null) {
    		return false;
    	}
    	
    	// Add the topping and update the price
    	pizza.getToppingList().add(topping);
    	pizza.updatePizzaPrice();
    	return true;
    	
    }

    /**
     * Removes a {@link Topping} from a given pizza.
     * 
     * @param orderID the order ID of the pizza to remove toppings from
     * @param topping the topping to remove from the pizza
     * @return true if the topping was successfully removed, false otherwise.
     */
    public boolean removeToppingFromPizza(int orderID, Toppings topping) {
    	
    	// Get the pizza with the specified order ID. If the pizza doesn't exist, then returns false.
    	AbstractPizza pizza = getRealPizzaByOrderID(orderID);
    	if(pizza == null) {
    		return false;
    	}
    	
    	// If the pizza contains the topping, remove it and update the price.
    	if(pizza.getToppingList().contains(topping)) {
    		pizza.getToppingList().remove(topping);
    		pizza.updatePizzaPrice();
    		return true;
    	}
    	
    	return false;
    }

    /**
     * Loops through {@link #pizzaOrderList}, and searches for any pizzas without a cooking strategy.<p>
     * 
     * A pizza is considered uncooked if it does not have a cooking strategy.
     * 
     * @return true if there are uncooked pizzas in the order list, false if there are no uncooked pizzas.
     */
    public boolean isThereAnyUncookedPizza() {
    	
    	// Loop through the order list, and check if there are pizzas without a cooking strategy.
    	for(AbstractPizza p : pizzaOrderList) {
    		if(p.getCookingStrategy() == null) {
    			return true;
    		}
    	}
    	
    	return false;
    }

    /**
     * Calculates the total price of all pizzas in the cart for checkout.<p>
     * 
     * All pizzas must be cooked to check out.
     * 
     * @return the total price of all pizzas in the cart
     * @throws Exception if there are no pizzas in the order list
     * @throws Exception if there are uncooked pizzas in the cart
     * 
     * @see #isThereAnyUncookedPizza()
     */
    public double checkout() throws Exception {
		if(pizzaOrderList.isEmpty()) {
			// Throw an exception if there's no pizzas in the order list
			throw new Exception("There are no pizzas in your cart!");
			
		} else if(!isThereAnyUncookedPizza()) {
        	double totalPrice = 0; // Running total of the price of all items in cart
        	
        	for(AbstractPizza p : pizzaOrderList) {
        		totalPrice += p.getTotalPrice(); // Add the price of pizza p to running total
        	}
        	// After the loop has finished, return the final total price
        	return totalPrice;
        } else {
        	// Throw exception if there are uncooked pizzas in the cart
        	throw new Exception("You have uncooked pizzas in your cart!"); 
        }
    }

    /**
     * Gets the pizza with the given order ID, instantiates the given {@code CookingStrategy}, and calls the {@link ICookingStrategy#cook(AbstractPizza)}.
     * 
     * @param orderID the order ID of the pizza
     * @param cookingStrategyType the cooking strategy that should be used
     * @return true if the operation was successful, false otherwise.
     */
    public boolean selectCookingStrategyByPizzaOrderID(int orderID, CookingStyleType cookingStrategyType) {

    	// If the pizza doesn't exist, then return false
    	AbstractPizza pizza = getRealPizzaByOrderID(orderID);
    	if(pizza == null) {
    		return false;
    	}
    	
    	// Set the cooking strategy based on the cooking style type.
    	switch(cookingStrategyType) {
    	case BRICK_OVEN:
    		cookingStrategy = new BrickOvenCookingStrategy();
    		break;
    	case CONVENTIONAL_OVEN:
    		cookingStrategy = new ConventionalOvenCookingStrategy();
    		break;
    	case MICROWAVE:
    		cookingStrategy = new MicrowaveCookingStrategy();
    		break;
    	default:
    		return false;
    	}
    	
    	// Set the cooking strategy, price, and update the price
    	pizza.setCookingStrategy(cookingStrategy);
    	pizza.setCookingPrice(cookingStrategyType.getCookingStylePrice());
    	pizza.updatePizzaPrice();
    	return true;
    }

}
