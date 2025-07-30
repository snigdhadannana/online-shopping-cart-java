// File: src/main/java/com/example/shoppingcart/model/Order.java
package com.example.shoppingcart.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a completed order in the shopping system.
 * Contains order details like ID, items, total amount, and order date.
 */
public class Order {
    private String orderId;
    private List<CartItem> orderedItems; // Snapshot of items at time of order
    private double totalAmount;
    private LocalDateTime orderDate;
    private String status; // e.g., "Pending", "Shipped", "Delivered"

    public Order(String orderId, List<CartItem> orderedItems, double totalAmount) {
        this.orderId = orderId;
        // Create a deep copy of orderedItems to ensure they don't change if cart changes
        this.orderedItems = new ArrayList<>();
        for (CartItem item : orderedItems) {
            this.orderedItems.add(new CartItem(item.getProduct(), item.getQuantity()));
        }
        this.totalAmount = totalAmount;
        this.orderDate = LocalDateTime.now();
        this.status = "Pending"; // Default status
    }

    // --- Getters ---

    public String getOrderId() {
        return orderId;
    }

    public List<CartItem> getOrderedItems() {
        return new ArrayList<>(orderedItems); // Return a copy
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    // --- Setters (e.g., for updating order status) ---
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("--- Order ID: %s ---%n", orderId));
        sb.append(String.format("Order Date: %s%n", orderDate.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
        sb.append("Items:%n");
        for (CartItem item : orderedItems) {
            sb.append(String.format("  - %s%n", item.toString()));
        }
        sb.append(String.format("Total Amount: $%.2f%n", totalAmount));
        sb.append(String.format("Status: %s%n", status));
        sb.append("-------------------------");
        return sb.toString();
    }
}
