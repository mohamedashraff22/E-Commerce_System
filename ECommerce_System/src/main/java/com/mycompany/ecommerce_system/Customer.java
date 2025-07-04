package com.mycompany.ecommerce_system;

public class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }


    public void deductBalance(double amount) {
        if (amount > balance) {
            throw new IllegalStateException("Insufficient balance for " + name);
        }
        balance -= amount;
    }
    
        public boolean checkBalance(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        System.out.println("Insufficient balance.");
        return false;
    }
}
