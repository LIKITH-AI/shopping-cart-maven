
package com.example;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        if (product.getQuantity() <= 0 || product.getPrice() <= 0) {
            throw new IllegalArgumentException("Invalid quantity or price");
        }

        products.add(product);
    }

    public void removeProduct(String name) {
        products.removeIf(product -> product.getName().equals(name));
    }

    public double calculateTotal() {
        double total = 0;

        for (Product product : products) {
            total += product.getQuantity() * product.getPrice();
        }

        return total;
    }

    public double applyDiscount(double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Invalid discount");
        }

        return calculateTotal() - (calculateTotal() * percentage / 100);
    }

    public int getProductCount() {
        return products.size();
    }
}

