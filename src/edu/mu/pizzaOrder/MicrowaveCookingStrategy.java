package edu.mu.pizzaOrder;

public class MicrowaveCookingStrategy implements ICookingStrategy{
private static final double ADDEDCOOKINGPRICE = 1.00;// this is price of cooking with microwave 

public boolean cook(AbstractPizza Pizza) {
	Pizza.setCookingPrice(ADDEDCOOKINGPRICE);// this is setting cooking price 
	Pizza.setCookingStrategy(this);// this is setting cooking strategy 
	Pizza.updatePizzaPrice();// this is updating price of pizza 
	return true;

	}
}
