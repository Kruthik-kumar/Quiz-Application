package com.quizapp.services;

import com.quizapp.models.User;
import java.util.HashMap;
import java.util.Map;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

public class UserService {
    private static final Map<String, User> users = new HashMap<>();
    private static int nextUserId = 1;
    
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User authenticate(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(hashPassword(password))) {
            return user;
        }
        return null;
    }
    
    public boolean register(String username, String password, boolean isAdmin) {
        if (users.containsKey(username)) {
            return false;
        }
        
        String hashedPassword = hashPassword(password);
        User newUser = new User(
            nextUserId++,
            username,
            hashedPassword,
            isAdmin,
            new Timestamp(System.currentTimeMillis())
        );
        
        users.put(username, newUser);
        return true;
    }
    
    public boolean usernameExists(String username) {
        return users.containsKey(username);
    }
}
