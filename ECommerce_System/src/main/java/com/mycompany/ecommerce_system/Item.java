package com.mycompany.ecommerce_system;

public class Item {

    private Product product;
    private int quantity;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double ProducTotaltPrice() {
    return product.getPrice()*quantity;
    }
}
