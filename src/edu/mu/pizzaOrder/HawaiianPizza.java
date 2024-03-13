package edu.mu.pizzaOrder;

/**
 * Hawaiian {@link AbstractPizza} containing Canadian bacon, cheese, and pineapple
 * 
 * @author Logan Bird
 * @version 1.0
 * 
 * @see AbstractPizza
 */
public class HawaiianPizza  extends AbstractPizza {
	
	/**
	 * Creates a HawaiianPizza with default toppings.
	 */
	public HawaiianPizza () {
		super(); // Call the super constructor
		addDefaultToppings();
		setBasePrices();
	}
	
	/**
	 * Copy constructor.
	 * @param Pizza the pizza to copy
	 * 
	 * @see AbstractPizza#AbstractPizza(AbstractPizza)
	 */
	public HawaiianPizza(HawaiianPizza Pizza) {
		super(Pizza);
	}
	
	public HawaiianPizza copy() {
		return new HawaiianPizza(this);
	}

	/**
	 * Adds Hawaiian pizza toppings.<p>
	 * 
	 * Adds {@link Toppings#CANADIAN_BACON}, {@link Toppings#CHEESE}, 
	 * and {@link Toppings#PINEAPPLE} to the pizza's {@link AbstractPizza#toppingList}
	 */
	private void addDefaultToppings() {
		toppingList.add(Toppings.CANADIAN_BACON);
		toppingList.add(Toppings.CHEESE);
		toppingList.add(Toppings.PINEAPPLE);
	}
		
	/**
	 * Assigns prices to the pizza, including toppings.<p>
	 * 
	 * Sets {@link AbstractPizza#priceWithoutToppings} to the default price, then
	 * adds the price of toppings to the total price.
	 */
	private void setBasePrices() {
		setPriceWithoutToppings(PizzaType.HAWAIIAN.getBasePrice());
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
		
		updatedTotal += cookingPrice;
		setTotalPrice(updatedTotal); // Set the pizza's totalPrice to the new total
		return updatedTotal;
	}

	// Prints the type of pizza, as well as any relevant fields.
	public String toString() {
		return "HawaiianPizza:" + pizzaOrderID + ", Price " + totalPrice + ", Toppings " + toppingList.toString();
	}
}