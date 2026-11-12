
package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ShoppingCartTest {

    @Test
    void testAddProduct() {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("Laptop", 1, 50000));

        assertEquals(1, cart.getProductCount());
    }

    @Test
    void testRemoveProduct() {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("Mouse", 1, 500));
        cart.removeProduct("Mouse");

        assertEquals(0, cart.getProductCount());
    }

    @Test
    void testCalculateTotal() {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("Laptop", 2, 40000));
        cart.addProduct(new Product("Mouse", 1, 500));

        assertEquals(80500, cart.calculateTotal(), 0.01);
    }

    @Test
    void testDiscount() {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("Laptop", 1, 50000));

        assertEquals(45000, cart.applyDiscount(10), 0.01);
    }

    @Test
    void testInvalidQuantity() {
        ShoppingCart cart = new ShoppingCart();

        assertThrows(IllegalArgumentException.class,
            () -> cart.addProduct(new Product("Laptop", 0, 50000)));
    }

    @Test
    void testInvalidPrice() {
        ShoppingCart cart = new ShoppingCart();

        assertThrows(IllegalArgumentException.class,
            () -> cart.addProduct(new Product("Laptop", 1, -500)));
    }

    @Test
    void testInvalidDiscount() {
        ShoppingCart cart = new ShoppingCart();

        assertThrows(IllegalArgumentException.class,
            () -> cart.applyDiscount(110));
    }
}

