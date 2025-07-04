package com.mycompany.ecommerce_system;

public class ShippableNoneExpirableProducts extends ShippableProduct {

    public ShippableNoneExpirableProducts(String name, double price, int quantity, double weight) {
        super(name, price, quantity, weight);
    }
    @Override
    public boolean isExpired() {
        return false;
    }
    
}
