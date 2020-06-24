<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>LOGIN</h1>

<form action="/action_page.php">
	<div>
	  <label for="fname">First name:</label><br>
	  <input type="text" id="fname" name="fname" value="John"><br>
	  <label for="lname">Last name:</label><br>
	  <input type="text" id="lname" name="lname" value="Doe"><br><br>
	  <input type="submit" value="Login">
	</div>
</form>

<a href="${pageContext.request.contextPath}/register">Register</a> if haven't account
</body>
</html>