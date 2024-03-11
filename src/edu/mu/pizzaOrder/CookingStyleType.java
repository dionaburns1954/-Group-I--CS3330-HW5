package edu.mu.pizzaOrder;

public enum CookingStyleType {
	// left hand side is cooking method right hand side is price of cooking method
	MICROWAVE(10.00),
	CONVENTIONAL_OVEN(8.00),
	BRICK_OVEN(1.00);
	
	private double additionalCookingPrice;// set additional price 
	
	CookingStyleType(double additionalCookingPrice){
		this.additionalCookingPrice = additionalCookingPrice;
	}
	// getter for price 
	public double getAdditionalCookingPrice() {
		return additionalCookingPrice;
	}
}
