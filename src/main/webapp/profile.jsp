<%@page import="in.sp.model.UserModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        text-align: center;
    }
    .container {
        background: white;
        padding: 30px;
        border: 1px solid #ddd;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 300px;
    }
    h3 {
        color: #333;
        font-size: 24px;
        margin: 0;
    }
    a {
        color: #4CAF50;
        text-decoration: none;
        font-size: 18px;
        display: block; /* Ensures the link is on a new line */
        margin-top: 20px;
    }
    a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
<div class="container">
    <%
        HttpSession usersession = request.getSession(false);
        UserModel user = (UserModel) usersession.getAttribute("session_user");
        String name = "";
        if (user != null) {
            name = user.getName();
        }
    %>
    <h3>Welcome, <%= name %>!</h3>
    <a href="logout">Logout</a>
</div>
</body>
</html>
