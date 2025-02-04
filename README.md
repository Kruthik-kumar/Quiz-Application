# Quiz Application

A Java-based desktop quiz application featuring multiple-choice questions on Java and Python programming languages.

## 👥 For Friends: How to Download and Run

### Method 1: Download and Run (Easiest)
1. Download Java JDK if you don't have it:
   - Visit: https://www.oracle.com/java/technologies/downloads/
   - Download and install JDK for your operating system (Windows/Mac/Linux)

2. Download the application:
   - Click the green "Code" button above
   - Select "Download ZIP"
   - Extract the ZIP file to a folder

3. Run the application:
   - Open Command Prompt/Terminal
   - Navigate to the extracted folder:
     ```bash
     cd path/to/extracted/Quiz-Application
     ```
   - Compile the code:
     ```bash
     javac -d target/classes src/main/java/com/quizapp/Main.java src/main/java/com/quizapp/models/*.java src/main/java/com/quizapp/services/*.java src/main/java/com/quizapp/ui/*.java src/main/java/com/quizapp/utils/*.java
     ```
   - Run the application:
     ```bash
     java -cp target/classes com.quizapp.Main
     ```

### Method 2: Using Git (For Developers)
```bash
# Clone the repository
git clone https://github.com/Kruthik-kumar/Quiz-Application.git

# Navigate to project directory
cd Quiz-Application

# Compile the project
javac -d target/classes src/main/java/com/quizapp/Main.java src/main/java/com/quizapp/models/*.java src/main/java/com/quizapp/services/*.java src/main/java/com/quizapp/ui/*.java src/main/java/com/quizapp/utils/*.java

# Run the application
java -cp target/classes com.quizapp.Main
```

## Features

- User Authentication (Login/Register)
- Multiple Choice Questions
- Java Programming Quiz
- Python Programming Quiz
- Real-time Score Tracking
- Modern Swing-based UI

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- MySQL Database (optional, currently using in-memory storage)

## Project Structure

```
Quiz-Application/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── quizapp/
│                   ├── models/
│                   ├── services/
│                   ├── ui/
│                   └── utils/
└── pom.xml
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

- Java Swing for the UI components
- All contributors who have helped with the project
