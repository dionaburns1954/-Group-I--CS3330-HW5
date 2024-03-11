package edu.mu.pizzaOrder;

public class ConventionalOvenCookingStrategy implements ICookingStrategy{
private static final double ADDEDCOOKINGPRICE = 8.00;

public boolean cook(AbstractPizza Pizza) {
	Pizza.setCookingPrice(ADDEDCOOKINGPRICE);
	Pizza.setCookingStrategy(this);
	Pizza.updatePizzaPrice();
	return true;

	}
}
