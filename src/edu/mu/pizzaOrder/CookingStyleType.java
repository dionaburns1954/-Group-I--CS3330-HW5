package edu.mu.pizzaOrder;

/**
 * Enum storing the different cooking methods for pizzas.
 * 
 * @author Logan Bird
 * @author Albert Zhou
 * @version 1.0
 * 
 * @see ICookingStrategy
 */
public enum CookingStyleType {
	
	// Define the cooking styles, as well as their default prices.
	BRICK_OVEN(10.00),
	CONVENTIONAL_OVEN(8.00),
	MICROWAVE(1.00);
	
	private double cookingStylePrice; // Set the price of the cooking style
	
	CookingStyleType(double cookingStylePrice){
		this.cookingStylePrice = cookingStylePrice;
	}
	
	// Get the price of the cooking style
	public double getCookingStylePrice() {
		return cookingStylePrice;
	}
}
