# Quiz Application 📝

[![Java](https://img.shields.io/badge/Java-8%2B-orange)](https://www.oracle.com/java/technologies/downloads/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

> A desktop quiz application built with Java Swing, featuring programming questions in Java and Python.

![Quiz Application Screenshot](screenshot.png)

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Overview

Quiz Application is an interactive desktop application designed to help users test their programming knowledge. It provides a user-friendly interface for taking quizzes on Java and Python programming concepts.

## Features

- 🔐 **User Authentication**
  - Secure login and registration system
  - Password hashing for security

- 📋 **Quiz Management**
  - Multiple choice questions
  - Java programming questions
  - Python programming questions
  - Real-time score tracking

- 🎨 **User Interface**
  - Modern Swing-based UI
  - Intuitive navigation
  - Clean and responsive design

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any operating system (Windows, macOS, Linux)

### Installation

1. Clone the repository
```bash
git clone https://github.com/Kruthik-kumar/Quiz-Application.git
```

2. Navigate to the project directory
```bash
cd Quiz-Application
```

3. Compile the project
```bash
javac -d target/classes src/main/java/com/quizapp/Main.java src/main/java/com/quizapp/models/*.java src/main/java/com/quizapp/services/*.java src/main/java/com/quizapp/ui/*.java src/main/java/com/quizapp/utils/*.java
```

4. Run the application
```bash
java -cp target/classes com.quizapp.Main
```

## Usage

1. Start the application
2. Register a new account or login with existing credentials
3. Select a quiz category (Java/Python)
4. Answer the multiple-choice questions
5. View your score and performance summary

## Technology Stack

- **Backend**: Java 8+
- **UI Framework**: Java Swing
- **Security**: SHA-256 hashing
- **Build Tool**: Manual compilation (future: Maven)
- **Database**: In-memory storage (future: MySQL)

## Project Structure

```
Quiz-Application/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── quizapp/
│                   ├── models/      # Data models
│                   ├── services/    # Business logic
│                   ├── ui/          # User interface
│                   └── utils/       # Utilities
└── pom.xml         # Project configuration
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

Your Name - [@YourTwitter](https://twitter.com/YourTwitter)

Project Link: [https://github.com/Kruthik-kumar/Quiz-Application](https://github.com/Kruthik-kumar/Quiz-Application)

---
⭐️ From [Kruthik-kumar](https://github.com/Kruthik-kumar)
