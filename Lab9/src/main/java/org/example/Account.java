package org.example;

public abstract class Account {
    private int number;
    private double balance;
    private String owner;

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        if(0 > number)
            throw new IllegalArgumentException("Номер счета не может быть отрицательным");
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        if(0 > balance)
            throw new IllegalArgumentException("Баланс не может быть отрицательным");

        var correctBalance = Math.round(balance * 100) / 100.0;

        if(balance != correctBalance)
            throw new IllegalArgumentException("Баланс должен иметь не более двух знаков после запятой");

        this.balance = correctBalance;
    }

    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        if(owner == null || owner.isBlank())
            throw new IllegalArgumentException("Имя владельца не может быть пустым или состоять только из пробелов");
        this.owner = owner;
    }

    public Account(int number, double balance, String owner) {
        setNumber(number);
        setBalance(balance);
        setOwner(owner);
    }

    public abstract double withdraw();
    public abstract double calculateInterest();

    public void displayInfo() {
        System.out.printf("%s на лицевом счете №%d, остаток на счету: %.2f\n" +
                "С процентом начисления: %.2f\n" +
                "Снято денег: %.2f\n" +
                "\n", getOwner(), getNumber(), getBalance(), calculateInterest(), withdraw());
    }
}
