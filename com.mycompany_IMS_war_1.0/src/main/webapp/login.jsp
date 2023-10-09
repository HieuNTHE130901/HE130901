<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h2>Login</h2>
    <form action="" method="post">
        <label for="email">Email:</label>
        <input type="email" name="email" required><br><br>

        <label for="password">Password:</label>
        <input type="password" name="password" required><br><br>

        <input type="submit" value="Login">
    </form>

    <%
        if (request.getMethod().equalsIgnoreCase("POST")) {
            // Retrieve user input
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            // Initialize database connection variables
            String jdbcUrl = "jdbc:mysql://localhost:3306/issue_management_system";
            String dbUser = "root";
            String dbPassword = "123456";

            try {
                // Load the MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish a database connection
                Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

                // Create a SQL query
                String query = "SELECT user_id, user_role FROM Users WHERE email = ? AND password = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);

                // Execute the query
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    // User authentication successful
                    int userId = resultSet.getInt("user_id");
                    String userRole = resultSet.getString("user_role");

                    // Store user data in session for future use
                    session.setAttribute("user_id", userId);
                    session.setAttribute("user_role", userRole);

                    // Redirect based on user role
                    if ("Student".equals(userRole)) {
                        response.sendRedirect("user_student.html");
                    } else if ("Teacher".equals(userRole)) {
                        response.sendRedirect("user_teacher.html");
                    } else if ("Manager".equals(userRole)) {
                        response.sendRedirect("user_manager.html");
                    } else if ("Admin".equals(userRole)) {
                        response.sendRedirect("user_admin.html");
                    } else {
                        out.println("Unknown user role: " + userRole);
                    }
                } else {
                    // Authentication failed
                    out.println("Login failed. Incorrect email or password.");
                }

                // Close database resources
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                out.println("An error occurred: " + e.getMessage());
            }
        }
    %>
</body>
</html>
