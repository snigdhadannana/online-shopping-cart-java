// File: src/main/java/com/example/shoppingcart/model/CartItem.java
package com.example.shoppingcart.model;

/**
 * Represents a single item in the shopping cart, including the product
 * and the quantity of that product.
 */
public class CartItem {
    private Product product;
    private int quantity;

    /**
     * Constructs a new CartItem.
     * @param product The product associated with this cart item.
     * @param quantity The quantity of the product.
     */
    public CartItem(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive for a cart item.");
        }
        this.product = product;
        this.quantity = quantity;
    }

    // --- Getters ---

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    /**
     * Calculates the total price for this cart item (product price * quantity).
     * @return The total price for this item.
     */
    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    // --- Setters (for quantity update) ---

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.quantity = quantity;
    }

    public void increaseQuantity(int amount) {
        if (amount <= 0) {
            System.out.println("Amount to increase must be positive.");
            return;
        }
        this.quantity += amount;
    }

    @Override
    public String toString() {
        return String.format("%s (ID: %s) x %d @ $%.2f each = $%.2f",
                             product.getName(), product.getId(), quantity, product.getPrice(), getTotalPrice());
    }
}
