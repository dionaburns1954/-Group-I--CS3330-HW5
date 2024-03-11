package edu.mu.pizzaOrder;

public class PizzaCookingFactory {
	
	public AbstractPizza createPizza(PizzaType pizzaType) {
		AbstractPizza p;
		if(pizzaType == PizzaType.HAWAIIAN) { //creates Hawaiian pizza
    		p = new HawaiianPizza();
    		
 
    		return p;
    	}
    	else if(pizzaType == PizzaType.MARGHERITA) { //creates Margherita pizza
    		p = new MargheritaPizza();
    		
    		
 
    		return p;
    	}
    	else if(pizzaType == PizzaType.SUPREME) { //creates supreme pizza
    		p = new SupremePizza();
    		
    		
    		return p;
    	}
    	else if(pizzaType == PizzaType.VEGETARIAN){ //creates vegetarian pizza
    		p = new VegetarianPizza();
    		
    		
    		
    		return p;
    	}
    	
		
		
		return null; // returns false if the topping given is non of the ones registered
	}
}
