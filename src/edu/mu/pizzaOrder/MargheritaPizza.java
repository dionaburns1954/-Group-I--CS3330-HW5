
package edu.mu.pizzaOrder;


public class MargheritaPizza extends AbstractPizza {
	public MargheritaPizza () {
		super();
		addDefaultToppings();
		Price();
	}

	// Copy constructor
	public MargheritaPizza(MargheritaPizza Pizza) {
		super(Pizza); // Call the copy constructor of the superclass
	}
	
	// This sets default Toppings for this kind of pizza 
	private void addDefaultToppings () {
		toppingList.add(Toppings.TOMATO);
		toppingList.add(Toppings.CHEESE);
	}
	
 	// This sets price for this Pizza by first taking default price and then taking price of added toppings
	private void Price () {
		setPriceWithoutToppings(2.50);
		addToppingsToPrice(getPriceWithoutToppings());
	}
	
 	// This adds the toppings prices to the total price of pizza 
	protected double addToppingsToPrice(double priceWithoutToppings) {
	
	double total = priceWithoutToppings;
	for(Toppings topping : getToppingList()) {// loop through the Toppings for this pizza ( toppings that were added to list) 
		total += topping.getPrice();// add the topping price to the total 
	}
	
	setTotalPrice(total);// set the total 
	return total;
}

 	// this function pretty much does the same thing as add toppings to price except it is used for when updating the price of the pizza like when add new toppings 
	public double updatePizzaPrice() {
		
		double updatedTotal = getPriceWithoutToppings();// start it getting price without toppings 
		for(Toppings topping : getToppingList()) {// once again looping through the toppings 
			updatedTotal += topping.getPrice();// add topping price to total 
		}
		
		setTotalPrice(updatedTotal);// set new total 
		return updatedTotal;
	}
	// prints string of type of pizza order number price and toppings
	public String toString() {
		 return "MargheritaPizza:" + pizzaOrderID + ", Price " + totalPrice + ", Toppings " + toppingList.toString();
	}
}