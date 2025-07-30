// File: src/main/java/com/example/shoppingcart/model/ShoppingCart.java
package com.example.shoppingcart.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Represents the shopping cart for a user.
 * It contains a list of CartItems and provides methods to manage them.
 */
public class ShoppingCart {
    private List<CartItem> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds a product to the cart. If the product is already in the cart,
     * its quantity is updated.
     * @param product The product to add.
     * @param quantity The quantity of the product to add.
     */
    public void addItem(Product product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Quantity must be positive.");
            return;
        }

        Optional<CartItem> existingItem = items.stream()
            .filter(item -> item.getProduct().getId().equals(product.getId()))
            .findFirst();

        if (existingItem.isPresent()) {
            existingItem.get().increaseQuantity(quantity);
            System.out.println("Updated quantity for " + product.getName() + " in cart.");
        } else {
            items.add(new CartItem(product, quantity));
            System.out.println("Added " + quantity + " x " + product.getName() + " to cart.");
        }
    }

    /**
     * Removes a product entirely from the cart.
     * @param productId The ID of the product to remove.
     */
    public void removeItem(String productId) {
        boolean removed = items.removeIf(item -> item.getProduct().getId().equals(productId));
        if (removed) {
            System.out.println("Removed product with ID " + productId + " from cart.");
        } else {
            System.out.println("Product with ID " + productId + " not found in cart.");
        }
    }

    /**
     * Updates the quantity of a specific product in the cart.
     * If new quantity is 0 or less, the item is removed.
     * @param productId The ID of the product to update.
     * @param newQuantity The new quantity for the product.
     */
    public void updateItemQuantity(String productId, int newQuantity) {
        if (newQuantity < 0) {
            System.out.println("Quantity cannot be negative.");
            return;
        }

        Optional<CartItem> existingItem = items.stream()
            .filter(item -> item.getProduct().getId().equals(productId))
            .findFirst();

        if (existingItem.isPresent()) {
            if (newQuantity == 0) {
                removeItem(productId);
            } else {
                existingItem.get().setQuantity(newQuantity);
                System.out.println("Updated quantity for " + existingItem.get().getProduct().getName() + " to " + newQuantity + ".");
            }
        } else {
            System.out.println("Product with ID " + productId + " not found in cart to update.");
        }
    }

    /**
     * Calculates the total price of all items in the cart.
     * @return The total price.
     */
    public double getTotalPrice() {
        return items.stream()
            .mapToDouble(CartItem::getTotalPrice)
            .sum();
    }

    /**
     * Displays all items currently in the cart.
     */
    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Your shopping cart is empty.");
            return;
        }
        System.out.println("\n--- Your Shopping Cart ---");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
        System.out.printf("--------------------------%n");
        System.out.printf("Total: $%.2f%n", getTotalPrice());
        System.out.println("--------------------------");
    }

    /**
     * Clears all items from the shopping cart.
     */
    public void clearCart() {
        items.clear();
        System.out.println("Shopping cart has been cleared.");
    }

    // Getter for items (useful for checkout or other operations)
    public List<CartItem> getItems() {
        return new ArrayList<>(items); // Return a copy to prevent external modification
    }
}
