package edu.mu.pizzaOrder;

/**
 * Pizza factory object for creating child pizzas of {@link AbstractPizza}.
 * 
 * @author Dion Burns
 * @author Albert Zhou
 * @version 1.0
 * 
 * @see AbstractPizza
 * @see HawaiianPizza
 * @see MargheritaPizza
 * @see SupremePizza
 * @see VegetarianPizza
 */
public class PizzaCookingFactory {
	
	/**
	 * Creates pizzas of a specified type.<p>
	 * 
	 * After the pizza is created, increments {@link AbstractPizza#orderIDCounter}, and assigns the value to {@link AbstractPizza#pizzaOrderID}.
	 * 
	 * @param pizzaType the type of pizza that should be created
	 * @return the pizza object created. If {@code pizzaType} is not found, returns null.
	 */
	public AbstractPizza createPizza(PizzaType pizzaType) {
		
		AbstractPizza p;
		if(pizzaType == PizzaType.HAWAIIAN) { // Creates Hawaiian pizza
    		p = new HawaiianPizza();
    		assignPizzaOrderId(p);
    		
    		return p;
    	}
    	else if(pizzaType == PizzaType.MARGHERITA) { // Creates Margherita pizza
    		p = new MargheritaPizza();
    		assignPizzaOrderId(p);
 
    		return p;
    	}
    	else if(pizzaType == PizzaType.SUPREME) { // Creates Supreme pizza
    		p = new SupremePizza();
    		assignPizzaOrderId(p);
    		
    		return p;
    	}
    	else if(pizzaType == PizzaType.VEGETARIAN){ // Creates vegetarian pizza
    		p = new VegetarianPizza();
    		assignPizzaOrderId(p);
    		
    		return p;
    	}
    	
		return null; // Return false if pizza doesn't match one of the above options.
	}
	
	// Increment the pizza order ID.
	private void incrementOrderID() {
		AbstractPizza.setOrderIDCounter(AbstractPizza.getOrderIDCounter() + 1);
	}
	
	// Assigns the orderIDCounter to the pizzaOrderID field.
	private void assignPizzaOrderId(AbstractPizza p) {
		incrementOrderID();
		p.setPizzaOrderID(AbstractPizza.getOrderIDCounter());
	}
}
