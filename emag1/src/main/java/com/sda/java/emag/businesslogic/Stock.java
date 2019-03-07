package com.sda.java.emag.businesslogic;

import com.sda.java.emag.item.Item;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;


public class Stock implements Serializable {
    private static final String SEPARATOR = " ";
    private final long serialVersionUID = 1L;
    private Map<Item, Integer> items;
    private final transient Object mutex;

    public Stock(Map<Item, Integer> items, Object mutex) {
        this.items = items;
        this.mutex = mutex;
    }

    public int addItem(Item item, int supplyQuantity) {
        final Integer previousValue = items.putIfAbsent(item, supplyQuantity);
        if (previousValue == null) {
            return supplyQuantity;
        }

        synchronized (mutex) {
            final int supply = items.get(item) + supplyQuantity;
            items.put(item, supply);
            return supply;
        }
        //  if (items.containsKey(item)) {
        //   final int supply;
        //   supply = items.get(item) + supplyQuantity;
        //   items.put(item, supply);
        //  return supply;
    }
    //  items.put(item, supplyQuantity);
    //  return supplyQuantity;
    // }


    public synchronized int retrieveItem(Item item, int requestedQuantity) {
        if (!items.containsKey(item)) {
            return 0;
        }
        int currentQuantity = items.get(item);
        if (currentQuantity < requestedQuantity) {
            items.put(item, 0);
            return currentQuantity;
        }
        int updatedQuantity = currentQuantity - requestedQuantity;
        items.put(item, updatedQuantity);
        return requestedQuantity;
    }

    public String showItems() {
        final StringBuilder displayResult = new StringBuilder();
        for (Map.Entry<Item, Integer> itemEntry : items.entrySet()) {
            final Item item = itemEntry.getKey();
            displayResult.append(item.showDetails());
            displayResult.append(SEPARATOR);
            displayResult.append("Stock: ");
            displayResult.append(itemEntry.getValue());
            displayResult.append(System.lineSeparator());

        }
        return displayResult.toString();

    }

    public void saveState() throws IOException {
        final FileOutputStream fileOutputStream = new FileOutputStream("stock.txt");
        final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
        fileOutputStream.close();

    }

    public void loadState() throws IOException, ClassNotFoundException {
        if (!Files.exists(Paths.get("stock.txt"))) {
            return;
        }
        final FileInputStream fileInputStream = new FileInputStream("stock.txt");
        final BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        final ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
        final Stock readObject = (Stock) objectInputStream.readObject();
        items = readObject.items;
        objectInputStream.close();
        fileInputStream.close();


    }


}


