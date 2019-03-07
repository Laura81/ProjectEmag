package com.sda.java.coffeemachine.menu;

import com.sda.java.coffeemachine.CoffeeType;

public class FilterCoffee extends Coffee {


    private static final CoffeeType FILTERCOFFEE = CoffeeType.FILTERCOFFEE;

    public FilterCoffee() {

        super(FILTERCOFFEE);
    }

    protected String getCoffeeName() {
        return FILTERCOFFEE.toString();
    }
}
