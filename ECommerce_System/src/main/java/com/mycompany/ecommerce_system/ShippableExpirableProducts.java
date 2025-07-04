package com.mycompany.ecommerce_system;
import java.time.LocalDate;

public class ShippableExpirableProducts extends ShippableProduct {
    
    private LocalDate expireDate;

    public ShippableExpirableProducts(String name, double price, int quantity, double weight, LocalDate expireDate) {
    super(name, price, quantity, weight);
    this.expireDate = expireDate;
    }

    
    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expireDate);
    }
}
