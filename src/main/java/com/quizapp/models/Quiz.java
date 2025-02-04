package com.quizapp.models;

import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;

public class Quiz {
    private int id;
    private String title;
    private String description;
    private int createdBy;
    private Timestamp createdAt;
    private List<Question> questions;

    public Quiz(int id, String title, String description, int createdBy, Timestamp createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.questions = new ArrayList<>();
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getCreatedBy() { return createdBy; }
    public Timestamp getCreatedAt() { return createdAt; }
    public List<Question> getQuestions() { return questions; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setCreatedBy(int createdBy) { this.createdBy = createdBy; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
    public void setQuestions(List<Question> questions) { this.questions = questions; }

    // Helper methods
    public void addQuestion(Question question) {
        questions.add(question);
    }
}
