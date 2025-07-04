package com.mycompany.ecommerce_system;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (!product.isAvailable(quantity)) {
            throw new IllegalArgumentException("Not enough quantity");
        }
        items.add(new Item(product, quantity));
    }

    public List<Item> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getSubtotal() {
        return items.stream().mapToDouble(Item::ProducTotaltPrice).sum();
    }
}