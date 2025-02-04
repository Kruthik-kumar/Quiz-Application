# Quiz Application

A Java-based desktop quiz application featuring multiple-choice questions on Java and Python programming languages.

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

## Installation

1. Clone the repository:
```bash
git clone https://github.com/YOUR_USERNAME/Quiz-Application.git
```

2. Navigate to the project directory:
```bash
cd Quiz-Application
```

3. Compile the project:
```bash
javac -d target/classes src/main/java/com/quizapp/Main.java src/main/java/com/quizapp/models/*.java src/main/java/com/quizapp/services/*.java src/main/java/com/quizapp/ui/*.java src/main/java/com/quizapp/utils/*.java
```

4. Run the application:
```bash
java -cp target/classes com.quizapp.Main
```

## Usage

1. Launch the application
2. Register a new account or login with existing credentials
3. Select a quiz (Java or Python)
4. Answer the multiple-choice questions
5. View your score at the end of the quiz

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
