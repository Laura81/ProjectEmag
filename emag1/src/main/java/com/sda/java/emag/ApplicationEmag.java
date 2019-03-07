package com.sda.java.emag;

import com.sda.java.emag.businesslogic.Cart;
import com.sda.java.emag.businesslogic.CartController;
import com.sda.java.emag.businesslogic.Stock;
import com.sda.java.emag.businesslogic.User;
import com.sda.java.emag.item.Color;
import com.sda.java.emag.item.Phone;
import com.sda.java.emag.item.Shoes;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationEmag {
    public static final String NIKE_AIR = "Nike air";
    public static final int PRICE1 = 200;
    public static final String NIKE = "Nike";
    public static final Color BLUE = Color.BLUE;
    public static final int SIZE = 24;
    private static final String PHONE_NAME = "X";
    private static final float DISPLAY_SIZE = 6.4f;
    private static final String CPU = "A10";
    private static final String BRAND = "Iphone";
    private static final int PRICE = 1000;
    private static final float COMPARE_DOUBLE_DELTA = 0.01f;
    private static final int AVAILABLE_QUANTITY = 100000;
    private static final int REQUESTED_QUANTITY = AVAILABLE_QUANTITY;


    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        final Object stockMutex = new Object();
        final Stock baneasaMall = new Stock(new ConcurrentHashMap<>(), stockMutex);


        final Phone iphoneX = new Phone(PHONE_NAME, PRICE, BRAND, CPU, DISPLAY_SIZE);
        final Shoes nike = new Shoes(NIKE_AIR, PRICE1, NIKE, BLUE, SIZE);
        final Cart cart = new Cart(new HashMap<>());
        baneasaMall.addItem(iphoneX, AVAILABLE_QUANTITY);
        final User anca = new User(new CartController(baneasaMall), iphoneX, REQUESTED_QUANTITY);
        final User george = new User(new CartController(baneasaMall), iphoneX, REQUESTED_QUANTITY);
        final Thread ancaThread = new Thread(anca);
        final Thread georgeThread = new Thread(george);

        ancaThread.start();
        georgeThread.start();

        ancaThread.join();
        georgeThread.join();

        int ancaretrievedItemsQuantity = anca.getRetrievedItemsQuantity();
        System.out.println("Anca's retrieve items quantity: " + ancaretrievedItemsQuantity);
        int georgeretrievedItemsQuantity = george.getRetrievedItemsQuantity();
        System.out.println("George's retrieve items quantity: " + georgeretrievedItemsQuantity);
        System.out.println("Stock items: " + AVAILABLE_QUANTITY);

        // user(baneasaMall, iphoneX);
        // baneasaMall.loadState();
        // System.out.println("Loaded item:\n " + baneasaMall.showItems());
        // baneasaMall.saveState();
        // final CartController cartController = new CartController(baneasaMall);
        // final User user1 = new User(cartController, iphoneX, 100000);
        // final User user2 = new User(cartController, iphoneX, 10000);
        // Thread userThread1 = new Thread(user1);
        // Thread userThread2 = new Thread(user2);
        //  userThread1.start();
        //   userThread2.start();
        //  userThread1.join();
        //  userThread2.join();
        //  user1.getRetrievedItemsQuantity();


    }

    private static void user(Stock baneasaMall, Phone iphoneX) {
        final int supply_quantity = 100000;
        final int consume_quantity = 3;
        final int currentIphoneStock = baneasaMall.addItem(iphoneX, supply_quantity);
        final Cart cart = new Cart(new HashMap<>());
        final Shoes nike = new Shoes(NIKE_AIR, PRICE1, NIKE, BLUE, SIZE);
        System.out.println("Initially Iphone X stock quantity: " + currentIphoneStock);

        int retrieveIphoneQuantity = baneasaMall.retrieveItem(iphoneX, consume_quantity);
        System.out.println("Received Iphone X quantity1: " + retrieveIphoneQuantity);
        retrieveIphoneQuantity = baneasaMall.retrieveItem(iphoneX, consume_quantity);
        System.out.println("Received Iphone X quantity2: " + retrieveIphoneQuantity);
        System.out.println(baneasaMall.showItems());

        cart.addCartItem(iphoneX, 10);
        cart.addCartItem(nike, 100);
        try {
            cart.print();
        } catch (IOException e) {
            System.out.println("Cannot acces file " + e.getMessage());
        }

    }

}
