package edu.mu.pizzaOrder;

public enum PizzaType {
	// set enum up with left hand side being pizza type and right hand side being initial price of pizza 
	MARGHERITA(2.50),
	VEGETARIAN(1.50),
	HAWAIIAN(3.00),
	SUPREME(3.50);
	
	private double basePrice;// set price of enum 
	
	PizzaType(double toppingPrice){//have setter 
		this.basePrice = toppingPrice;
	}
	// have a getter for price of pizza 
	public double getBasePrice()
{
		return basePrice;}
}
