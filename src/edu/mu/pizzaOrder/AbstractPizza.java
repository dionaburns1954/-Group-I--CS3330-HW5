package edu.mu.pizzaOrder;

import java.util.List;
import java.util.ArrayList;

public abstract class AbstractPizza {
	protected List<Toppings> toppingList;
    protected double priceWithoutToppings;
    protected double totalPrice;
    protected int pizzaOrderID;
    protected static int orderIDCounter;
    protected ICookingStrategy cookingStrategy;
    protected double cookingPrice;
    
    public AbstractPizza() {
        toppingList = new ArrayList<>();
        // Initialize other attributes here
    }
    
 // Getter and setter methods for toppingList
    public List<Toppings> getToppingList() {
        return toppingList;
    }

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
