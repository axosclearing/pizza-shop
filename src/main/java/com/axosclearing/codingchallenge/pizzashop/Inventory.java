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
                System.out.print(reader.nextLine());
            }
        } catch(IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
