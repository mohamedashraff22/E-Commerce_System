package com.mycompany.ecommerce_system;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private static double ShippingPrice = 30; // constant shipping price  

    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("cart is empty!");
        }

        List<ShippingInterface> shippables = new ArrayList<>();
        double shippingWeight = 0;

        for (Item item : cart.getItems()) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();

            if (product.isExpired()) {
                throw new IllegalStateException(product.getName() + " is expired.");
            }

            if (!product.isAvailable(quantity)) {
                throw new IllegalStateException(product.getName() + " is out of stock.");
            }

            if (product instanceof ShippingInterface) {
                for (int i = 0; i < quantity; i++) {
                    shippables.add((ShippingInterface) product);
                    shippingWeight += ((ShippingInterface) product).getWeight();
                }
            }
        }

        double subtotal = cart.getSubtotal();
        double shippingFee;
        if (shippingWeight > 0) {
            shippingFee = ShippingPrice;}
        else {
            shippingFee = 0;
}
        double total = subtotal + shippingFee;

        if (!customer.checkBalance(total)) {
            throw new IllegalStateException("insufficient balance!!");
        }

        for (Item item : cart.getItems()) {
            item.getProduct().reduceQuantityProduct(item.getQuantity());
        }

        if (!shippables.isEmpty()) {
            ShippingService.ship(shippables);
        }

        System.out.println("** Checkout receipt **");
        for (Item item:cart.getItems()) {
            System.out.printf("%dx %s %.2f\n", item.getQuantity(), item.getProduct().getName(), item.ProducTotaltPrice());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Shipping: " + shippingFee);
        System.out.println("Amount: " + total);

    }
}