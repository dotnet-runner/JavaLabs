package org.example;

public class CheckingAccount extends Account {
    private double overdraftLimit;

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        if (0 > overdraftLimit)
            throw new IllegalArgumentException("Ошибка: лимит овердрафта не может быть отрицательным.");

        this.overdraftLimit = overdraftLimit;
    }

    public CheckingAccount(int number, double balance, String name, double overdraftLimit) {
        super(number, balance, name);
        setOverdraftLimit(overdraftLimit);
    }

    public double withdraw() {
        var balance = getBalance();
        setBalance(0);
        return balance;
    }

    public double calculateInterest() {
        return 0;
    }
}
