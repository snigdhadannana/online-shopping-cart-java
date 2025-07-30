// File: src/main/java/com/example/shoppingcart/data/OrderHistory.java
package com.example.shoppingcart.data;

import com.example.shoppingcart.model.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Manages a list of all placed orders.
 */
public class OrderHistory {
    private List<Order> orders;
    private AtomicLong orderCounter; // To generate unique order IDs

    public OrderHistory() {
        this.orders = new ArrayList<>();
        this.orderCounter = new AtomicLong(1000); // Start order IDs from 1001
    }

    /**
     * Adds a new order to the history.
     * @param order The order to add.
     */
    public void addOrder(Order order) {
        orders.add(order);
    }

    /**
     * Generates a new unique order ID.
     * @return A unique order ID string.
     */
    public String generateOrderId() {
        return "ORD-" + orderCounter.getAndIncrement();
    }

    /**
     * Returns a list of all orders.
     * @return A new List containing all orders.
     */
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders); // Return a copy
    }

    /**
     * Displays all orders in the history.
     */
    public void displayAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("No past orders found.");
            return;
        }
        System.out.println("\n--- Your Order History ---");
        orders.forEach(order -> {
            System.out.println(order);
            System.out.println(); // Add a blank line for readability between orders
        });
        System.out.println("--------------------------");
    }
}
