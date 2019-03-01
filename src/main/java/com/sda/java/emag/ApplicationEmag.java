package com.sda.java.emag;

import com.sda.java.emag.businesslogic.Cart;
import com.sda.java.emag.businesslogic.Stock;
import com.sda.java.emag.item.Color;
import com.sda.java.emag.item.Phone;
import com.sda.java.emag.item.Shoes;

import java.io.IOException;
import java.util.HashMap;

public class ApplicationEmag {
    private static final String PHONE_NAME = "X";
    private static final float DISPLAY_SIZE = 6.4f;
    private static final String CPU = "A10";
    private static final String BRAND = "Iphone";
    private static final int PRICE = 1000;
    private static final float COMPARE_DOUBLE_DELTA = 0.01f;
    public static final String NIKE_AIR = "Nike air";
    public static final int PRICE1 = 200;
    public static final String NIKE = "Nike";
    public static final Color BLUE = Color.BLUE;
    public static final int SIZE = 24;


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Stock baneasaMall = new Stock(new HashMap<>());
        baneasaMall.loadState();
        System.out.println("Loaded item:\n "+baneasaMall.showItems());
        final Phone iphoneX = new Phone(PHONE_NAME, PRICE, BRAND, CPU, DISPLAY_SIZE);
        final Shoes nike = new Shoes(NIKE_AIR, PRICE1, NIKE, BLUE, SIZE);
        final Cart cart = new Cart(new HashMap<>());

        final int supply_quantity = 5;
        final int consume_quantity = 3;
        final int currentIphoneStock = baneasaMall.addItem(iphoneX, supply_quantity);
        System.out.println("Initially Iphone X stock quantity: " + currentIphoneStock);

        int retrieveIphoneQuantity = baneasaMall.retrieveItem(iphoneX, consume_quantity);
        System.out.println("Received Iphone X quantity1: "+ retrieveIphoneQuantity);
        retrieveIphoneQuantity = baneasaMall.retrieveItem(iphoneX, consume_quantity);
        System.out.println("Received Iphone X quantity2: "+ retrieveIphoneQuantity);
        System.out.println(baneasaMall.showItems());

        cart.addCartItem(iphoneX, 20);
        cart.addCartItem(nike, 100);
        try{
            cart.print();
        } catch (IOException e) {
            System.out.println("Cannot acces file " + e.getMessage());
        }

        baneasaMall.saveState();


    }
}
