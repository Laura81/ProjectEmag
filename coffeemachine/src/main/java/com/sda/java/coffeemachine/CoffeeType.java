package com.sda.java.coffeemachine;

public enum CoffeeType {
    ESPRESSO(5, 50, 0, 0),
    LATTE(2,100, 5, 100),
    FILTERCOFFEE (5, 100, 5, 0);

        private final int beansRequired;
        private final int waterRequired;
        private final int sugarRequired;
        private final int milkRequired;

    CoffeeType(int coffeeRequired, int water, int sugar, int milk) {
        this.beansRequired = coffeeRequired;
        this.waterRequired = water;
        this.sugarRequired = sugar;
        this.milkRequired = milk;
    }

    public int getBeansRequired() {
        return beansRequired;
    }

    public int getWaterRequired() {
        return waterRequired;
    }

    public int getSugarRequired() {
        return sugarRequired;
    }

    public int getMilkRequired() {
        return milkRequired;
    }
}
