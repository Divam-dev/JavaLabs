package org.example.Lab9;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class FakeStoreJSONMapper {
    private final Gson gson = new Gson();

    public List<Category> mapCategories(String json) {
        Type categoryListType = new TypeToken<List<Category>>() {}.getType();
        return gson.fromJson(json, categoryListType);
    }

    public List<User> mapUsers(String json) {
        Type userListType = new TypeToken<List<User>>() {}.getType();
        return gson.fromJson(json, userListType);
    }

    public List<Product> mapProducts(String json) {
        Type productListType = new TypeToken<List<Product>>() {}.getType();
        return gson.fromJson(json, productListType);
    }
}
