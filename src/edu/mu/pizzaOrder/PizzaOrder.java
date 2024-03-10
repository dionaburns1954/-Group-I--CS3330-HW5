package edu.mu.pizzaOrder;


import java.util.List;
import java.util.ArrayList;

public class PizzaOrder {
	
	private PizzaCookingFactory pizzaFactory;
	private ICookingStrategy cookingStrategy;
	private List<AbstractPizza> pizzaOrderList;
	
	public PizzaOrder() {
		
	}
	
	// Method to print list of toppings by Pizza Order ID
    public void printListOfToppingsByPizzaOrderID(int orderID) {
        // TODO: Implement method
    }

    // Method to print pizza order cart
    public void printPizzaOrderCart(int orderID) {
        // TODO: Implement method
    }

    // Method to get pizza by order ID
    public AbstractPizza getPizzaByOrderID(int orderID) {
        // TODO: Implement method
    }

    // Method to add pizza to cart
    public boolean addPizzaToCart(PizzaType pizzaType) {
        // TODO: Implement method
    }

    // Method to add new topping to pizza
    public boolean addNewToppingToPizza(int orderID, Toppings topping) {
        // TODO: Implement method
    }

    // Method to remove topping from pizza
    public boolean removeToppingFromPizza(int orderID, Toppings topping) {
        // TODO: Implement method
    }

    // Method to check if there are any uncooked pizzas
    public boolean isThereAnyUncookedPizza() {
        // TODO: Implement method
    }

    // Method for checkout
    public double checkout() throws Exception {
        // TODO: Implement method
    }

    // Method to select cooking strategy by Pizza Order ID
    public boolean selectCookingStrategyByPizzaOrderID(int orderID, CookingStyleType cookingStrategyType) {
        // TODO: Implement method
    }

}
