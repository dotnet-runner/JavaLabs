package org.example;

import java.util.Objects;

public class Product {
    private String name;
    private double price;
    private double weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (Objects.isNull(name) || name.isBlank())
            throw new IllegalArgumentException("Имя не может быть null или пустым");
        this.name = name.trim();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (0 > price)
            throw new IllegalArgumentException("Цена должна быть конечным неотрицательным числом");
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (0 > weight)
            throw new IllegalArgumentException("Вес должен быть конечным неотрицательным числом");
        this.weight = weight;
    }

    public Product(String name, double price, double weight) {
        setName(name);
        setPrice(price);
        setWeight(weight);
    }

    public void sell() {
        System.out.printf("Продаю товар %s, цена %.2f, вес %.2f\n", name, price, weight);
    }

    public void sell(int quantity) {
        if (0 >= quantity)
            throw new IllegalArgumentException("Количество должно быть положительным числом");

        System.out.printf("Продаю %d шт.\n", quantity);
    }

    public void sell(double discount) {
        if (0 > discount)
            throw new IllegalArgumentException("Скидка должна быть положительным числом");

        System.out.printf("Продаю со скидкой %.2f%%.\n", discount);
    }

    public double getDiscount() {
        return 0;
    }
}
