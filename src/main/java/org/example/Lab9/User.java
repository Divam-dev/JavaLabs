package org.example.Lab9;

public class User {
    private final int id;
    private final String email;
    private final String password;
    private final String name;
    private final String role;
    private final String avatar;
    private final String updatedAt;

    public User(int id, String email, String password, String name, String role, String avatar, String updatedAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
        this.avatar = avatar;
        this.updatedAt = updatedAt;
    }

    public User() {
        this.id = 0;
        this.email = "";
        this.password = "";
        this.name = "";
        this.role = "";
        this.avatar = "";
        this.updatedAt = "";
    }

    public int getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getName() {
        return this.name;
    }

    public String getRole() {
        return this.role;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }
}
