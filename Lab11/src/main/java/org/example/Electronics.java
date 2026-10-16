package org.example;

public class Electronics extends Product {
    public Electronics(String name, double price, double weight) {
        super(name, price, weight);
    }

    @Override
    public double getDiscount() {
        return 5;
    }
}
