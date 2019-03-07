package com.sda.java.coffeemachine;

import java.util.HashMap;
import java.util.Map;

public class StockC {

    private Map<Ingredient, Integer> ingredients = new HashMap<Ingredient, Integer>();

    public StockC() {
        for(Ingredient eachIngredient: Ingredient.values()){
            ingredients.put(eachIngredient,0);
        }
    }

    public int getIngredient(Ingredient ingredient) throws Exception {
        if(!ingredients.containsKey(ingredient)) {
            throw new Exception("404 Ingredient not foud: "+ ingredient);
            }
        return ingredients.get(ingredient);

        }

    public void addToStock (Ingredient ingredient, int addQuantity) {
        if (!ingredients.containsKey(ingredient)) {
            System.out.println("The ingredient doesn't exist: ");
        }
        int currentQuantity = ingredients.get(ingredient);
        ingredients.put(ingredient, addQuantity + currentQuantity);
    }


    public void removeFromStock(Ingredient ingredient, int removeQuantity){
        int currentQuantity = ingredients.get(ingredient);
        ingredients.(ingredient, currentQuantity-removeQuantity);
    }

}
