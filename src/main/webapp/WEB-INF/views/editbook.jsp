<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<span>${error}</span>

<form:form action="editbook" method="post" modelAttribute="obj">

Id <form:input type ="text" name = "id" path="id"  readonly="readonly" /><br>

Title <form:input type ="text" name="title" path="title" /><br>
Author<form:input type="text" name ="author" path="author" /><br>
Price<form:input type="text" name ="price" path="price"/><br>

<input type="submit" value="update">

</form:form>


</body>
</html>