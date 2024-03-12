package edu.mu.pizzaOrder;

/**
 * Enum storing the different cooking methods for pizzas and their respective prices.
 * 
 * @author Logan Bird
 * @author Albert Zhou
 * @version 1.0
 * 
 * @see ICookingStrategy
 * @see BrickOvenCookingStrategy
 * @see ConventionalOvenCookingStrategy
 * @see MicrowaveCookingStrategy
 */
public enum CookingStyleType {
	
	// Define the cooking styles, as well as their default prices.
	BRICK_OVEN(10.00),
	CONVENTIONAL_OVEN(8.00),
	MICROWAVE(1.00);
	
	private double cookingStylePrice;
	
	// Constructor for enum members
	CookingStyleType(double cookingStylePrice) {
		this.cookingStylePrice = cookingStylePrice;
	}
	
	// Get the price of the cooking style
	public double getCookingStylePrice() {
		return cookingStylePrice;
	}
}
