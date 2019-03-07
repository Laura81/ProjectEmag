package com.sda.java.emag.item;


import java.util.Objects;

public class Phone extends Item {

    public static final Category CATEGORY = Category.ELECTRONICS;
    private final String brand;
    private final String cpu;
    private final float display_size;


    public Phone( String name, float price, String brand, String cpu, float display_size) {
        super(CATEGORY, name, price); //super trebuie sa fie intotdeauna in prima linie
        this.brand = brand;
        this.cpu = cpu;
        this.display_size = display_size;
    }

    public String getBrand() {
        return brand;
    }

    public String getCpu() {
        return cpu;
    }

    public float getDisplay_size() {
        return display_size;
    }

    public String showDetails(){
        final StringBuilder displayResult = new StringBuilder();
        displayResult.append(getItemDetails());
        displayResult.append(SEPARATOR);
        displayResult.append("Brand: ");
        displayResult.append(brand);
        displayResult.append(SEPARATOR);
        displayResult.append("Processor: ");
        displayResult.append(cpu);
        displayResult.append(SEPARATOR);
        displayResult.append("Display: ");
        displayResult.append(display_size);
        return displayResult.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Phone phone = (Phone) o;
        return Float.compare(phone.display_size, display_size) == 0 &&
                Objects.equals(brand, phone.brand) &&
                Objects.equals(cpu, phone.cpu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), brand, cpu, display_size);
    }
}






