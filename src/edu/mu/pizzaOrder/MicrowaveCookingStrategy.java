package edu.mu.pizzaOrder;

public class MicrowaveCookingStrategy implements ICookingStrategy{
	
	private static final double ADDEDCOOKINGPRICE = 1.00; // Default price of the Microwave cooking strategy

	public boolean cook(AbstractPizza Pizza) {
	
		Pizza.setCookingPrice(ADDEDCOOKINGPRICE); // Set the pizza's cooking price to the default price
		Pizza.setCookingStrategy(this); // Set the pizza's cooking strategy to this strategy.
		Pizza.updatePizzaPrice(); // Update the price of the pizza to reflect the cooking strategy price.
		
		return true;
	
	}
}
