# Book Library API

**Book Library API** is a simple Spring Boot CRUD project built in one day to practice the core structure of a Java backend application. It includes a layered architecture with Controller, Service, Repository, DTOs, exception handling, PostgreSQL integration, and basic book management operations such as creating, retrieving, updating, and deleting books.

## What I practiced

- Building REST endpoints with Spring Web MVC.
- Organizing code into Controller, Service, and Repository layers.
- Using Spring Data JPA to persist books in PostgreSQL.
- Separating request and response data with DTOs.
- Validating requests with Jakarta Bean Validation.
- Handling missing books with a custom exception and a global exception handler.
- Loading database configuration from a local `.env` file.

## Tech stack

- Java 17
- Spring Boot
- Spring Web MVC, Spring Data JPA, and Bean Validation
- PostgreSQL 17
- Maven Wrapper
- Docker Compose

## Project structure

```text
src/main/java/org/example/booklibraryapi/
├── controller/   # REST endpoints
├── service/      # Book management logic
├── repository/   # Database access
├── model/        # Book entity
├── dto/          # Request and response records
└── exception/    # Custom exception and error handling
```

## Run locally

Install Java 17 and Docker with Docker Compose support. Maven is provided through the wrapper.

1. Clone the repository:

   ```sh
   git clone https://github.com/iiMedR/BookLibraryAPI_SpringBoot.git
   cd BookLibraryAPI_SpringBoot
   ```

2. Copy `.env.example` to `.env`:

   ```sh
   cp .env.example .env
   ```

   On Windows PowerShell, use `Copy-Item .env.example .env`.
   The example values match the PostgreSQL credentials in `compose.yaml`. If you change them, update both files. Your local `.env` is ignored by Git.

3. Start PostgreSQL:

   ```sh
   docker compose up -d
   ```

   PostgreSQL is exposed on port `5433`. The application connects to the `booklibrary` database, and Hibernate updates its schema on startup.

4. Start the application:

   ```sh
   ./mvnw spring-boot:run
   ```

   On Windows PowerShell, use `.\mvnw.cmd spring-boot:run`.

The API runs at `http://localhost:8080/api/books`.

## API endpoints

| Method | Endpoint | Operation |
| --- | --- | --- |
| POST | `/api/books` | Create a book |
| GET | `/api/books` | Retrieve all books |
| GET | `/api/books/{id}` | Retrieve a book by ID |
| PUT | `/api/books/{id}` | Update a book |
| DELETE | `/api/books/{id}` | Delete a book |

### Create or update a book

Send this JSON body with `Content-Type: application/json` to the POST or PUT endpoint:

```json
{
  "title": "The Hobbit",
  "author": "J. R. R. Tolkien",
  "isbn": "9780547928227",
  "publishedYear": "1937"
}
```

All four fields are required and must be nonblank. The title is limited to 100 characters and the author to 30 characters. `publishedYear` is a string.

Responses include the book's generated `id`, title, author, ISBN, publication year, and `available` flag. New books are available by default. Updates change the four request fields and preserve availability.

Retrieving, updating, or deleting an unknown ID returns `404 Not Found` with an error body containing `status`, `message`, and `timestamp`. A successful deletion returns `204 No Content`.

## Scope

This is a small learning project focused on Spring Boot fundamentals. It does not include authentication, pagination, search, or a frontend.
