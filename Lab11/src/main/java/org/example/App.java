package org.example;

public class App {
    public static void main(String[] args) {
        try {
            var product = new Product("Товар", 100.0, 1.0);
            product.sell();
            product.sell(12);
            product.sell(product.getDiscount());
            System.out.println();
            var food = new Food("Калбоса", 10.0, 0.5);
            food.sell();
            food.sell(205);
            food.sell(food.getDiscount());
            System.out.println();
            var electronics = new Electronics("Микроволновка", 200.0, 2.0);
            electronics.sell();
            electronics.sell(120);
            electronics.sell(electronics.getDiscount());
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
