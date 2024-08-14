<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        color: #333;
    }
    .container {
        background: white;
        padding: 30px;
        border: 1px solid #ddd;
        border-radius: 8px;
        width: 350px;
        box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        text-align: center;
    }
    h1 {
        margin-top: 0;
        color: #4CAF50;
        font-size: 24px; /* Smaller heading */
    }
    form {
        display: flex;
        flex-direction: column;
        align-items: flex-start;
    }
    form input, form select {
        margin-bottom: 15px;
        padding: 10px;
        width: calc(100% - 22px); /* Adjust width to account for padding */
        border: 1px solid #ddd;
        border-radius: 5px;
    }
    form input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
        padding: 15px;
        width: 100%;
        font-size: 16px;
    }
    form input[type="submit"]:hover {
        background-color: #45a049;
    }
    .form-group {
        display: flex;
        align-items: center;
        width: 100%;
    }
    .form-group label {
        width: 100px;
        font-weight: bold;
        margin-right: 10px;
    }
    .form-group input[type="radio"] {
        margin: 0 5px;
    }
    .gender-city-gap {
        margin-top:25px;
        margin-bottom: 25px; /* Increased gap */
    }
</style>
</head>
<body>
<div class="container">
    <h1>Register</h1>
    <form action="regForm" method="post">
        <div class="form-group">
            <label for="name1">Name:</label>
            <input type="text" id="name1" name="name1" />
        </div>
        <div class="form-group">
            <label for="email1">Email:</label>
            <input type="text" id="email1" name="email1" />
        </div>
        <div class="form-group">
            <label for="pass1">Password:</label>
            <input type="password" id="pass1" name="pass1" />
        </div>
        <div class="form-group gender-city-gap">
            <label>Gender:</label>
            <input type="radio" id="male" name="gender1" value="male" /><label for="male">Male</label>
            <input type="radio" id="female" name="gender1" value="female" /><label for="female">Female</label>
            <input type="radio" id="female" name="gender1" value="female" /><label for="female">Others</label>
        </div>
        <div class="form-group">
            <label for="city1">City:</label>
            <select id="city1" name="city1">
                <option>Select City</option>
                <option>Odisha</option>
                <option>Mumbai</option>
                <option>Delhi</option>
                <option>Kolkota</option>
                <option>Pune</option>
                <option>Patna</option>
            </select>
        </div>
        <input type="submit" value="Register" />
    </form>
</div>
</body>
</html>
