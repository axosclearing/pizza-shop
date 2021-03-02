package com.axosclearing.codingchallenge.pizzashop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) {
        // TODO implement
        Path path = Paths.get("./src/main/resources/ingredient_inventory.csv");
        File file = new File(path.toString());
        Inventory inventory = new Inventory(file);
    }
}