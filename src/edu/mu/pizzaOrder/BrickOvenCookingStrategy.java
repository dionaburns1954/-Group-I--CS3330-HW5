package edu.mu.pizzaOrder;

public class BrickOvenCookingStrategy implements ICookingStrategy{
private static final double ADDEDCOOKINGPRICE = 10.00;// this is price for brickoven cooking strategy 

public boolean cook(AbstractPizza Pizza) {
	Pizza.setCookingPrice(ADDEDCOOKINGPRICE);// this sets the cooking price 
	Pizza.setCookingStrategy(this);// this tells that this ( brickovencooking strategy 
	Pizza.updatePizzaPrice();// update teh price of pizza 
	return true;

	}
}
