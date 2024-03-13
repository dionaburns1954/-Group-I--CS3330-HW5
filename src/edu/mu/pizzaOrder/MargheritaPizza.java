package edu.mu.pizzaOrder;

/**
 * Margherita {@link AbstractPizza} containing tomato and cheese
 * 
 * @author Logan Bird
 * @version 1.0
 * 
 * @see AbstractPizza
 */
public class MargheritaPizza  extends AbstractPizza {
	
	/**
	 * Creates a MargheritaPizza with default toppings.
	 */
	public MargheritaPizza () {
		super();
		addDefaultToppings();
		setBasePrices();
	}
	
	/**
	 * Copy constructor.
	 * @param Pizza the pizza to copy
	 * 
	 * @see AbstractPizza#AbstractPizza(AbstractPizza)
	 */
	public MargheritaPizza(MargheritaPizza Pizza) {
		super(Pizza); // Call the copy constructor of the superclass
	}
	
	public MargheritaPizza copy() {
		return new MargheritaPizza(this);
	}
	
	/**
	 * Adds Margherita pizza toppings.<p>
	 * 
	 * Adds {@link Toppings#TOMATO} and {@link Toppings#CHEESE} to the pizza's {@link AbstractPizza#toppingList}
	 */
	private void addDefaultToppings () {
		toppingList.add(Toppings.TOMATO);
		toppingList.add(Toppings.CHEESE);
	}

	/**
	 * Assigns prices to the pizza, including toppings.<p>
	 * 
	 * Sets {@link AbstractPizza#priceWithoutToppings} to the default price, then
	 * adds the price of toppings to the total price.
	 */
	private void setBasePrices() {
		setPriceWithoutToppings(PizzaType.SUPREME.getBasePrice());
		addToppingsToPrice(getPriceWithoutToppings());
	}
	
	/**
	 * Takes the price of the toppings in this pizza's {@link AbstractPizza#toppingList}, adds it to the price without toppings,
	 * and returns the total price of the pizza.
	 * 
	 * @param priceWithoutToppings the price of the pizza without toppings
	 * @return the total price of the pizza, including any toppings
	 */
	protected double addToppingsToPrice(double priceWithoutToppings) {

		double total = priceWithoutToppings;
		for(Toppings topping : getToppingList()) { // Loop through the toppingList
			total += topping.getPrice(); // Get the price of topping, and add it to the total
		}
		
		setTotalPrice(total); // Set the total price of the pizza
		return total;
	}
	
	/**
	 * {@inheritDoc AbstractPizza#updatePizzaPrice()}
	 */
	public double updatePizzaPrice() {

		double updatedTotal = getPriceWithoutToppings(); // Get the price without toppings
		
		// Iterates through the pizza's topping list, and adds the price of the topping to updatedTotal
		for(Toppings topping : getToppingList()) {
			updatedTotal += topping.getPrice();
		}
		
		setTotalPrice(updatedTotal); // Set the pizza's totalPrice to the new total
		return updatedTotal;
	}
	
	// prints string of type of pizza order number price and toppings
	public String toString() {
		return "MargheritaPizza:" + pizzaOrderID + ", Price " + totalPrice + ", Toppings " + toppingList.toString();
	}
}