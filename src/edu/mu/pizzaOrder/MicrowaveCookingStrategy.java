package edu.mu.pizzaOrder;

public class MicrowaveCookingStrategy implements ICookingStrategy{
private static final double ADDEDCOOKINGPRICE = 1.00;

public boolean cook(AbstractPizza Pizza) {
	Pizza.setCookingPrice(ADDEDCOOKINGPRICE);
	Pizza.setCookingStrategy(this);
	Pizza.updatePizzaPrice();
	return true;

	}
}
