package com.sda.java.coffeemachine.menu;

import com.sda.java.coffeemachine.CoffeeType;

public class Espresso extends Coffee {

    private static final CoffeeType ESPRESSO = CoffeeType.ESPRESSO;

    public Espresso(){

        super(ESPRESSO);
    }

    protected String getCoffeeName() {
        return ESPRESSO.toString();
    }
}
