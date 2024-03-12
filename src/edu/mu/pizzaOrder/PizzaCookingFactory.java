package edu.mu.pizzaOrder;

public class PizzaCookingFactory {
	
	public AbstractPizza createPizza(PizzaType pizzaType) {
		
		AbstractPizza p;
		if(pizzaType == PizzaType.HAWAIIAN) { //creates Hawaiian pizza
    		p = new HawaiianPizza();
    		assignPizzaOrderId(p);
    		
    		return p;
    	}
    	else if(pizzaType == PizzaType.MARGHERITA) { //creates Margherita pizza
    		p = new MargheritaPizza();
    		assignPizzaOrderId(p);
 
    		return p;
    	}
    	else if(pizzaType == PizzaType.SUPREME) { //creates supreme pizza
    		p = new SupremePizza();
    		assignPizzaOrderId(p);
    		
    		return p;
    	}
    	else if(pizzaType == PizzaType.VEGETARIAN){ //creates vegetarian pizza
    		p = new VegetarianPizza();
    		assignPizzaOrderId(p);
    		
    		return p;
    	}
    	
		return null; // returns false if the topping given is non of the ones registered
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
