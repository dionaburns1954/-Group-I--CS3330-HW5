# -Group-I--CS3330-HW5

## Description
This program is supposed to simulate a pizza ordering service. A user is supposed to give an order that includes a certain number of pizzas. The user can select what type of toppings they want on the pizza and how they would like it cooked. At the end, the user can checkout and the program will return the price of their order. 

## How To Run
To Run this program just copy the git repository into your eclipse IDE and go into the Main file. From there you can create an instance of a PizzaOrder where you can order pizza using any of the methods provided in the PizzaOrder class.

## Classes/ Sub Classes
-Abstract Pizza
-- Hawaiian Pizza
-- VegetarianPizza
-- MargheritaPizza
-- SupremePizza

-ICookingStrategy
--MicrowaveCookingStrategy
--ConventionalOvenCookingStrategy
--BrickOvenCookingStrategy

## Pizza Orders Methods
- public void printListOfToppingsByPizzaOrderID(int orderID)
- public void printPizzaOrderCart(int orderID)
- public AbstractPizza getPizzaByOrderID(int orderID)
- public boolean addPizzaToCart(PizzaType pizzaType)
- public boolean addNewToppingToPizza(int orderID, Toppings topping)
-  public boolean removeToppingFromPizza(int orderID, Toppings topping)
-  public boolean isThereAnyUncookedPizza()
-   public double checkout() throws Exception
-   public boolean selectCookingStrategyByPizzaOrderID(int orderID, CookingStyleType cookingStrategyType)



## Enums 
- Pizzatype
- Toppings
- CookingStyleType

## Pizza Cooking Factory 
- public AbstractPizza createPizza(PizzaType pizzaType)
- private void incrementOrderID()
- private void assignPizzaOrderId(AbstractPizza p)


## Dependencies
Java JDK 21

## Team Members
- Alber Zhou
- Dion Burns
- Logan Bird
- Ryan Esparza
