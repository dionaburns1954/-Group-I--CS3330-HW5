package edu.mu.pizzaOrder;

/**
 * Generic interface for cooking strategies
 * @author Ryan Esparza
 * @version 1.0
 * 
 * @see BrickOvenCookingStrategy
 * @see ConventionalOvenCookingStrategy
 * @see MicrowaveCookingStrategy
 */
public interface ICookingStrategy {
	
	/**
	 * Changes {@link AbstractPizza#cookingPrice} and 
	 * {@link AbstractPizza#cookingStrategy} to the relevant cooking strategy.
	 * @param pizza the pizza to apply the cooking method to
	 * @return the result of the operation
	 */
	public boolean cook(AbstractPizza pizza);
}
