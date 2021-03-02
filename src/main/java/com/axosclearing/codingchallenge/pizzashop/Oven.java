package com.axosclearing.codingchallenge.pizzashop;
import java.util.Timer;
import java.util.TimerTask;

public class Oven {
    public void addPizza(String name) {

        Timer newPizza = new Timer();
        newPizza.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(name + " pizza is finished.");
                System.out.print("Topping> ");
                newPizza.cancel();
            }
        }, 5 * 1000);
    }

//    public static void main(String[] args) {
//        Oven oven = new Oven();
//        oven.addPizza("First");
//        System.out.println("here");
//    }
}
