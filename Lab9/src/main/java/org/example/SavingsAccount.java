package org.example;

public class SavingsAccount extends Account  {
    private double rate;

    public double getRate() {
        return rate;
    }
    public void setRate(double rate) {
        if (0 > rate)
            throw new IllegalArgumentException("Ставка не может быть отрицательной: " + rate);

        var correctRate = Math.round(rate * 100) / 100.0;

        if (rate != correctRate)
            throw new IllegalArgumentException("Ставка должна иметь не более двух знаков после запятой: " + rate);
        this.rate = correctRate;
    }

    public SavingsAccount(int number, double balance, String name, double rate) {
        super(number, balance, name);
        setRate(rate);
    }

    public double withdraw() {
        var balance = getBalance() - getBalance() * 0.01;
        setBalance(0);
        return balance;
    }

    public double calculateInterest() {
        return getBalance() * getRate() / 100;
    }
}
