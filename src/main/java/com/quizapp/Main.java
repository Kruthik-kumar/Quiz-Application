package com.quizapp;

import com.quizapp.models.Quiz;
import com.quizapp.services.QuizService;
import com.quizapp.ui.LoginForm;
import com.quizapp.ui.QuizForm;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main {
    private static JFrame mainFrame;
    private static QuizService quizService;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            mainFrame = new JFrame("Quiz Application");
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setSize(800, 600);
            mainFrame.setLocationRelativeTo(null);

            quizService = new QuizService();
            showLoginForm();

            mainFrame.setVisible(true);
        });
    }

    private static void showLoginForm() {
        LoginForm loginForm = new LoginForm(() -> {
            showQuizSelection();
        });
        loginForm.addLoginSuccessListener(user -> {
            // We can use the user object here if needed
        });
        mainFrame.setContentPane(loginForm);
        mainFrame.revalidate();
    }

    private static void showQuizSelection() {
        JPanel quizSelectionPanel = new JPanel(new BorderLayout(10, 10));
        quizSelectionPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Welcome message
        JLabel welcomeLabel = new JLabel("Welcome to the Quiz Application", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        quizSelectionPanel.add(welcomeLabel, BorderLayout.NORTH);

        // Quiz list
        JPanel quizListPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        List<Quiz> quizzes = quizService.getAllQuizzes();

        for (Quiz quiz : quizzes) {
            JPanel quizPanel = new JPanel(new BorderLayout(5, 5));
            quizPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            
            JLabel titleLabel = new JLabel(quiz.getTitle());
            titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
            quizPanel.add(titleLabel, BorderLayout.NORTH);
            
            JLabel descLabel = new JLabel(quiz.getDescription());
            descLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            quizPanel.add(descLabel, BorderLayout.CENTER);
            
            JButton startButton = new JButton("Start Quiz");
            startButton.addActionListener(e -> startQuiz(quiz.getId()));
            quizPanel.add(startButton, BorderLayout.EAST);
            
            quizListPanel.add(quizPanel);
        }

        JScrollPane scrollPane = new JScrollPane(quizListPanel);
        scrollPane.setBorder(null);
        quizSelectionPanel.add(scrollPane, BorderLayout.CENTER);

        mainFrame.setContentPane(quizSelectionPanel);
        mainFrame.revalidate();
    }

    private static void startQuiz(int quizId) {
        QuizForm quizForm = new QuizForm(quizId);
        mainFrame.setContentPane(quizForm);
        mainFrame.revalidate();
    }
}
