# Spring JWT Authentication API

This project is a RESTful API built with Spring Boot that provides user authentication using JSON Web Tokens (JWT). It includes basic user registration and login functionality, secure endpoint access, and MongoDB integration for storing user data.

## Features

- JWT-based authentication
- User registration and login
- MongoDB integration (local or MongoDB Atlas)
- Spring Security for role-based access control

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.6+
- MongoDB (local installation or Atlas account)

### Configuration

Update the `application.properties` file located in `src/main/resources/` with your desired MongoDB configuration:

```properties
spring.application.name=restful.api
spring.data.mongodb.auto-index-creation=true
spring.data.mongodb.uri=mongodb://localhost:27017  # or your MongoDB Atlas URI
spring.data.mongodb.database=springSecurity

jwt.secret=your-own-secret-key
jwt.expirationMs=36000000
```

**Important:**
- Replace `your-own-secret-key` with a secure, randomly generated string.
- You should **not** commit your secret key to version control. 


### Running the Application

```bash
mvn clean install
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

## API Documentation

[View full documentation here](https://documenter.getpostman.com/view/32298013/2sB2j4eqP3)

## MongoDB Setup

You can use a local MongoDB instance:

```bash
mongodb://localhost:27017
```

Or use MongoDB Atlas by replacing the `spring.data.mongodb.uri` with your connection string:

```
mongodb+srv://<username>:<password>@<cluster>.mongodb.net/<dbname>?retryWrites=true&w=majority
```

## License

This project is licensed under the MIT License.
