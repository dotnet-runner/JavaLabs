package org.example;

public class App {
    public static void main(String[] args) {
        var smartphone1 = new Smartphone("Xiaomi Redmi Note 13 Pro 5G", 12, 200);
        var smartphone2 = new Smartphone("Samsung Galaxy A55 5G", 12, 50);
        var smartphone3 = new Smartphone("Apple iPhone 15 Pro", 8, 48);
        var smartphone4 = new Smartphone("Google Pixel 8a", 8, 64);
        var smartphone5 = new Smartphone("Realme C67", 6, 108);

        Smartphone.printStatistic();
    }
}
