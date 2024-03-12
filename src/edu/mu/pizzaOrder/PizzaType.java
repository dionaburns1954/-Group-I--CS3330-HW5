package edu.mu.pizzaOrder;

/**
 * Enum storing the different base pizzas available.
 * 
 * @author Logan Bird
 * @author Albert Zhou
 * @version 1.0
 * 
 * @see AbstractPizza
 */
public enum PizzaType {

	MARGHERITA(2.50),
	VEGETARIAN(1.50),
	HAWAIIAN(3.00),
	SUPREME(3.50);
	
	private double basePrice;
	
	// Constructor for enum members
	PizzaType(double toppingPrice) {
		this.basePrice = toppingPrice;
	}

	// Get the base price of a given pizza type
	public double getBasePrice() {
		return basePrice;
	}
}
