package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try(var scanner = new Scanner(System.in)) {
            System.out.print("Введите адресс квартиры: ");
            var address = scanner.nextLine();
            System.out.print("Введите количество комнат в квартире: ");
            var rooms = scanner.nextInt();
            System.out.print("Введите площадь квартиры: ");
            var area = scanner.nextDouble();
            System.out.print("Введите стоимоить: ");
            var totalPrice = scanner.nextDouble();
            var apartment = new Apartment(address, rooms, area);
            System.out.printf("Для квартиры по адресу %s, с количеством комнат: %s и общей площадью: %f\n" +
                    "Общая цена: %.2f\n" +
                    "Цена за квадратный метр: %.2f", apartment.getAddress(), apartment.getRooms(), apartment.getArea(),
                    totalPrice, apartment.pricePerSquareMeter(totalPrice));
        }
    }
}
