<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>User Info</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 600px;
            margin: auto;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }
        h2 {
            text-align: center;
            color: #444;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        table, th, td {
            border: 1px solid #ccc;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f7f7f7;
        }
        ul {
            margin: 0;
            padding-left: 20px;
        }
        ul li {
            margin-bottom: 5px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>User Information</h2>

    <table>
        <tr>
            <th>ID</th>
            <td>${user.id}</td>
        </tr>
        <tr>
            <th>Name</th>
            <td>${user.name}</td>
        </tr>
        <tr>
            <th>Age</th>
            <td>${user.age}</td>
        </tr>
        <tr>
            <th>Gender</th>
            <td>${user.gender}</td>
        </tr>
        <tr>
            <th>Frameworks</th>
            <td>
                <ul>
                    <c:forEach items="${user.frameworks}" var="fr">
                        <li>${fr}</li>
                    </c:forEach>
                </ul>
            </td>
        </tr>
        <tr>
            <th>Special Number</th>
            <td>
                <c:if test="${user.number == 1}">
                    Number 1
                </c:if>
            </td>
        </tr>
        <tr>
            <th>Country</th>
            <td>${user.country}</td>
        </tr>
    </table>
</div>

</body>
</html>