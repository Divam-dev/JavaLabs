package org.example.Lab9;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class FakeStoreAPI {
    private static final String BASE_URL = "https://api.escuelajs.co/api/v1/";
    private final HttpClient httpClient;
    private final FakeStoreJSONMapper mapper;

    public FakeStoreAPI() {
        this.httpClient = HttpClient.newHttpClient();
        this.mapper = new FakeStoreJSONMapper();
    }
    public String getResponse(String apiUrl) throws Exception {
        URI requestUrl = new URI(apiUrl);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(requestUrl)
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new RuntimeException("HTTP response code: " + response.statusCode());
        }
    }

    public List<Category> getCategories() {
        try {
            return mapper.mapCategories(getResponse(BASE_URL + "categories?&limit=10"));
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public List<User> getUsers() {
        try {
            return mapper.mapUsers(getResponse(BASE_URL + "users?&limit=10"));
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public List<Product> getProducts() {
        try {
            return mapper.mapProducts(getResponse(BASE_URL + "products?offset=0&limit=10"));
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
