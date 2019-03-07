package com.sda.java.emag.businesslogic;
/* Create User calss, implements Runnable, which tries to get an specified amount
of items and the item itself, or stop after 5s

 */

import com.sda.java.emag.item.Item;

public class User implements Runnable {

    private final CartController cartController;
    private final Item requestedItem;
    private final int requestedQuantity;
    private static final int MILLISECONDS_TO_SECONDS_RATIO = 1000;
    private static final int RUN_TIME_SECONDS = 5;
    private static final int MAX_QUANTITY_PER_REQUEST = 1;
    private int retrievedItemsQuantity;

    public User(CartController cartController, Item item, int quantity) {
        this.cartController = cartController;
        this.requestedItem = item;
        this.requestedQuantity = quantity;

    }

    public int getRetrievedItemsQuantity() {
        return retrievedItemsQuantity;
    }


    @Override
    public void run() {

        retrievedItemsQuantity = 0;
        final long startTime =  System.currentTimeMillis();
        while ((retrievedItemsQuantity < requestedQuantity)&&(getElapsedTimeInSeconds(startTime)<RUN_TIME_SECONDS)) {
            retrievedItemsQuantity += cartController.addItemCart(requestedItem, MAX_QUANTITY_PER_REQUEST);
        }
    }

    private int getElapsedTimeInSeconds(long startTime) {
        return new Long((System.currentTimeMillis() - startTime) / MILLISECONDS_TO_SECONDS_RATIO).intValue();
    }


}
