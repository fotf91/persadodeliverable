# Description

## Documentation
This is a brief documentation of the project.

In order to view a detailed documentation of the solution, you can visit the document *Persado Project - Fotis Floros.pdf* uploaded on Github.
The detailed documentation of the solution contains:
- Description of the database tables
- Description of the Business Objects used, with the respective validations and format of the values.
- Description of the Services with examples of input/output and further errors that may occur along with the error code and sample response.
- General errors that may occur per case.

## Collection of services
A collection of services with sample input and endpoints per operation implemented, has been uploaded on Github as file *Persado Services.postman_collection.json*.

## Technology Used

This project has been built using the following technologies:
- Java 1.8 with Spring Boot Framework
- Apache Maven 3.6.3
- H2 Database

# Run the Project

## Prerequisites

Java and maven must be installed.

## How to run the project

Navigate inside the project folder in order to run the application locally, then execute the following commands:
- mvn clean install
- mvn spring-boot:run

## Access Information
Database can be accessed from the browser using the endpoint: http://localhost:8080/h2
Username: user
Password: pass

# REST Operations

The following REST operations are implemented in the project.

When running the project, predefined data will be inserted into the database. The below service invocation examples are based on the predefined data.
Accessing the database(previous chapter) you can inspect the predefined data.

## Create Author

- Endpoint: http://localhost:8080/api/author
- HTTP Verb: POST
- Sample Request: ```{
   "firstName": "Fotis",
   "lastName": "Floros",
   "email": "fotf91@gmail.com",
   "dateOfBirth": "1990-07-19"
}```

## Create Publisher

- Endpoint: http://localhost:8080/api/publisher
- HTTP Verb: POST
- Sample Request: ```{
   "name": "Patakis",
   "telephone": "2104315881",
   "address": "Ermou 10"
}```

## Create Book

- Endpoint: http://localhost:8080/api/book
- HTTP Verb: POST
- Sample Request: ```{
   "title": "Book Title",
   "description": "Book description.",
   "isbn": "000-0-00-000000-1",
   "visible": true,
   "creationDate": "1990-05-10",
   "authorId": "1",
   "publisherId": null
}```

## Update Book

- Endpoint: http://localhost:8080/api/book/<isbn\>
- HTTP Verb: PUT
- Sample Request Endpoint: http://localhost:8080/api/book/1
- Sample Request: ```{
    "title": "My Book",
    "description": "My description.",
    "isbn": "000-0-00-000511-0",
    "visible": true,
    "creationDate": "1990-05-10",
    "authorId": "1",
    "publisherId": null
}```

## Delete Book

- Endpoint: http://localhost:8080/api/book/<isbn\>
- HTTP Verb: DELETE
- Sample Request Endpoint: http://localhost:8080/api/book/978-0-26-110334-0

## Retrieve Visible Books by Publisher Id

- Endpoint: http://localhost:8080/api/book?publisherId=<publisherId\>
- HTTP Verb: GET
- Sample Request Endpoint: http://localhost:8080/api/book?publisherId=1

## Retrieve Visible Books which have Publisher

- Endpoint: http://localhost:8080/api/book/published
- HTTP Verb: GET
- Sample Request Endpoint: http://localhost:8080/api/book/published

## Retrieve Books by Isbn

- Endpoint: http://localhost:8080/api/book/<isbn\>
- HTTP Verb: GET
- Sample Request Endpoint: http://localhost:8080/api/book/978-3-16-148410-0

