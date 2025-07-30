// File: src/main/java/com/example/shoppingcart/data/ProductCatalog.java
package com.example.shoppingcart.data;

import com.example.shoppingcart.model.Product;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

/**
 * Manages the available products in the store.
 * In a real application, this would interact with a database.
 */
public class ProductCatalog {
    private Map<String, Product> products;

    public ProductCatalog() {
        this.products = new HashMap<>();
        // Initialize with some dummy products
        addDummyProducts();
    }

    private void addDummyProducts() {
        addProduct(new Product("P001", "Laptop Pro X", 1200.00, "High-performance laptop with advanced features."));
        addProduct(new Product("P002", "Wireless Mouse", 25.50, "Ergonomic wireless mouse for comfortable use."));
        addProduct(new Product("P003", "Mechanical Keyboard RGB", 99.99, "Durable mechanical keyboard with customizable RGB lighting."));
        addProduct(new Product("P004", "USB-C Hub", 45.00, "Multi-port USB-C adapter for modern laptops."));
        addProduct(new Product("P005", "4K Monitor 27-inch", 350.00, "Stunning 4K resolution monitor for clear visuals."));
        System.out.println("Product catalog initialized with dummy data.");
    }

    /**
     * Adds a new product to the catalog.
     * @param product The product to add.
     */
    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    /**
     * Retrieves a product by its ID.
     * @param id The ID of the product to retrieve.
     * @return The Product object if found, null otherwise.
     */
    public Product getProductById(String id) {
        return products.get(id);
    }

    /**
     * Returns a collection of all products in the catalog.
     * @return A Collection of Product objects.
     */
    public Collection<Product> getAllProducts() {
        return products.values();
    }

    /**
     * Displays all products in the catalog.
     */
    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available in the catalog.");
            return;
        }
        System.out.println("\n--- Available Products ---");
        products.values().forEach(System.out::println);
        System.out.println("--------------------------");
    }
}
