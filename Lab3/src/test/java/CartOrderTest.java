import org.example.Cart;
import org.example.Order;
import org.example.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CartOrderTest {

    private Cart cart;

    @BeforeEach
    void setUp() {
        cart = new Cart();
    }

    @Test
    public void testAddProduct() {
        Product product1 = new Product(1, "Product 1", 100);
        Product product2 = new Product(2, "Product 2", 99.9);
        cart.addProduct(product1);
        cart.addProduct(product2);

        assertTrue(cart.getProducts().contains(product1));
        assertTrue(cart.getProducts().contains(product2));
    }

    @Test
    public void testRemoveProduct() {
        Product product1 = new Product(1, "Product 1", 100);
        Product product2 = new Product(2, "Product 2", 99.9);

        cart.addProduct(product1);
        cart.addProduct(product2);

        cart.removeProduct(product1);

        assertFalse(cart.getProducts().contains(product1));
        assertTrue(cart.getProducts().contains(product2));
    }

    @Test
    public void testGetProducts() {
        Product product1 = new Product(1, "Product 1", 100);
        Product product2 = new Product(2, "Product 2", 99.9);

        cart.addProduct(product1);
        cart.addProduct(product2);

        assertEquals(2, cart.getProducts().size());
        assertTrue(cart.getProducts().contains(product1));
        assertTrue(cart.getProducts().contains(product2));
    }

    @Test
    public void testGetOrderId() {

        Product product1 = new Product(1, "Product 1", 100);
        Product product2 = new Product(2, "Product 2", 99.9);

        List<Product> products1 = new ArrayList<>();
        products1.add(product1);
        List<Product> products2 = new ArrayList<>();
        products2.add(product2);

        Order order1 = new Order(1, products1);
        Order order2 = new Order(2, products2);

        assertEquals(1, order1.getOrderId());
        assertEquals(2, order2.getOrderId());
    }
}
