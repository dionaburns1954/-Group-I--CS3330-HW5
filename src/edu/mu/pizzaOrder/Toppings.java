package edu.mu.pizzaOrder;

/**
 * Enum storing the vast array of toppings for pizzas, as well as the price associated with each topping.
 * 
 * @author Logan Bird
 * @author Albert Zhou
 * @version 1.0
 * 
 * @see AbstractPizza
 */
public enum Toppings {

	TOMATO(1.50),
	CHEESE(2.00),
	PINEAPPLE(2.50),
	BLACK_OLIVE(1.25),
	ITALIAN_SAUSAGE(3.50),
	PEPPERONI(3.00),
	BELL_PEPPER(1.00),
	MUSHROOM(1.50),
	CANADIAN_BACON(4.00);
	
	private final double price;
	
	// Constructor for enum members
	Toppings(double price) {
		this.price = price;
	}
	
	// Get the price of a topping
	public double getPrice() {
		return price;
	}
}
