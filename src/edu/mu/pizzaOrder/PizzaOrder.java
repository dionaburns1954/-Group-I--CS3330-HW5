package edu.mu.pizzaOrder;


import java.util.List;

public class PizzaOrder {
	
	private PizzaCookingFactory pizzaFactory = new PizzaCookingFactory();
	private ICookingStrategy cookingStrategy;
	private List<AbstractPizza> pizzaOrderList;
	
	public PizzaOrder() {
		
	}
	
	// Method to print list of toppings by Pizza Order ID
    public void printListOfToppingsByPizzaOrderID(int orderID) {
        //loop through pizzaOrder list
    	//print toppings of selected pizza in pizzaOrderList
    	for(AbstractPizza p : pizzaOrderList) {
    		if(p.getPizzaOrderID() == orderID) {
    			System.out.println(p.getToppingList());
    		}
    	}
    	
    }

    // Method to print pizza order cart
    public void printPizzaOrderCart(int orderID) {
        // TODO: Implement method
    	for(AbstractPizza p : pizzaOrderList) {
    		System.out.println(p); //might need to be fixed later on
    	}
    }

    // Method to get pizza by order ID
    public AbstractPizza getPizzaByOrderID(int orderID) {
    	for(int i = 0; i < pizzaOrderList.size(); i++) {
    		if(pizzaOrderList.get(i).getPizzaOrderID() == orderID) { //loop through pizza list
    			return pizzaOrderList.get(i); //returns index of pizza if found
    		}
    	}
    	
    	return null; //returns null if not pizza matching ID was found
    	
    }

    // Method to add pizza to cart
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

    // Method to add new topping to pizza
    public boolean addNewToppingToPizza(int orderID, Toppings topping) {
        // TODO: Implement method
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

    // Method to remove topping from pizza
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

    // Method to check if there are any uncooked pizzas
    public boolean isThereAnyUncookedPizza() {
    	for(AbstractPizza p : pizzaOrderList) {
    		if(p.getCookingStrategy() == null) {
    			return true;
    		}
    	}
    	return false;
    }

    // Method for checkout
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

    // Method to select cooking strategy by Pizza Order ID
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
