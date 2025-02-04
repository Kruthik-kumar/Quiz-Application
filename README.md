# Online Quiz Application

A Java-based online quiz application that allows users to take quizzes on various topics. The application features user authentication, quiz management, progress tracking, and more.

## Features

- User Authentication
- Quiz Management (Create, Edit, Delete)
- Quiz Taking with Immediate Feedback
- Score Tracking and Progress Monitoring
- User-friendly JavaFX Interface
- Secure Password Storage
- Database Integration

## Prerequisites

- Java JDK 17 or higher
- Maven
- MySQL Server
- IDE (recommended: IntelliJ IDEA or Eclipse)

## Setup Instructions

1. Clone the repository
2. Create a MySQL database named `quiz_app`
3. Update database credentials in `src/main/resources/config.properties`
4. Run the following commands:
   ```bash
   mvn clean install
   mvn javafx:run
   ```

## Database Setup

Run the following SQL commands to set up the database schema:

```sql
CREATE DATABASE quiz_app;
USE quiz_app;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    is_admin BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE quizzes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    created_by INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (created_by) REFERENCES users(id)
);

CREATE TABLE questions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    quiz_id INT,
    question_text TEXT NOT NULL,
    option_a TEXT NOT NULL,
    option_b TEXT NOT NULL,
    option_c TEXT NOT NULL,
    option_d TEXT NOT NULL,
    correct_answer CHAR(1) NOT NULL,
    FOREIGN KEY (quiz_id) REFERENCES quizzes(id)
);

CREATE TABLE quiz_attempts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    quiz_id INT,
    score INT,
    completed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (quiz_id) REFERENCES quizzes(id)
);
```

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── quizapp/
│   │           ├── Main.java
│   │           ├── controllers/
│   │           ├── models/
│   │           ├── services/
│   │           └── utils/
│   └── resources/
│       ├── fxml/
│       ├── css/
│       └── config.properties
```
