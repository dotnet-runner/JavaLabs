package org.example;

public class App {
    public static void main(String[] args) {
        try {
            var savings1 = new SavingsAccount(131, 15000, "Иван Петрович Сидоров", 4.56);
            var savings2 = new SavingsAccount(192, 22000, "Мария Сергеевна Иванова", 5.2);

            var checking1 = new CheckingAccount(611, -19000, "Петр Николаевич Кузнецов", 500);
            var checking2 = new CheckingAccount(252, 4500, "Анна Владимировна Смирнова", 700);
            var checking3 = new CheckingAccount(37, 1800, "Олег Дмитриевич Попов", 250);

            savings1.displayInfo();
            savings2.displayInfo();
            checking1.displayInfo();
            checking2.displayInfo();
            checking3.displayInfo();
        }
        catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
