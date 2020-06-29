<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update book</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>UPDATE BOOK</h1>

<form action="${pageContext.request.contextPath}/updateBook" method="post" >

	<input type="number" name="id" value="${book.id}"> <br>
	<input type="text" name="name" value="${book.name}"  placeholder="Book Name"> <br>
	<input type="text" name="author" value="${book.author}" placeholder="Author"> <br>
	<input type="text" name="publisher" value="${book.publisher}" placeholder="Publisher"> <br>
	<input type="text" name="type" value="${book.type}" placeholder="Type"> <br>
	<input type="text" name="language" value="${book.language}" placeholder="Language"> <br>
	<input type="text" name="description" value="${book.description}" placeholder="Description"> <br>
	<input type="number" name="quantity" value="${book.quantity}" placeholder="Quantity"> <br>

	<input type="submit" value="Save">
</form>
</body>
</html>