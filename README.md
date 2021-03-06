# Description

## Documentation
This is a brief documentation of the project.

In order to view a detailed documentation of the solution, you can visit the document [Persado Project Documentation - Fotis Floros.pdf](https://github.com/fotf91/persadodeliverable/blob/master/detailed_documentation/Persado%20Project%20Documentation%20-%20Fotis%20Floros.pdf) uploaded on Github.
The detailed documentation of the solution contains:
- Description of the database tables
- Description of the Business Objects used, with the respective validations and format of the fields.
- Description of the Services with examples of input/output and further errors that may occur along with the error code and sample response.
- General errors that may occur per case.

## Collection of services
A collection of services with sample input and endpoints per operation implemented, has been uploaded on Github as file [Persado Services.postman_collection.json](https://github.com/fotf91/persadodeliverable/blob/master/detailed_documentation/Persado%20Services.postman_collection.json). This file can be imported as a collection in Postman in order to be able to test the functionality easier.

## Technology Used

This project has been developed using the following technologies:
- Java 1.8 with Spring Boot Framework
- Apache Maven 3.6.3
- H2 Database

# Get Started

## Download the code
Use the following command to clone the project:
- ```git clone https://github.com/fotf91/persadodeliverable```

## Prerequisites

Java and maven must be installed.

## How to run the project

Navigate inside the project folder in order to run the application locally, then execute the following commands:
- mvn clean install
- mvn spring-boot:run

## Access Information
Database can be accessed from the browser using:
- Endpoint: http://localhost:8080/h2
- Username: user
- Password: pass

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

