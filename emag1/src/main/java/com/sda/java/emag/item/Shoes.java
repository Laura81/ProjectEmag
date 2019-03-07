package com.sda.java.emag.item;


import java.util.Objects;

public class Shoes extends Item {
    private final String brand;
    private final Color color;
    private final int size;


    public Shoes( String name, float price, String brand, Color color, int size) {
        super(Category.FASHION, name, price);
        this.brand = brand;
        this.color = color;
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public Color getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public String showDetails(){
        final StringBuilder displayResult = new StringBuilder();
        displayResult.append(getItemDetails());
        displayResult.append(SEPARATOR);
        displayResult.append(brand);
        displayResult.append(SEPARATOR);
        displayResult.append(color);
        displayResult.append(SEPARATOR);
        displayResult.append(size);
        return displayResult.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Shoes shoes = (Shoes) o;
        return size == shoes.size &&
                Objects.equals(brand, shoes.brand) &&
                color == shoes.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), brand, color, size);
    }
}


