package com.sda.java.emag.item;

import com.sda.java.emag.businesslogic.Displayable;

import java.io.Serializable;
import java.util.Objects;

public abstract class Item implements Displayable, Serializable {

    private final String name;
    private final Category category;
    private float price;
    static final String SEPARATOR = " ";

    Item(Category category, String name, float price) { //packege private
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public String getItemDetails(){
        final StringBuilder displayResult = new StringBuilder();
        displayResult.append("Name: ");
        displayResult.append(name);
        displayResult.append(SEPARATOR);
        displayResult.append("Price: ");
        displayResult.append(price);
        displayResult.append(SEPARATOR);
        displayResult.append("Category: ");
        displayResult.append(category);
        return displayResult.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Float.compare(item.price, price) == 0 &&
                Objects.equals(name, item.name) &&
                category == item.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, price);
    }
}

