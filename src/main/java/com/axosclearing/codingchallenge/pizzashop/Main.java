package com.axosclearing.codingchallenge.pizzashop;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.HashSet;
import java.lang.StringBuilder;
import java.util.ArrayList;

public class Main {
    public static String joinToppings(HashSet<String> toppingsSet) {
        ArrayList<String> keys = new ArrayList<>(toppingsSet);
        StringBuilder joinedToppings = new StringBuilder();
        if (keys.size() == 1) {
            joinedToppings.append(keys.get(0));
            return joinedToppings.toString();
        } else if (keys.size () == 0) {
            joinedToppings.append("no topping");
            return joinedToppings.toString();
        }
        for (int i = 0; i < keys.size(); i += 1) {
            if (i == keys.size() - 1 && keys.size() > 2) {
                joinedToppings.append(", and " + keys.get(i));
            } else if (i == keys.size() - 1 && keys.size() == 2) {
                joinedToppings.append(" and " + keys.get(i));
            } else if (i == 0) {
                joinedToppings.append(keys.get(i));
            } else {
                joinedToppings.append(", " + keys.get(i));
            }
        }
        return joinedToppings.toString();
    }
    public static void main(String[] args) {
        // Insert CSV file info into Inventory
        Path path = Paths.get("./src/main/resources/ingredient_inventory.csv");
        File file = new File(path.toString());
        Inventory inventory = new Inventory(file);
        Oven oven = new Oven();

        // Store Inputs
        HashSet<String> toppings = new HashSet<>();

        // Obtain inputs
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter \"exit\" to exit.");
        System.out.println("Now serving pizzas, enter your toppings");
        System.out.print("Topping> ");
        String entry = scanner.nextLine();
        while (!entry.equals("exit")) {
            // Finished ordering
            if (entry.equals("")) {
                String joinedToppings = joinToppings(toppings);
                System.out.println("Placing an order for a " + joinedToppings + " pizza...\n");
                oven.addPizza(joinedToppings);
                toppings.clear();
            // Valid topping ordered
            } else if (inventory.getStock(entry) > 0) {
                toppings.add(entry);
                inventory.useItem(entry);
            // Invalid topping ordered
            } else if (inventory.getStock(entry) == -1) {
                System.out.println("Topping doesn't exist");
            // Out of stock topping ordered
            } else if (inventory.getStock(entry) == 0) {
                System.out.println(entry + " is out of stock.");
            }
            System.out.print("Topping> ");
            entry = scanner.nextLine();
        }
    }
}