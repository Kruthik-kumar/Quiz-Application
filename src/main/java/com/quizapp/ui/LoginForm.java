package com.quizapp.ui;

import com.quizapp.models.User;
import com.quizapp.services.UserService;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class LoginForm extends JPanel {
    private final UserService userService;
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private User loggedInUser;
    private Consumer<User> loginSuccessListener;

    public LoginForm(Runnable onLoginSuccess) {
        userService = new UserService();
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Username
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        usernameField = new JTextField(20);
        add(usernameField, gbc);

        // Password
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        passwordField = new JPasswordField(20);
        add(passwordField, gbc);

        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> handleLogin(onLoginSuccess));

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(e -> {
            // Show registration form
            RegisterForm registerForm = new RegisterForm(() -> {
                // Clear fields after successful registration
                usernameField.setText("");
                passwordField.setText("");
            });

            JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this),
                "Register", true);
            dialog.setContentPane(registerForm);
            dialog.pack();
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        });

        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(buttonPanel, gbc);
    }

    public void addLoginSuccessListener(Consumer<User> listener) {
        this.loginSuccessListener = listener;
    }

    private void handleLogin(Runnable onLoginSuccess) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Please enter both username and password",
                "Login Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        loggedInUser = userService.authenticate(username, password);
        if (loggedInUser != null) {
            if (loginSuccessListener != null) {
                loginSuccessListener.accept(loggedInUser);
            }
            onLoginSuccess.run();
        } else {
            JOptionPane.showMessageDialog(this,
                "Invalid username or password",
                "Login Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }
}
