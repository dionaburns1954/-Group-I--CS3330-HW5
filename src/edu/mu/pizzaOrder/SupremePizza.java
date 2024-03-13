package edu.mu.pizzaOrder;

/**
 * Supreme {@link AbstractPizza} containing tomato, cheese, bell pepper, italian sausage, pepperoni, black olives, and mushrooms.
 * 
 * @author Logan Bird
 * @version 1.0
 * 
 * @see AbstractPizza
 */
public class SupremePizza  extends AbstractPizza {
	
	/**
	 * Creates a SupremePizza with default toppings.
	 */
	public SupremePizza () {
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
	public SupremePizza(SupremePizza Pizza) {
		super(Pizza); // Call the copy constructor of the superclass
	}
	
	public SupremePizza copy() {
		return new SupremePizza(this);
	}
	
	/**
	 * Adds Supreme pizza toppings.<p>
	 * 
	 * Adds {@link Toppings#TOMATO}, {@link Toppings#CHEESE}, {@link Toppings#BELL_PEPPER}, {@link Toppings#ITALIAN_SAUSAGE}, 
	 * {@link Toppings#PEPPERONI}, {@link Toppings#BLACK_OLIVE}, and {@link Toppings#MUSHROOM} to the pizza's {@link AbstractPizza#toppingList}
	 */
	private void addDefaultToppings() {
		toppingList.add(Toppings.TOMATO);
		toppingList.add(Toppings.CHEESE);
		toppingList.add(Toppings.BELL_PEPPER);
		toppingList.add(Toppings.ITALIAN_SAUSAGE);
		toppingList.add(Toppings.PEPPERONI);
		toppingList.add(Toppings.BLACK_OLIVE);
		toppingList.add(Toppings.MUSHROOM);
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
		
		updatedTotal += cookingPrice;
		setTotalPrice(updatedTotal); // Set the pizza's totalPrice to the new total
		return updatedTotal;
	}
	
	// Prints the type of pizza, as well as any relevant fields.
	public String toString() {
		String cookingMethodString = cookingStrategy != null ? cookingStrategy.getCookingType().toString() : "None";
		
		return "SupremePizza: Order ID: " + pizzaOrderID + ", Base price:" + priceWithoutToppings + ", Cooking price: " + cookingPrice + ", Total Price: " + totalPrice + ", Cooking method: " + cookingMethodString + ", Toppings: " + toppingList.toString();
	}
}