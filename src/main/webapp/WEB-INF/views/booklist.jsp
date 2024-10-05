<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
   <!-- Main Container -->
    <div class="container mt-5">
        <h2 class="mb-4">Book List</h2>

        
        <!-- Responsive Table -->
        <table class="table table-hover table-bordered">
            <tr>
          <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Price</th>
     </tr>
           <c:forEach var="book" items="${list}">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.price}</td>
            </tr>
            <td>
                                <a href="editbook/${book.id}"  class="btn btn-primary" >Edit</a>
                               <a href="book/deletebook?id=${book.id}" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this book?');">Delete</a>
                               </td>
        </c:forEach>
           
           
                
         
        </table>
        </div>
       

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>