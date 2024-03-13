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

	/**
	 * The list of {@link Toppings} that the pizza contains.
	 * 
	 */
	protected List<Toppings> toppingList;
	
	/**
	 * The base price of the pizza without any toppings. Adding {@link Toppings} to the pizza.
	 * increases the cost.
	 */
    protected double priceWithoutToppings;
    
    /**
     * The total cost of the pizza. <p>
     * 
     * The sum of {@link #priceWithoutToppings}, {@link #cookingPrice}, 
     * and the price of any {@link Toppings} in {@link #toppingList}.
     */
    protected double totalPrice;
    
    /**
     * The order that the pizza belongs to.<p>
     * 
     * Value is assigned upon instantiation by {@link PizzaCookingFactory}
     * @see #orderIDCounter
     */
    protected int pizzaOrderID;
    
    /**
     * Static counter to keep track of how many pizzas there are and assign unique IDs to {@link #pizzaOrderID} when 
     * a pizza is created using the {@link PizzaCookingFactory#createPizza(PizzaType)} method.
     */
    protected static int orderIDCounter;
    
    /**
     * How the pizza should be cooked.<p>
     * 
     * {@link #cookingPrice} should reflect the cooking strategy.
     */
	protected ICookingStrategy cookingStrategy;
	
	/**
	 * The cost of the selected cooking strategy
	 */
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
	
	/**
	 * Returns a copy of the current object.
	 */
	public abstract AbstractPizza copy();
	
    /**
     * Updates the pizza price to accurately reflect the toppings in the {@link AbstractPizza#toppingList}.<p>
     * 
     * The price of the pizza should be updated when toppings are added to avoid price discrepancy.
     * @return the total price of the pizza
     */
    public abstract double updatePizzaPrice();
    
	// Get the list of toppings
    public List<Toppings> getToppingList() {
        return toppingList;
    }
    
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
