/* AUTHOR: Paul Castelo
   DATE: 07/27/19
   DESCRIPTION: A program that builds a pizza order and simulates baking as a task in the background.
 */

package com.axosclearing.codingchallenge.pizzashop;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // TODO implement
        //Finds the csv file in the resources folder
        String fileName = "ingredient_inventory.csv";
        ClassLoader classLoader = new Main().getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        //checking to see if the program finds the file
        System.out.println(file.exists() + "\n");
        //Loading values onto an array
        String[] content = new String(Files.readAllBytes(file.toPath())).split(", |\\n");
        //Checking to see if values are loaded as intended
        //System.out.println(Arrays.toString(content));

        //Preparing to load map with array 'content'
        HashMap<String, Integer> ingredients = new HashMap<>();
        //Putting values in map: 'ingredient,amount'
        for(int i = 2; i < content.length; i+=2) {
            ingredients.put(content[i],Integer.parseInt(content[i+1]));
        }

        Scanner userin = new Scanner(System.in);

        //User enters pizza building loop
        System.out.println("Build a pizza? yes or no");
        String choice1 = userin.next();
        while(choice1.equalsIgnoreCase("yes")) {

            String topping;
            String builtpizza = " ";
            String choice2 = "yes";
            while(choice2.equalsIgnoreCase("yes")) {

                System.out.println();
                System.out.println("**CHOOSE A TOPPING**");
                System.out.println("ham - stock: " + ingredients.get("ham"));
                System.out.println("pineapples - stock: " + ingredients.get("pineapples"));
                System.out.println("sausage - stock: " + ingredients.get("sausage"));
                System.out.println("pepperoni - stock: " + ingredients.get("pepperoni"));
                System.out.println("mushroom - stock: " + ingredients.get("mushroom"));
                System.out.println("jalapeno - stock: " + ingredients.get("jalapeno"));
                System.out.println("extra cheese - stock: " + ingredients.get("cheese"));
                System.out.println("**END OF MENU**");


                System.out.print("Enter your choice: ");
                topping = userin.next();
                System.out.println();

                if(ingredients.get(topping) > 0) {

                    switch(topping) {
                        case "ham":
                            ingredients.replace("ham", ingredients.get("ham") - 1);
                            builtpizza += "ham ";
                            break;

                        case "pineapples":
                            ingredients.replace("pineapples", ingredients.get("pineapples") - 1);
                            builtpizza += "pineapples ";
                            break;

                        case "sausage":
                            ingredients.replace("sausage", ingredients.get("sausage") - 1);
                            builtpizza += "sausage ";
                            break;

                        case "pepperoni":
                            ingredients.replace("pepperoni", ingredients.get("pepperoni") - 1);
                            builtpizza += "pepperoni ";
                            break;

                        case "mushroom":
                            ingredients.replace("mushroom", ingredients.get("mushroom") - 1);
                            builtpizza += "mushroom ";
                            break;

                        case "jalapeno":
                            ingredients.replace("jalapeno", ingredients.get("jalapeno") - 1);
                            builtpizza += "jalapeno ";
                            break;

                        case "cheese":
                            ingredients.replace("cheese", ingredients.get("cheese") - 1);
                            builtpizza += " extra-cheese ";
                            break;

                        default:
                            System.out.println("NO TOPPING CHOSEN");

                    }

                } else {

                    System.out.println("SORRY WE ARE OUT OF " + topping + ".");
                }

                System.out.println("Add another topping? yes or no");
                choice2 = userin.next();
            }

            if(!builtpizza.equals(" ")){

                System.out.println("\nYou ordered a " + builtpizza + " pizza.\n");
                System.out.println("It's in the oven now...");
                bake(builtpizza);
            }
            else {

                System.out.println("\nYou did not order this round.\n");
            }


            System.out.println("Build another pizza? yes or no");
            choice1 = userin.next();
        }

        System.out.println();
        System.out.println("THANK YOU GOODBYE!");

    }

    //30 second timer to simulate baking
    public  static void bake(String pizza) {

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("\nYour "+ pizza + " pizza is ready!\n");
                        cancel();
                    }
                },
                30000
        );
    }

}
