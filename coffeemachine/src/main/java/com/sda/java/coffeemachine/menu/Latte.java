package com.sda.java.coffeemachine.menu;

import com.sda.java.coffeemachine.CoffeeType;

public class Latte extends Coffee {


    private static final CoffeeType LATTE = CoffeeType.LATTE;

    public Latte() {

        super(LATTE);
    }

    protected String getCoffeeName() {
        return LATTE.toString();
    }
}