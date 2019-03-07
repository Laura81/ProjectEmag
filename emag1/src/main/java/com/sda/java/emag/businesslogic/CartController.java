package com.sda.java.emag.businesslogic;

/* Create class CartController to provide an User the methods for updating this cart from a stock
(or a list of stocks). It will contain an instance of a Cart and an instance of at least one Stock.
Add methods addItemCart(), removeItemFromCart(), removeAllCartItems().
 */

import com.sda.java.emag.item.Item;

import java.util.LinkedHashMap;
import java.util.Map;

public class CartController {
    private final Cart cart = new Cart(new LinkedHashMap<>()); //only managed by the controller
    private final Stock stock; // can be updated by a supplier, therefore the instance is injected


    public CartController(Stock stock) {
        this.stock = stock;
    }

    public int addItemCart(Item item, int quantity){
        int retrieveItem = stock.retrieveItem(item, quantity);
        cart.addCartItem(item, retrieveItem);
        return retrieveItem;
    }

    public int removeItemFromCart(Item item, int quantity){
        int removeItem = cart.removeItem(item, quantity);
        return stock.addItem(item, removeItem);
    }

    public int removeAllCartItems(){
        final Map<Item, Integer> removedItems = cart.removeAll();
        for( Map.Entry<Item, Integer> entry: removedItems.entrySet()){
            stock.addItem(entry.getKey(), entry.getValue());
        }
        return removedItems.entrySet().size();

        // sau
        /* removedItems.forEach(stock::addItem); - not functional oriented programming
        return removedItems.entrySet().size();
         */
    }


}
