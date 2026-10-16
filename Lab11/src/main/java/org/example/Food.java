package org.example;

public class Food extends Product {
    public Food(String name, double price, double weight) {
        super(name, price, weight);
    }

    @Override
    public double getDiscount() {
        return 15;
    }
}
