package edu.mu.pizzaOrder;

public class BrickOvenCookingStrategy implements ICookingStrategy{
private static final double ADDEDCOOKINGPRICE = 10.00;

public boolean cook(AbstractPizza Pizza) {
	Pizza.setCookingPrice(ADDEDCOOKINGPRICE);
	Pizza.setCookingStrategy(this);
	Pizza.updatePizzaPrice();
	return true;

	}
}
