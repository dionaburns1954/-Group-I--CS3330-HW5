package edu.mu.pizzaOrder;

public class ConventionalOvenCookingStrategy implements ICookingStrategy{
private static final double ADDEDCOOKINGPRICE = 8.00;// this is price for normal oven 

public boolean cook(AbstractPizza Pizza) {
	Pizza.setCookingPrice(ADDEDCOOKINGPRICE);// this sets cooking price 
	Pizza.setCookingStrategy(this);// this sets the strategy 
	Pizza.updatePizzaPrice();// this updates the price of pizza 
	return true;

	}
}
