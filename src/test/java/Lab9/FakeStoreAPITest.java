package Lab9;

import org.example.Lab9.Category;
import org.example.Lab9.FakeStoreAPI;
import org.example.Lab9.Product;
import org.example.Lab9.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FakeStoreAPITest {

    @Test
    public void testGetResponse() throws Exception {

        FakeStoreAPI fakeStoreAPI = spy(new FakeStoreAPI());
        doReturn("[]").when(fakeStoreAPI).getResponse(anyString());

        String response = fakeStoreAPI.getResponse("https://api.escuelajs.co/api/v1/categories?&limit=10");
        assertEquals("[]", response);
    }

    @Test
    public void testGetCategories() throws Exception {

        FakeStoreAPI fakeStoreAPI = spy(new FakeStoreAPI());
        doReturn("[]").when(fakeStoreAPI).getResponse(anyString());

        List<Category> categories = fakeStoreAPI.getCategories();
        assertEquals(0, categories.size());
    }

    @Test
    public void testGetUsers() throws Exception {

        FakeStoreAPI fakeStoreAPI = spy(new FakeStoreAPI());
        doReturn("[]").when(fakeStoreAPI).getResponse(anyString());

        List<User> users = fakeStoreAPI.getUsers();
        assertEquals(0, users.size());
    }

    @Test
    public void testGetProducts() throws Exception {

        FakeStoreAPI fakeStoreAPI = spy(new FakeStoreAPI());
        doReturn("[]").when(fakeStoreAPI).getResponse(anyString());

        List<Product> products = fakeStoreAPI.getProducts();
        assertEquals(0, products.size());
    }
}

