package edu.mu.pizzaOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to manage pizza orders.
 * 
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
	 * Searches through the pizza order list for the order with the given ID and prints the toppings of the order.
	 * 
	 * @param orderID the order ID of the pizza to find
	 */
    public void printListOfToppingsByPizzaOrderID(int orderID) {

    	// Loop through the pizza order list
    	for(AbstractPizza p : pizzaOrderList) {
    		if(p.getPizzaOrderID() == orderID) {
    			System.out.println(p.getToppingList()); // Print the list of toppings
    		}
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
     * Searches through {@link #pizzaOrderList} for a pizza with the specified order ID, and returns it.
     * 
     * @param orderID the order ID of the pizza to find
     * @return the pizza with the specified orderID. If no pizza is found, returns null.
     */
    public AbstractPizza getPizzaByOrderID(int orderID) {
    	/*
    	 * TODO: Clean this up
    	 */
    	for(int i = 0; i < pizzaOrderList.size(); i++) {
    		if(pizzaOrderList.get(i).getPizzaOrderID() == orderID) { // Loop through pizza list
    			return pizzaOrderList.get(i); //returns index of pizza if found
    		}
    	}
    	
    	return null; //returns null if not pizza matching ID was found
    }

    /**
     * Adds a pizza of given {@link PizzaType} to the cart.
     * 
     * @param pizzaType the type of pizza to add
     * @return true if the pizza was successfully added, false otherwise.
     */
    public boolean addPizzaToCart(PizzaType pizzaType) {
        // TODO: Implement method
    	//user passes in pizzType
    	//create pizza of specific type
    	//add pizza to pizzaOrderList
    	AbstractPizza p;
    	if(pizzaType == PizzaType.HAWAIIAN) { //creates Hawaiian pizza
    		p = pizzaFactory.createPizza(pizzaType);
    		
    		pizzaOrderList.add(p);
    		return true;
    	}
    	else if(pizzaType == PizzaType.MARGHERITA) { //creates Margherita pizza
    		p = pizzaFactory.createPizza(pizzaType);
    		
    		pizzaOrderList.add(p);
    		return true;
    	}
    	else if(pizzaType == PizzaType.SUPREME) { //creates supreme pizza
    		p = pizzaFactory.createPizza(pizzaType);
    		
    		pizzaOrderList.add(p);
    		return true;
    	}
    	else if(pizzaType == PizzaType.VEGETARIAN){ //creates vegetarian pizza
    		p = pizzaFactory.createPizza(pizzaType);
    		
    		pizzaOrderList.add(p);
    		return true;
    	}
    	
    	return false;
    }

    /**
     * Adds a {@link Topping} to a given pizza. 
     * 
     * @param orderID the order ID of the pizza to add toppings to
     * @param topping the topping to add to the pizza
     * @return true if the topping was successfully added, false otherwise.
     */
    public boolean addNewToppingToPizza(int orderID, Toppings topping) {

    	for(int i = 0; i < pizzaOrderList.size(); i++) {
    		if(pizzaOrderList.get(i).getPizzaOrderID() == orderID) {
    			AbstractPizza p = pizzaOrderList.get(i);
    			p.getToppingList().add(topping);
    			p.setTotalPrice(p.getTotalPrice() + topping.getPrice());
    			return true;
    		}
    	}
    	
    	return false;
    }

    /**
     * Removes a {@link Topping} from a given pizza.
     * 
     * @param orderID the order ID of the pizza to remove toppings from
     * @param topping the topping to remove from the pizza
     * @return true if the topping was successfully removed, false otherwise.
     */
    public boolean removeToppingFromPizza(int orderID, Toppings topping) {
    	//loop through pizza list and find pizza with orderID
    	// remove topping from pizza if applicable
    	//if found pizza but no topping exists return true
    	//if found pizza and topping exists return true
    	//if did not find pizza return false
    	for(int i = 0; i < pizzaOrderList.size(); i++) { //loop through pizzaOrderList to find specific pizza
    		if(pizzaOrderList.get(i).getPizzaOrderID() == orderID) { 
    			AbstractPizza p = pizzaOrderList.get(i);
    			for(int j = 0; j < p.getToppingList().size(); j++) { //go through topping list of found pizza
    				if(p.getToppingList().get(i) == topping) {
    					p.getToppingList().remove(i); //remove topping if it exists on pizza
    					p.setTotalPrice(p.getTotalPrice() - topping.getPrice()); //changes price of pizza
    					return true;
    				}
    			}
    			return true;
    		}
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
        //loop through pizza list and find pizza with orderID
    	//set cooking style of pizza with that orderID
    	
    	for(int i = 0; i < pizzaOrderList.size(); i++) { 
    		if(pizzaOrderList.get(i).getPizzaOrderID() == orderID) { //find pizza with orderID
    			AbstractPizza p = pizzaOrderList.get(i);
    			p.setCookingStrategy(cookingStrategy); //change cooking strategy
    			p.setCookingPrice(cookingStrategyType.getCookingStylePrice()); //updates price of pizza
    			
    			return true;
    		}
    	}
    	
    	return false;
    }

}
