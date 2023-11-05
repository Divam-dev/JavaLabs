package Lab3;

import org.example.Lab3.Cart;
import org.example.Lab3.Order;
import org.example.Lab3.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CartOrderTest {

    private Cart cart;

    @BeforeEach
    void setUp() {
        cart = new Cart();
    }

    @Test
    public void testAddProduct() {
        Product product1 = mock(Product.class);
        Product product2 = mock(Product.class);

        cart.addProduct(product1);
        cart.addProduct(product2);

        assertTrue(cart.getProducts().contains(product1));
        assertTrue(cart.getProducts().contains(product2));
    }

    @Test
    public void testRemoveProduct() {
        Product product1 = mock(Product.class);
        Product product2 = mock(Product.class);

        cart.addProduct(product1);
        cart.addProduct(product2);

        cart.removeProduct(product1);

        assertFalse(cart.getProducts().contains(product1));
        assertTrue(cart.getProducts().contains(product2));
    }

    @Test
    public void testGetProducts() {
        Product product1 = mock(Product.class);
        Product product2 = mock(Product.class);

        cart.addProduct(product1);
        cart.addProduct(product2);

        assertEquals(2, cart.getProducts().size());
        assertTrue(cart.getProducts().contains(product1));
        assertTrue(cart.getProducts().contains(product2));
    }

    @Test
    public void testGetOrderId() {

        Product product1 = mock(Product.class);
        Product product2 = mock(Product.class);

        List<Product> products1 = new ArrayList<>();
        products1.add(product1);
        List<Product> products2 = new ArrayList<>();
        products2.add(product2);

        Order order1 = mock(Order.class);
        when(order1.getOrderId()).thenReturn(1);

        Order order2 = mock(Order.class);
        when(order2.getOrderId()).thenReturn(2);

        assertEquals(1, order1.getOrderId());
        assertEquals(2, order2.getOrderId());
    }
}
