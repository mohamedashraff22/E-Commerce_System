package com.mycompany.ecommerce_system;
import java.time.LocalDate;

public class ExpirableProduct extends Product{
    private LocalDate expireDate;

    public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expireDate = expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    @Override
    public boolean isExpired(){
        return LocalDate.now().isAfter(expireDate);
    }
    
}
