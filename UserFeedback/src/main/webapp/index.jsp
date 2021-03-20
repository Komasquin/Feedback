<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>hey</h1>
<form action="save" method="post">
  <label for="comment">Comments:</label><br>
  <input type="text" id="coment" name="comment" value="${feed.comments}"><br>
  <label for="rating">Rating:</label><br>
  <input type="text" id="rating" name="rating" value="${feed.rating}"><br>
  <label for="user">User:</label><br>
  <input type="text" id="user" name="user" value="${feed.user}"><br>
  <input type="submit" value="save">
</form> 
</body>
</html>