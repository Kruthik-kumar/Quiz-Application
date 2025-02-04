package com.quizapp.services;

import com.quizapp.models.Quiz;
import com.quizapp.models.Question;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizService {
    private static final Map<Integer, Quiz> quizzes = new HashMap<>();
    private static int nextQuizId = 1;
    private static int nextQuestionId = 1;

    public QuizService() {
        // Initialize with sample quizzes if empty
        if (quizzes.isEmpty()) {
            initializeSampleQuizzes();
        }
    }

    private void initializeSampleQuizzes() {
        // Java Quiz
        Quiz javaQuiz = new Quiz(
            nextQuizId++,
            "Java Programming Basics",
            "Test your knowledge of Java programming fundamentals",
            1, // admin user id
            new Timestamp(System.currentTimeMillis())
        );

        // Java Questions
        List<Question> javaQuestions = new ArrayList<>();
        javaQuestions.add(new Question(
            nextQuestionId++,
            javaQuiz.getId(),
            "What is the output of 'System.out.println(5/2);' in Java?",
            "2.5",
            "2",
            "2.0",
            "Error",
            'B'
        ));

        javaQuestions.add(new Question(
            nextQuestionId++,
            javaQuiz.getId(),
            "Which of these is not a Java keyword?",
            "static",
            "final",
            "integer",
            "volatile",
            'C'
        ));

        javaQuestions.add(new Question(
            nextQuestionId++,
            javaQuiz.getId(),
            "What is the default value of a boolean variable in Java?",
            "true",
            "false",
            "null",
            "undefined",
            'B'
        ));

        javaQuestions.add(new Question(
            nextQuestionId++,
            javaQuiz.getId(),
            "Which collection type allows duplicate elements?",
            "Set",
            "List",
            "Map",
            "Queue",
            'B'
        ));

        javaQuestions.forEach(javaQuiz::addQuestion);
        quizzes.put(javaQuiz.getId(), javaQuiz);

        // Python Quiz
        Quiz pythonQuiz = new Quiz(
            nextQuizId++,
            "Python Programming Basics",
            "Test your knowledge of Python programming fundamentals",
            1, // admin user id
            new Timestamp(System.currentTimeMillis())
        );

        // Python Questions
        List<Question> pythonQuestions = new ArrayList<>();
        pythonQuestions.add(new Question(
            nextQuestionId++,
            pythonQuiz.getId(),
            "What is the output of 'print(5/2)' in Python 3?",
            "2.5",
            "2",
            "2.0",
            "Error",
            'A'
        ));

        pythonQuestions.add(new Question(
            nextQuestionId++,
            pythonQuiz.getId(),
            "Which of these is not a Python data type?",
            "int",
            "float",
            "string",
            "char",
            'D'
        ));

        pythonQuestions.add(new Question(
            nextQuestionId++,
            pythonQuiz.getId(),
            "What is the correct way to create a list in Python?",
            "list = []",
            "list = list()",
            "list = array()",
            "Both A and B",
            'D'
        ));

        pythonQuestions.add(new Question(
            nextQuestionId++,
            pythonQuiz.getId(),
            "Which operator is used for floor division in Python?",
            "/",
            "//",
            "%",
            "**",
            'B'
        ));

        pythonQuestions.forEach(pythonQuiz::addQuestion);
        quizzes.put(pythonQuiz.getId(), pythonQuiz);
    }

    public List<Quiz> getAllQuizzes() {
        return new ArrayList<>(quizzes.values());
    }

    public Quiz getQuizById(int id) {
        return quizzes.get(id);
    }

    public boolean addQuiz(Quiz quiz) {
        if (quiz.getId() == 0) {
            quiz.setId(nextQuizId++);
        }
        quizzes.put(quiz.getId(), quiz);
        return true;
    }

    public boolean updateQuiz(Quiz quiz) {
        if (quizzes.containsKey(quiz.getId())) {
            quizzes.put(quiz.getId(), quiz);
            return true;
        }
        return false;
    }

    public boolean deleteQuiz(int id) {
        return quizzes.remove(id) != null;
    }
}
