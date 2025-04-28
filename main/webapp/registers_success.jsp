<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration success</title>
</head>
<body>
 <h2>Registration Successful</h2>
    <p>Welcome, <strong><%= request.getAttribute("fullname") %></strong>!</p>
    <p>Your username is: <strong><%= request.getAttribute("username") %></strong></p>
    <p>Your email is: <strong><%= request.getAttribute("email") %></strong></p>

    <hr>
    <p><a href="registration.html">Go back to registration</a></p>
</body>
</html>