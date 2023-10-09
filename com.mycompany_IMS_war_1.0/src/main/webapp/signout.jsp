<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Out</title>
</head>
<body>
    <h2>Sign Out</h2>
    
    <%
        // Invalidate the user's session to log them out
        session.invalidate();
    %>
    
    <script>
        // Redirect to index.html immediately using JavaScript
        window.location.href = "index.html";
    </script>
</body>
</html>
