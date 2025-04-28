<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
</head>
<body>
    <% 
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) { 
    %>
        <p style="color: red; font-weight: bold;"><%= errorMessage %></p>
    <% 
        }
    %>
    <p><a href="registration.html">Go back to registration</a></p>
</body>
</html>
