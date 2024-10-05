<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 20px;
        }
        h2 {
            color: #333;
        }
        .form-container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
            width: 400px;
            margin: auto;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"], select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .error {
            color: red;
            font-size: 12px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
            width: 100%;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .radio-group, .checkbox-group {
            margin-bottom: 10px;
        }
        .radio-group label, .checkbox-group label {
            margin-right: 15px;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>User Form</h2>
        <form:form method="post" modelAttribute="userObj" action="adduser">

            <div class="form-group">
                <form:label path="id">ID:</form:label>
                <form:input path="id" />
                <form:errors path="id" cssClass="error" />
            </div>

            <div class="form-group">
                <form:label path="name">Name:</form:label>
                <form:input path="name" />
                <form:errors path="name" cssClass="error" />
            </div>

            <div class="form-group">
                <form:label path="age">Age:</form:label>
                <form:input path="age" />
                <form:errors path="age" cssClass="error" />
            </div>

            <div class="radio-group">
                <label>Gender:</label>
                <form:radiobutton path="gender" value="male" /> Male
                <form:radiobutton path="gender" value="female" /> Female
                <form:errors path="gender" cssClass="error" />
            </div>

            <div class="checkbox-group">
                <label>Frameworks:</label>
                <form:checkboxes items="${lst}" path="frameworks" />
                <form:errors path="frameworks" cssClass="error" />
            </div>

            <div class="radio-group">
                <label>Numbers:</label>
                <form:radiobuttons path="number" items="${numList}" />
                <form:errors path="number" cssClass="error" />
            </div>

            <div class="form-group">
                <form:label path="country">Country:</form:label>
                <form:select path="country" items="${list}" multiple="multiple" />
                <form:errors path="country" cssClass="error" />
            </div>

            <div>
                <input type="submit" value="Submit" />
            </div>

        </form:form>
    </div>
</body>
</html>