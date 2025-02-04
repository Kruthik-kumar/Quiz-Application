package com.quizapp.ui;

import com.quizapp.models.Quiz;
import com.quizapp.models.Question;
import com.quizapp.services.QuizService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class QuizForm extends JPanel {
    private final QuizService quizService;
    private Quiz currentQuiz;
    private int currentQuestionIndex;
    private final JLabel questionLabel;
    private final ButtonGroup optionsGroup;
    private final JRadioButton[] optionButtons;
    private final JButton nextButton;
    private final JButton submitButton;
    private int score;
    
    public QuizForm(int quizId) {
        quizService = new QuizService();
        currentQuiz = quizService.getQuizById(quizId);
        currentQuestionIndex = 0;
        score = 0;
        
        setLayout(new BorderLayout(10, 10));
        
        // Quiz title
        JLabel titleLabel = new JLabel(currentQuiz.getTitle(), SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);
        
        // Question panel
        JPanel questionPanel = new JPanel(new BorderLayout(5, 5));
        questionLabel = new JLabel("", SwingConstants.LEFT);
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        questionPanel.add(questionLabel, BorderLayout.NORTH);
        
        // Options panel
        JPanel optionsPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        optionsGroup = new ButtonGroup();
        optionButtons = new JRadioButton[4];
        
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            optionButtons[i].setFont(new Font("Arial", Font.PLAIN, 14));
            optionsGroup.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }
        
        questionPanel.add(optionsPanel, BorderLayout.CENTER);
        add(questionPanel, BorderLayout.CENTER);
        
        // Navigation panel
        JPanel navigationPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        nextButton = new JButton("Next");
        submitButton = new JButton("Submit");
        submitButton.setVisible(false);
        
        nextButton.addActionListener(e -> {
            if (isAnswerSelected()) {
                checkAnswer();
                currentQuestionIndex++;
                if (currentQuestionIndex < currentQuiz.getQuestions().size()) {
                    displayQuestion();
                } else {
                    showResults();
                }
            } else {
                JOptionPane.showMessageDialog(this,
                    "Please select an answer before proceeding",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
            }
        });
        
        submitButton.addActionListener(e -> {
            if (isAnswerSelected()) {
                checkAnswer();
                showResults();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Please select an answer before submitting",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
            }
        });
        
        navigationPanel.add(nextButton);
        navigationPanel.add(submitButton);
        add(navigationPanel, BorderLayout.SOUTH);
        
        // Display first question
        displayQuestion();
    }
    
    private void displayQuestion() {
        Question question = currentQuiz.getQuestions().get(currentQuestionIndex);
        questionLabel.setText((currentQuestionIndex + 1) + ". " + question.getQuestionText());
        
        optionButtons[0].setText("A. " + question.getOptionA());
        optionButtons[1].setText("B. " + question.getOptionB());
        optionButtons[2].setText("C. " + question.getOptionC());
        optionButtons[3].setText("D. " + question.getOptionD());
        
        optionsGroup.clearSelection();
        
        // Show submit button on last question
        if (currentQuestionIndex == currentQuiz.getQuestions().size() - 1) {
            nextButton.setVisible(false);
            submitButton.setVisible(true);
        }
    }
    
    private boolean isAnswerSelected() {
        return optionsGroup.getSelection() != null;
    }
    
    private void checkAnswer() {
        Question currentQuestion = currentQuiz.getQuestions().get(currentQuestionIndex);
        char selectedAnswer = ' ';
        
        for (int i = 0; i < optionButtons.length; i++) {
            if (optionButtons[i].isSelected()) {
                selectedAnswer = (char)('A' + i);
                break;
            }
        }
        
        if (selectedAnswer == currentQuestion.getCorrectAnswer()) {
            score++;
        }
    }
    
    private void showResults() {
        removeAll();
        setLayout(new BorderLayout());
        
        JPanel resultsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        JLabel titleLabel = new JLabel("Quiz Results", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        resultsPanel.add(titleLabel, gbc);
        
        JLabel scoreLabel = new JLabel(String.format("Your score: %d/%d", 
            score, currentQuiz.getQuestions().size()), SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        resultsPanel.add(scoreLabel, gbc);
        
        double percentage = (score * 100.0) / currentQuiz.getQuestions().size();
        JLabel percentageLabel = new JLabel(String.format("Percentage: %.1f%%", percentage), 
            SwingConstants.CENTER);
        percentageLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        resultsPanel.add(percentageLabel, gbc);
        
        add(resultsPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
}
