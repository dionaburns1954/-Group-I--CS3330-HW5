package edu.mu.main;

import edu.mu.pizzaOrder.CookingStyleType;
import edu.mu.pizzaOrder.PizzaOrder;
import edu.mu.pizzaOrder.PizzaType;
import edu.mu.pizzaOrder.Toppings;

public class Main {
	public static void main(String[] args) {
		// Instantiate a pizzaOrder, perform operations based on the requirements.
		PizzaOrder order = new PizzaOrder();
		// Adds pizzas to the cart, selects cooking strategies for the pizzas in the cart, prints pizza order cart. Calls checkout to calculate the bill, throws exception if triggered.

		order.addPizzaToCart(PizzaType.MARGHERITA);
		order.addPizzaToCart(PizzaType.SUPREME);
		order.addPizzaToCart(PizzaType.VEGETARIAN);
		order.addPizzaToCart(PizzaType.HAWAIIAN);
		
		System.out.println("Cart:");
		order.printPizzaOrderCart(0);
		
		System.out.println("\nToppings of pizza 0:");
		order.printListOfToppingsByPizzaOrderID(0);
	
		// Add some toppings
		order.addNewToppingToPizza(0, Toppings.PEPPERONI);
		order.addNewToppingToPizza(0, Toppings.PINEAPPLE);
		
		order.printListOfToppingsByPizzaOrderID(0);
		
		System.out.println("\nTest removing toppings:");
		order.removeToppingFromPizza(0, Toppings.PEPPERONI);
		
		order.printListOfToppingsByPizzaOrderID(0);
		
		System.out.println("\nUpdated cart:");
		order.printPizzaOrderCart(0);
		
		// Add the cooking methods
		order.selectCookingStrategyByPizzaOrderID(0, CookingStyleType.BRICK_OVEN);
		order.selectCookingStrategyByPizzaOrderID(1, CookingStyleType.MICROWAVE);
		order.selectCookingStrategyByPizzaOrderID(2, CookingStyleType.CONVENTIONAL_OVEN);
		order.selectCookingStrategyByPizzaOrderID(3, CookingStyleType.BRICK_OVEN);

		System.out.println("\nFinal cart:");
		order.printPizzaOrderCart(0);
		
		try {
			System.out.println(order.checkout());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}