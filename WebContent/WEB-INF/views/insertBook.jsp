<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert book</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>ADD NEW BOOK</h1>

<form action="${pageContext.request.contextPath}/insertBook" 
			method="post" >
	<input type="text" name="name" value="${book.name}"  placeholder="Book Name"> <br>
	<input type="text" name="author" value="${book.name}" placeholder="Author"> <br>
	<input type="text" name="publisher" value="${book.name}" placeholder="Publisher"> <br>
	<input type="text" name="type" value="${book.name}" placeholder="Type"> <br>
	<input type="text" name="language" value="${book.name}" placeholder="Language"> <br>
	<input type="text" name="description" value="${book.name}" placeholder="Description"> <br>
	<input type="number" name="quantity" value="${book.name}" placeholder="Quantity"> <br>
	
	<input type="submit" value="Add">
</form>
</body>
</html>