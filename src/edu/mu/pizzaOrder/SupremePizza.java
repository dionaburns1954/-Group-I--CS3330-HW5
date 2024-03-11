package edu.mu.pizzaOrder;



public class SupremePizza  extends AbstractPizza {
	 public SupremePizza () {
		 super();
		 addDefaultToppings();
		 Price();
	 }
	
	 
	// Copy constructor
public SupremePizza(SupremePizza Pizza) {
	 super(Pizza); // Call the copy constructor of the superclass
}
private void addDefaultToppings() {
	toppingList.add(Toppings.TOMATO);
	toppingList.add(Toppings.CHEESE);
	toppingList.add(Toppings.BELL_PEPPER);
	toppingList.add(Toppings.ITALIAN_SAUSAGE);
	toppingList.add(Toppings.PEPPERONI);
	toppingList.add(Toppings.BLACK_OLIVE);
	toppingList.add(Toppings.MUSHROOM);
}

// This sets price for this Pizza by first taking default price and then taking price of added toppings
private void Price () {
 setPriceWithoutToppings(3.50);
 addToppingsToPrice(getPriceWithoutToppings());
}
	// This adds the toppings prices to the total price of pizza 
protected double addToppingsToPrice(double priceWithoutToppings) {

 double total = priceWithoutToppings;
 for ( Toppings topping : getToppingList()) {// loop through the Toppings for this pizza ( toppings that were added to list) 
	 total += topping.getPrice();// add the topping price to the total 
 }
 setTotalPrice(total);// set the total 
 return total;
}
	// this function pretty much does the same thing as add toppings to price except it is used for when updating the price of the pizza like when add new toppings 
public double updatePizzaPrice() {
 
 double updatedTotal = getPriceWithoutToppings();// start it getting price without toppings 
 for (Toppings topping : getToppingList()) {// once again looping through the toppings 
	 updatedTotal += topping.getPrice();// add topping price to total 
 }
 setTotalPrice(updatedTotal);// set new total 
 return updatedTotal;
}
// prints string of type of pizza order number price and toppings
public String toString() {
 
 return "SupremePizza:" + pizzaOrderID + ", Price " + totalPrice + ", Toppings " + toppingList.toString();
}
}

	 
