# todoApp-basic-auth-Rbac-role-based-access-control
# 📝 Advanced Todo Management API (Spring Boot)

This is a backend project built using Spring Boot that demonstrates real-world backend development practices.  
It is not just a simple CRUD app — it includes **Spring Security, DTO pattern, validation, pagination, sorting, and global exception handling**.

---

## 🚀 Features

- 🔐 User Authentication using Spring Security (Basic Auth)
- 🗄️ Database-backed login system (Custom UserDetailsService)
- 🔑 Password encryption using BCrypt
- 👥 Role-based access control (USER / ADMIN)
- 📄 Pagination & Sorting for large data handling
- 🛡️ Request validation using `@Valid`
- 🎛️ DTO pattern (Request & Response separation)
- 💥 Global exception handling with clean error responses

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL / PostgreSQL
- Maven

---

## 👥 Roles

### USER
- Can create, update, and view todos
- Limited access to data

### ADMIN
- Full access to all APIs
- Can manage all todos

---

## 🔐 Authentication Flow

1. User registers via API
2. Password is encrypted using BCrypt
3. Login happens using Basic Auth
4. Spring Security loads user from database
5. Role is checked for authorization
6. Access is granted or denied

---

## 📌 API Endpoints

### 🔑 Auth APIs


## 👨‍💻 Author

Built while learning Spring Boot, Spring Security, and backend system design fundamentals.

---

## 🧠 Concepts Used

- DTO Pattern  
- Service Layer Architecture  
- Repository Pattern  
- Global Exception Handling  
- Spring Security Authentication & Authorization  
- Pagination & Sorting  
- Input Validation  

---

## 📌 Default Configuration

- Page size: 2  
- Sort by: id  
- Password encoding: BCrypt  

---

## 🔥 Future Improvements

- JWT Authentication (recommended upgrade)  
- Refresh Token system  
- User profile management  
- Todo categories & tags  
- Email notifications  
- Frontend integration (React / Angular)  
- Unit testing (JUnit + Mockito)  
