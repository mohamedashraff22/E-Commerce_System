package com.mycompany.ecommerce_system;

public abstract class Product {
    private String name;
    private double price ; 
    private int quantity;
    
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        if (price < 0){ 
            throw new IllegalArgumentException("price can't be negative");
        }
        this.price = price;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0){ 
            throw new IllegalArgumentException("quantity can't be negative");
        }
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public void reduceQuantityProduct(int amount) {
        if (amount > quantity) {
            throw new IllegalArgumentException("The requested quantity is more than the available in stock.");
        }
        quantity -= amount;
    }

    public boolean isAvailable(int amount) {
        return this.quantity >= amount;
    }
    
    public abstract boolean isExpired();

}
