# Quiz Application 🎓

A **Quiz Application** built with **Spring Boot** using the MVC architecture.  
This project demonstrates how to manage quizzes and questions with a clean separation of **Controller, Service, DAO, and Model layers**.

## 🎥 Demo
A demo video is available:  
[▶️ Watch Demo](assets/demo/demo.mp4)
OR
[Use This Link]([https://drive.google.com/file/d/1mmQgn0edX7jnHbfT_f4QHJzZFNFDxeCG/view?usp=sharing])


## 📌 Features
- Manage quizzes and questions
- RESTful API using Spring Boot
- MVC layered architecture
- Uses Maven for dependency management
- Unit tests included
- Demo video available


## 🛠️ Tech Stack
- **Java 17+**
- **Spring Boot**
- **Spring MVC**
- **Maven**
- **H2 / MySQL / Postgresql (configurable)**



## 📂 Project Structure
Quiz_Application/
└── Quiz/
└── Quiz/
├── src/
│ ├── main/
│ │ ├── java/com/example/Quiz/
│ │ │ ├── Application.java # Main Spring Boot app
│ │ │ ├── Controller/ # REST Controllers
│ │ │ ├── Service/ # Business logic
│ │ │ ├── dao/ # DAO layer
│ │ │ └── model/ # Entity models
│ │ └── resources/
│ │ ├── application.properties # App configuration
│ │ ├── static/ # Static resources (CSS/JS)
│ │ └── templates/ # Thymeleaf templates (if any)
│ └── test/java/com/example/Quiz/ # Unit tests
├── pom.xml # Maven dependencies
└── mvnw, mvnw.cmd # Maven wrapper



## ▶️ How to Run

### 1. Clone the repository
```bash
git clone https://github.com/Pavanshetty2411/Quiz_Application.git
cd Quiz_Application/Quiz/Quiz
```

### 2. Build the project
```bash
./mvnw clean install
```

### 3. Run the application
```bash
./mvnw spring-boot:run
```

The application will start on:  
👉 http://localhost:8080

---

## 🧪 Running Tests
```bash
./mvnw test
```

---


