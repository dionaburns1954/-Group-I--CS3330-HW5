# -Group-I--CS3330-HW5

## Description
This program is supposed to simulate a pizza ordering service. A user is supposed to give an order that includes a certain number of pizzas. The user can select what type of toppings they want on the pizza and how they would like it cooked. At the end, the user can checkout and the program will return the price of their order. This program utilizes the factory creation pattern to create new pizzas and add them to the user's order. 

## How To Run
To Run this program just copy the git repository into your eclipse IDE and go into the Main file. From there you can create an instance of a PizzaOrder where you can order pizza using any of the methods provided in the PizzaOrder class.

## Classes/ Sub Classes / Interfaces
- Abstract Pizza
- Hawaiian Pizza
- VegetarianPizza
- MargheritaPizza
- SupremePizza

- ICookingStrategy
- MicrowaveCookingStrategy
- ConventionalOvenCookingStrategy
- BrickOvenCookingStrategy

## Pizza Orders Methods
- public void printListOfToppingsByPizzaOrderID(int orderID)
  -  method that prints the toppings of a specific pizza that is in the user's cart.
- public void printPizzaOrderCart(int orderID)
   - prints all the user's pizzas in their cart.
- public AbstractPizza getPizzaByOrderID(int orderID)
  - returns a specific pizza in the user's cart.
- public boolean addPizzaToCart(PizzaType pizzaType)
  - adds a pizza to the user's cart. Returns true if the pizza was successfully added to the cart, otherwise the method returns false.
- public boolean addNewToppingToPizza(int orderID, Toppings topping)
  - adds a new topping to a selected pizza in the user's cart. The method returns true if a new topping was successfully added, otherwise the method returns false.
-  public boolean removeToppingFromPizza(int orderID, Toppings topping)
  - removes a topping from a selected pizza in the user's cart. The function returns true if the topping was successfully removed, otherwise the method returns false.
-  public boolean isThereAnyUncookedPizza()
  - method that checks if there are any uncooked pizzas in the user's cart. If there are any uncooked pizzas in the cart, the method will return true, otherwise the method will return false.
-   public double checkout() throws Exception
  - method that tries to process the user's order. If there are any uncooked pizzas in the user's order, the method will throw an exception and the checkout will not occur. If there aren't any uncooked pizzas in the user's cart, then the method will calculate the total price of the user's order and return that value. 
-   public boolean selectCookingStrategyByPizzaOrderID(int orderID, CookingStyleType cookingStrategyType)
  - method that selects a cooking style for a particular pizza in the user's order. The method will return true if a cooking style was successfully attached to the specified pizza, otherwise the method will return false.



## Enums 
- Pizzatype
  - enum of pizza types supported by the program
- Toppings
  - enum of toppings that are supported by the program
- CookingStyleType
  - enum of cooking styles that the user can select from

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
