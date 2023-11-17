package Lab7;

import org.example.Lab7.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ECommerceTest {
    private ECommercePlatform platform;

    @BeforeEach
    void setUp() {
        platform = new ECommercePlatform();
        User user1 = new User(1, "user1", new HashMap<>());
        User user2 = new User(2, "user2", new HashMap<>());
        platform.addUser(user1);
        platform.addUser(user2);

        Product product1 = new Product(1, "Product1", 20.0, 10);
        Product product2 = new Product(2, "Product2", 30.0, 5);
        platform.addProduct(product1);
        platform.addProduct(product2);
    }

    @Test
    void addUser() {
        User newUser = new User(3, "user3", new HashMap<>());
        platform.addUser(newUser);
        List<User> userList = platform.listUsers();
        assertEquals(3, userList.size());
        assertTrue(userList.contains(newUser));
    }

    @Test
    void addProduct() {
        Product newProduct = new Product(3, "Product3", 25.0, 8);
        platform.addProduct(newProduct);
        List<Product> productList = platform.listAvailableProducts();
        assertEquals(3, productList.size());
        assertTrue(productList.contains(newProduct));
    }

    @Test
    void addNotValidUser() {
        User newUser = new User(3, "user3", new HashMap<>());
        platform.addUser(newUser);
        assertThrows(IllegalArgumentException.class, () -> platform.addUser(newUser));
    }

    @Test
    void addNotValidProduct() {
        Product newProduct = new Product(3, "Product3", 25.0, 8);
        platform.addProduct(newProduct);
        assertThrows(IllegalArgumentException.class, () -> platform.addProduct(newProduct));
    }

    @Test
    void createOrder() {
        User user = platform.listUsers().get(0);
        Map<Product, Integer> orderDetails = new HashMap<>();
        orderDetails.put(platform.listAvailableProducts().get(0), 2);
        platform.createOrder(user.getId(), orderDetails);
        List<Order> orderList = platform.listOrders();
        assertEquals(1, orderList.size());
    }

    @Test
    void listAvailableProducts() {
        List<Product> productList = platform.listAvailableProducts();
        assertEquals(2, productList.size());
    }

    @Test
    void updateStock() {
        Product product = platform.listAvailableProducts().get(0);
        platform.updateStock(product.getId(), 5);
        assertEquals(5, product.getStock());
    }

    @Test
    void recommendations() {
        Product[] registeredProducts = platform.listAvailableProducts().toArray(new Product[0]);
        User[] registeredUsers = platform.listUsers().toArray(new User[0]);

        platform.createOrder(registeredUsers[0].getId(), Map.of(
                registeredProducts[0], 1,
                registeredProducts[1], 2
        ));

        List<Product> actual = platform.recommendations();

        assertArrayEquals(
                Stream.of(registeredProducts[1], registeredProducts[0]).toArray(),
                actual.toArray()
        );
    }
}
