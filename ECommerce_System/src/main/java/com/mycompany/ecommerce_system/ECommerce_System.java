package com.mycompany.ecommerce_system;
import java.time.LocalDate;
import java.util.Scanner;

public class ECommerce_System {
    public static void main(String[] args) {
        //TESTING
        Product cheese = new ShippableExpirableProducts("Cheese", 120, 6, 0.3, LocalDate.now().plusDays(2));
        Product biscuits = new ShippableExpirableProducts("Biscuits", 180, 4, 0.8, LocalDate.now().plusDays(1));
        Product tv = new ShippableNoneExpirableProducts("TV", 350, 2, 4.5);
        Product scratchCard = new NoneExpirableProduct("Scratch Card", 60, 10);
        Product eggs = new ShippableExpirableProducts("Eggs", 90, 2, 1.2, LocalDate.now().minusDays(3)); // expired
        Product ipad = new ShippableNoneExpirableProducts("Ipad", 220, 1, 1.4); // Limited in stock

        Customer Customer1 = new Customer("Mohamed", 10000); // customer with enough money
        Customer Customer2 = new Customer("Ashraf", 100); // customer with less money
        
        
        // Test 1 : normal
        System.out.println("\nTest 1 : Normal Checkout");
        Cart cart1 = new Cart();
        cart1.add(cheese, 2);
        cart1.add(biscuits, 1);
        cart1.add(scratchCard, 1);
        try {
            Invoice.checkout(Customer1, cart1);
        } catch (Exception e) {
            System.out.println("error!: " + e.getMessage());
        }        System.out.println("\n==================================================");

        
        
        // Test 2 : empty cart
        System.out.println("\nTest 2 : Empty Cart");
        Cart cart2 = new Cart();
        try {
            Invoice.checkout(Customer1, cart2);
        } catch (Exception e) {
            System.out.println("error!: " + e.getMessage());
        }
        System.out.println("\n==================================================");

        
        
        // Test 3 : Expired Product
        System.out.println("Test 3 : Expired Product");
        try {
            Cart cart3 = new Cart();
            cart3.add(eggs,2);
            Invoice.checkout(Customer1, cart3);
        } catch (Exception e) {
            System.out.println("error!: " + e.getMessage());
        }
        System.out.println("\n==================================================");

        

        // Test 4 : Out of Stock
        System.out.println("Test 4 : Out of Stock");
        try {
            Cart cart4 = new Cart();
            cart4.add(ipad, 2);
            Invoice.checkout(Customer1, cart4);
        } catch (Exception e) {
            System.out.println("error!: " + e.getMessage());
        }
        System.out.println("\n==================================================");



        // Test 5 : Insufficient balance
        System.out.println("Test 5 : Insufficient Balance");
        Cart cart5 = new Cart();
        cart5.add(tv, 1);  
        cart5.add(biscuits, 2);
        try {
            Invoice.checkout(Customer2, cart5);
        } catch (Exception e) {
            System.out.println("error!: " + e.getMessage());
        }
        System.out.println("\n==================================================");

        
        
        // Test 6 : Non shippable product
        System.out.println("Test 6 : Non shippable");
        Cart cart6 = new Cart();
        cart6.add(scratchCard, 2);
        try {
            Invoice.checkout(Customer1, cart6);
        } catch (Exception e) {
            System.out.println("error!: " + e.getMessage());
        }        System.out.println("\n==================================================");
        
        
        
        // Test 7 : User Input Order
        System.out.println("Test 7 : User Order => 1 Cheese");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        System.out.print("Enter your balance: ");
        double balance = scanner.nextDouble();
        
        Customer userCustomer = new Customer(userName, balance);
        Cart userCart = new Cart();
        userCart.add(cheese, 1);
        try {
            Invoice.checkout(userCustomer, userCart);
        } catch (Exception e) {
            System.out.println("error!: " + e.getMessage());
        }
        System.out.println("\n==================================================");
    }
    
    
}