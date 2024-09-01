# Fitness Workout Tracker Backend

## Overview

The Fitness Tracker Backend is a Spring Boot application that provides a comprehensive API for managing fitness-related activities, including user authentication, workouts, exercises, workout reports and workout comments. This application uses Java, Spring Boot, Spring Security (with JWT authentication), PostgreSQL, and Spring data JPA for data persistence. It is designed to support a fitness tracking application where users can create and manage workouts, exercises, and track their progress over time.

## Features

- **User Authentication**: JWT-based authentication for secure user registration and login.
- **Workout Management**: Create, update, delete, and retrieve workouts.
- **Exercise Management**: Add, update, and remove exercises associated with workouts.
- **Workout Reports**: Generate and retrieve reports based on workout data.
- **Workout Comments**: Add, update, and delete comments on workouts.

## Technologies

- **Java**: Programming language used for backend development.
- **Spring Boot**: Framework for building the RESTful API.
- **Spring Security**: Provides security and JWT-based authentication.
- **PostgreSQL**: Database for data storage.
- **Spring Date JPA**: Java Persistence API for database operations.
- **Postman**: Tool used for API testing.

## Getting Started

### Prerequisites

- Java 22
- Maven
- PostgreSQL
- Postman

### Installation

1. **Clone the Repository:**

    ```bash
    git clone https://github.com/Pragadeesh-19/FitnessTracker.git
    cd FitnessTracker
    ```

2. **Configure the Database:**

    Create a PostgreSQL database and update the `application.properties` file with your database credentials:

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/fitness_tracker
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    ```

3. **Build and Run the Application:**

    Using Maven:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

### API Endpoints

- **User Authentication**
  - `POST /register` - Register a new user.
  - `POST /login` - Authenticate a user and get a JWT token.

- **Workouts**
  - `GET /api/workout` - Get all workouts for a user.
  - `POST /api/workout/create` - Create a new workout.
  - `PUT /api/workout/update/{workoutId}` - Update an existing workout.
  - `DELETE /api/workout/delete/{workoutId}` - Delete a workout.
  - `PUT /api/workout/status/{workoutId}` - Mark a workout as completed.

- **Exercises**
  - `POST /api/exercise/create` - Add an exercise to a workout.
  - `PUT /api/exercise/update` - Update an exercise.
  - `DELETE /api/exercise/delete` - Delete an exercise.

- **Workout Reports**
  - `POST /api/workout/report/generate` - Generate a report for workouts between specified dates.
  - `GET /api/workout/report` - Get all reports for a user.

- **Workout Comments**
  - `POST /api/workout/{workoutId}/comments` - Add a comment to a workout.
  - `GET /api/workout/{workoutId}/comments` - Get comments for a workout.
  - `PUT /api/workout/comments/{commentId}` - Update a comment.
  - `DELETE /api/workout/comments/{commentId}` - Delete a comment.

### Testing

Use Postman to test the API endpoints.

### Contributing

Contributions are welcome! Please open an issue or submit a pull request for any changes or enhancements.

