# Blogging Platform REST API

A robust backend for a blogging platform built with Spring Boot. This API enables user registration, authentication, posts, comments, categories, and role-based access control.

---

## Features

- **JWT Authentication:** Secure login and role-based access (admin/user).
- **CRUD Operations:** Full create, read, update, delete for posts, comments, categories, and users.
- **Role-Based Security:** Restrict access to admin features.
- **Exception Handling:** Centralized error responses.
- **Pagination & Sorting:** Efficient post listing.
- **Swagger API Documentation:** Explore endpoints interactively.
- **Reusable DTOs:** Clean request/response formats.
- **JPA Repositories:** Easy database integration.

---

## Use Cases

### Admin
- Create, update, delete categories.
- Manage posts and comments.
- Manage user roles (admin/user).

### User
- Register/login (JWT authentication).
- Create, update, delete own posts.
- Comment on posts.
- View all posts and categories.

---

## Architecture

### Main Components

- **Controllers:**  
  `AuthController`, `CategoryController`, `CommentController`, `PostController`, `UserController`  
  _Handle incoming API requests._

- **Services:**  
  Located inside `/services`  
  _Contain business logic._

- **Entities:**  
  `User`, `Role`, `Post`, `Category`, `Comment`  
  _Mapped to database tables._

- **Repositories:**  
  `UserRepository`, `PostRepository`, `CategoryRepository`, `CommentRepository`, `RoleRepository`  
  _Spring Data JPA interfaces for DB access._

- **Security:**  
  `SecurityConfig`, `CustomUserDetailService`  
  _Configure Spring Security & load users._

- **Payloads (DTOs):**  
  `UserDto`, `PostDto`, `CommentDto`, etc.  
  _Define API request/response formats._

- **Config:**  
  `SwaggerConfig`, `AppConstants`, `ContentConfig`

---

## Backend Flow

```scss
Client (Postman / Frontend)  
   ↓ HTTP Request (JSON + JWT if auth)  
Spring Boot Controller (REST API Layer)  
   ↓  
Service Layer (Business Logic)  
   ↓  
Repository (JPA)  
   ↓  
Database (Persist/Fetch data)  
   ↑  
Response (JSON) back to Client
```

---

## Getting Started

1. **Clone the repository**
   ```bash
   git clone https://github.com/<your-username>/<your-repo>.git
   ```
2. **Configure database** in `application.properties` (e.g., H2, MySQL).
3. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```
4. **Explore API docs**  
   Visit `http://localhost:8080/swagger-ui.html`

---

## API Endpoints

- `/auth/register` — Register new users
- `/auth/login` — Login & receive JWT
- `/posts` — Create, list, update, delete posts
- `/comments` — Comment on posts
- `/categories` — Manage categories
- `/users` — Admin user management

---

## Tech Stack

- **Spring Boot**
- **Spring Security**
- **JWT**
- **Spring Data JPA**
- **Swagger**
- **H2/MySQL/PostgreSQL** (configurable)

---

## Contributing

1. Fork this repo
2. Create your feature branch (`git checkout -b feature/your-feature`)
3. Commit your changes (`git commit -am 'Add feature'`)
4. Push to the branch (`git push origin feature/your-feature`)
5. Create a Pull Request

---

## License

MIT

---

## Author

- [Sanjay Kumar](https://github.com/sanjaychoudhary12)
