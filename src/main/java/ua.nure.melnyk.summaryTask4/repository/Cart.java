package ua.nure.melnyk.summaryTask4.repository;

import ua.nure.melnyk.summaryTask4.model.Product;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Container for Cart
 */
public class Cart {

    private Map<Product, Integer> cart;

    public Cart() {
        cart = new TreeMap<>();
    }

    /**
     * Putting to TreeMap a product
     *
     * @param product
     */
    public void addToCart(Product product) {
        if (cart.keySet().contains(product)) {
            int count = cart.get(product);
            cart.put(product, ++count);
        } else {
            cart.put(product, 1);
        }
    }

    /**
     * Remove a product
     *
     * @param id
     * @return
     */
    public int removeFromCartById(int id) {
        AtomicReference<Product> toRemove = new AtomicReference<>();
        cart.keySet().forEach(e -> {
            if (e.getId() == id) {
                toRemove.set(e);
            }
        });
        return cart.remove(toRemove.get());
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }
}
