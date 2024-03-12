package edu.mu.pizzaOrder;

import java.util.List;
import java.util.ArrayList;

/**
 * An object containing base information for a pizza.
 * 
 * @author Logan Bird
 * @author Dion Burns
 * @author Ryan Esparza
 * @author Albert Zhou
 * @version 1.0
 * 
 * @see HawaiianPizza
 * @see SupremePizza
 * @see MargheritaPizza
 * @see VegetarianPiza
 */
public abstract class AbstractPizza {

	protected List<Toppings> toppingList;
	/**
	 * The base price of the pizza without any toppings. Adding {@link Toppings} to the pizza.
	 * increases the cost.
	 */
    protected double priceWithoutToppings;
    /**
     * The total cost of the pizza. <p>
     * 
     * The sum of {@link AbstractPizza#priceWithoutToppings}, {@link AbstractPizza#cookingPrice}, 
     * and the price of any {@link Toppings} in {@link AbstractPizza#toppingList}.
     */
    protected double totalPrice;
    protected int pizzaOrderID;
    /**
     * Static counter to keep track of how many orders there are and assign unique IDs to {@link AbstractPizza#pizzaOrderID} when 
     * a pizza is created using the {@link PizzaCookingFactory#createPizza(PizzaType)} method.
     */
    protected static int orderIDCounter;
	protected ICookingStrategy cookingStrategy;
    protected double cookingPrice;
    
    /**
     * Creates a new {@link AbstractPizza} object with only the toppingList. Other fields should be filled out in
     * subclasses.
     */
    public AbstractPizza() {
        toppingList = new ArrayList<>();
        // Initialize other attributes here
        cookingStrategy = null;
    }
    
    /**
     * Copy constructor for creating deep copies of {@link AbstractPizza} objects
     * 
     * @param Pizza the pizza to copy
     */
	public AbstractPizza(AbstractPizza Pizza) {
    	
    	this.toppingList = new ArrayList<>(Pizza.toppingList);
        this.priceWithoutToppings = Pizza.priceWithoutToppings;
        this.totalPrice = Pizza.totalPrice;
        this.pizzaOrderID = Pizza.pizzaOrderID;
        this.cookingStrategy = Pizza.cookingStrategy;
        this.cookingPrice = Pizza.cookingPrice;
    }
    
	// Get the list of toppings
    public List<Toppings> getToppingList() {
        return toppingList;
    }
    
    // Updates the price of the pizza
    public abstract double updatePizzaPrice();
    
    // Set the topping list
    public void setToppingList(List<Toppings> toppingList) {
        this.toppingList = toppingList;
    }

    // Getter and setter methods for priceWithoutToppings
    public double getPriceWithoutToppings() {
        return priceWithoutToppings;
    }

    public void setPriceWithoutToppings(double priceWithoutToppings) {
        this.priceWithoutToppings = priceWithoutToppings;
    }

    // Getter and setter methods for totalPrice
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    // Getter and setter methods for orderIDCounter
    public static int getOrderIDCounter() {
		return orderIDCounter;
	}

	public static void setOrderIDCounter(int orderIDCounter) {
		AbstractPizza.orderIDCounter = orderIDCounter;
	}

    // Getter and setter methods for pizzaOrderID
    public int getPizzaOrderID() {
        return pizzaOrderID;
    }

    public void setPizzaOrderID(int pizzaOrderID) {
        this.pizzaOrderID = pizzaOrderID;
    }

    // Getter and setter methods for cookingStrategy
    public ICookingStrategy getCookingStrategy() {
        return cookingStrategy;
    }

    public void setCookingStrategy(ICookingStrategy cookingStrategy) {
        this.cookingStrategy = cookingStrategy;
    }

    // Getter and setter methods for cookingPrice
    public double getCookingPrice() {
        return cookingPrice;
    }

    public void setCookingPrice(double cookingPrice) {
        this.cookingPrice = cookingPrice;
    }

}
