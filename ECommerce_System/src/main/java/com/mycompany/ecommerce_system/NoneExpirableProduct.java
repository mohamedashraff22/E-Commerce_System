package com.mycompany.ecommerce_system;

public class NoneExpirableProduct extends Product {
    public NoneExpirableProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }
    
    @Override
    public boolean isExpired(){
        return false;
    } 
}
