package edu.mu.pizzaOrder;

/**
 * Microwave cooking strategy. <p>
 * 
 * @author Logan Bird
 * @version 1.0
 * 
 * @see ICookingStrategy
 */
public class MicrowaveCookingStrategy implements ICookingStrategy{
	
	public boolean cook(AbstractPizza Pizza) {
	
		// Set the pizza's cooking price to the default price of the cooking style
		Pizza.setCookingPrice(CookingStyleType.MICROWAVE.getCookingStylePrice()); // Set the pizza's cooking price to the default price
		Pizza.setCookingStrategy(this); // Set the pizza's cooking strategy to this strategy.
		Pizza.updatePizzaPrice(); // Update the price of the pizza to reflect the cooking strategy price.
		
		return true;
	
	}

	@Override
	public CookingStyleType getCookingType() {
		return CookingStyleType.MICROWAVE;
	}
}
