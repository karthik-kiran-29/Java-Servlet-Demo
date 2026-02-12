# Servlet Login Application

A simple Jakarta Servlet-based web application that demonstrates user authentication with role-based routing using cookies.

## Project Overview

This application implements a basic login system that authenticates users and directs them to role-specific pages based on their credentials. It uses HTTP cookies for session management and request dispatchers for page routing.

## Features

- **User Authentication**: Simple login form with username and password fields
- **Role-Based Routing**: Routes users to Admin or User pages based on credentials
- **Cookie Management**: Uses HTTP cookies to store and retrieve user information
- **Request Dispatching**: Forward requests between servlets without page reload

## Project Structure

```
ServletDemo/
├── LoginServlet.java        # Handles login requests and routing
├── AdminServlet.java        # Admin dashboard page
├── UserServlet.java         # User dashboard page
└── index.html               # Login form page
```

## Technologies Used

- **Jakarta Servlet API** (jakarta.servlet)
- **HTTP Cookies** for session management
- **Request Dispatchers** for server-side forwarding
- **Tailwind CSS** for responsive UI styling
- **Java 11+**

## How It Works

### 1. Login Flow

User fills the login form with username and password → Form submits to `/login` endpoint

### 2. Authentication

LoginServlet receives credentials and creates a cookie with the username value

### 3. Role-Based Routing

- If username is "Admin" → Forward to **AdminServlet**
- Otherwise → Forward to **UserServlet**

### 4. Display User Information

The respective servlet retrieves the username from the cookie and displays it on the dashboard

## Setup & Installation

1. **Deploy to Application Server**
   - Copy the project to your Jakarta EE compatible application server (Tomcat 10+, Payara, WildFly, etc.)

2. **Build the Project**
   ```bash
   mvn clean install
   ```

3. **Start the Server**
   - Start your application server

4. **Access the Application**
   - Navigate to `http://localhost:8080/ServletDemo/`

## Usage

### Login Page

<img width="789" height="289" alt="image" src="https://github.com/user-attachments/assets/661bf4c8-7766-44fb-bd63-ec28fceb8a6d" />

**Steps:**
1. Enter username in the "UserName" field
2. Enter password in the "Password" field
3. Click "Submit" button

### Admin Dashboard

<img width="971" height="314" alt="image" src="https://github.com/user-attachments/assets/2cec551f-2a13-4bbc-b32b-cd14e6ed404d" />

**Credentials:** username = "Admin"

Displays: "Admin Page : Admin"

### User Dashboard

<img width="860" height="226" alt="image" src="https://github.com/user-attachments/assets/c1ecabbd-d5e0-42d4-9cb3-db5d66f4e3b2" />


**Credentials:** Any username other than "Admin"

Displays: "User Page : [username]"

## API Endpoints

| Endpoint | Method | Purpose |
|----------|--------|---------|
| `/` | GET | Displays login form |
| `/login` | GET | Processes login credentials |
| `/AdminServlet` | GET | Admin dashboard (forwarded) |
| `/UserServlet` | GET | User dashboard (forwarded) |

## Key Components

### LoginServlet
- Receives username and password from login form
- Creates a cookie with username value
- Routes to AdminServlet or UserServlet based on username

### AdminServlet
- Reads username from cookies
- Displays admin-specific dashboard
- Includes null cookie validation

### UserServlet
- Retrieves username from session/cookies
- Displays user-specific dashboard

## Code Snippet: Cookie Management

```java
// Creating a cookie
Cookie cookie = new Cookie("username", user);
response.addCookie(cookie);

// Reading cookies
Cookie[] cookies = request.getCookies();
for(Cookie cookie : cookies) {
    if ("username".equals(cookie.getName())) {
        user = cookie.getValue();
        break;
    }
}
```

## Security Notes

⚠️ **Important:** This is a demonstration application and should NOT be used in production without the following enhancements:

- Implement proper password hashing and verification
- Use HTTPS for secure data transmission
- Add CSRF protection tokens
- Implement rate limiting for login attempts
- Add input validation and sanitization
- Use HttpSession instead of plain cookies for sensitive data
- Implement proper logout functionality
- Add user roles and permissions system
- Validate and sanitize all user inputs

## Future Enhancements

- Database integration for user credentials
- Session timeout management
- Remember-me functionality
- User registration system
- Password reset functionality
- Logout feature with session invalidation
- User roles and permissions

## Testing

### Test Credentials

**Admin User:**
- Username: `Admin`
- Password: (any value)
- Expected Route: AdminServlet

**Regular User:**
- Username: (any value except "Admin")
- Password: (any value)
- Expected Route: UserServlet

## License

This project is provided as-is for educational purposes.

## Author

Created for servlet and web application learning purposes.

---

**Last Updated:** February 12, 2026
