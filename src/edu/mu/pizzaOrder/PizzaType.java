package edu.mu.pizzaOrder;

public enum PizzaType {
	// set enum up with left hand side being pizza type and right hand side being initial price of pizza 
	HAWAIIAN(1.50),
	MARGHERITA(2.00),
	SUPREME(3.50),
	VEGETARIAN(1.50);
	
	private double toppingPrice;// set price of enum 
	
	PizzaType(double toppingPrice){//have setter 
		this.toppingPrice = toppingPrice;
	}
	// have a getter for price of pizza 
	public double getToppingPrice()
{
		return toppingPrice;}
}
