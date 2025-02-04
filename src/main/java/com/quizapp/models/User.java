package com.quizapp.models;

import java.sql.Timestamp;

public class User {
    private int id;
    private String username;
    private String password;
    private boolean isAdmin;
    private Timestamp createdAt;

    public User(int id, String username, String password, boolean isAdmin, Timestamp createdAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.createdAt = createdAt;
    }

    // Getters
    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public boolean isAdmin() { return isAdmin; }
    public Timestamp getCreatedAt() { return createdAt; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setAdmin(boolean admin) { isAdmin = admin; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
}
