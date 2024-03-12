# -Group-I--CS3330-HW5

## Description


## How To Run

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
