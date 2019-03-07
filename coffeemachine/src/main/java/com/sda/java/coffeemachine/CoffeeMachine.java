package com.sda.java.coffeemachine;

import com.sda.java.coffeemachine.menu.Coffee;
import com.sda.java.coffeemachine.menu.Espresso;
import com.sda.java.coffeemachine.menu.FilterCoffee;
import com.sda.java.coffeemachine.menu.Latte;

public class CoffeeMachine {

    private final StockC stockC = new StockC();
    private CoffeeType coffeeType = CoffeeType.FILTERCOFFEE;


    public static void main(String[] args) throws Exception {
        final CoffeeMachine coffeeMachine = new CoffeeMachine();
        StockC stockC = coffeeMachine.getStockC();


        //user selects coffee type
        coffeeMachine.chooseCoffee(CoffeeType.LATTE);

        //user presses start
        final Coffee coffee = coffeeMachine.prepareCoffee();
        System.out.println("Consuming the coffee: " + coffee);
    }

    public void chooseCoffee(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }

    public StockC getStockC() {
        return stockC;
    }

    public Coffee prepareCoffee() throws Exception {
        if (stockC.getIngredient() > coffeeType.getBeansRequired() &&
                stockC.getIngredient() > coffeeType.getWaterRequired() &&
                stockC.getIngredient() > coffeeType.getSugarRequired() &&
                stockC.getIngredient() > coffeeType.getMilkRequired()) {
            stockC.removeBeansFromStock(coffeeType.getBeansRequired());
            stockC.removeWaterFromStock(coffeeType.getWaterRequired());
            stockC.removeSugarFromStock(coffeeType.getSugarRequired());
            stockC.removeMilkFromStock(coffeeType.getMilkRequired());
            return createCoffee();
        }
        throw new Exception("Cannot create coffee");
    }

    private Coffee createCoffee() {
        switch (coffeeType) {
            case LATTE:
                return new Latte();
            case ESPRESSO:
                return new Espresso();
            case FILTERCOFFEE:
                return new FilterCoffee();
            default:
                return new FilterCoffee();
        }
    }
}
