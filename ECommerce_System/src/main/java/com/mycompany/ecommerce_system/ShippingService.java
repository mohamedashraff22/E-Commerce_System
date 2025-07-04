package com.mycompany.ecommerce_system;
import java.util.ArrayList;
import java.util.List;

public class ShippingService {
    public static void ship(List<ShippingInterface> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;

        for (ShippingInterface item : items) {
            System.out.println(item.getName() +" : " + item.getWeight()+ "kg");
            totalWeight += item.getWeight();
        }
    
        System.out.println("Total weight: " + totalWeight + "kg");
    
    }
}