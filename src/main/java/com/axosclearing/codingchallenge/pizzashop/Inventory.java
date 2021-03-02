package com.axosclearing.codingchallenge.pizzashop;
import java.util.HashMap;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Inventory {
    private HashMap<String, Integer> stock = new HashMap<>();
    public Inventory(File file) {
        // Reads ingredients from file and enters into hash map
        try {
            Scanner reader = new Scanner(file);
            // Skip description line
            reader.nextLine();
            while (reader.hasNextLine()) {
                String[] line = (reader.nextLine()).split(", ", 2);
                stock.put(line[0], Integer.parseInt(line[1]));
            }
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    public int getStock(String item) {
        if (stock.containsKey(item)) {
            return stock.get(item);
        }
        return -1;
    }
    public boolean useItem(String item) {
        if (stock.containsKey(item)) {
            int itemStock = stock.get(item);
            if (itemStock > 0) {
                stock.put(item, itemStock - 1);
                return true;
            }
        }
        return false;
    }
}
