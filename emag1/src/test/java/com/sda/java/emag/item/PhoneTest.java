package com.sda.java.emag.item;

import com.sda.java.emag.item.Phone;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PhoneTest {

    private static final String PHONE_NAME = "X";
    private static final float DISPLAY_SIZE = 6.4f;
    private static final String CPU = "A10";
    private static final String BRAND = "Iphone";
    private static final int PRICE = 1000;
    private static final float COMPARE_DOUBLE_DELTA = 0.01f;

    @Test
    public void itCreateAPhone(){
        //Given

        //When
        final Phone iphone = new Phone(PHONE_NAME, PRICE, BRAND, CPU, DISPLAY_SIZE);

        //Then
        assertNotNull(iphone);
        assertEquals(PHONE_NAME, iphone.getName());
        assertEquals(PRICE, iphone.getPrice(), COMPARE_DOUBLE_DELTA);
        assertEquals(BRAND,  iphone.getBrand());
        assertEquals(CPU, iphone.getCpu());
        assertEquals(DISPLAY_SIZE, iphone.getDisplay_size(), COMPARE_DOUBLE_DELTA);
        assertEquals(Phone.CATEGORY, iphone.getCategory());

    }
}
