<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<h1>LOGIN</h1>

<form action="${pageContext.request.contextPath}/login" method="post" >
	 
	  <div style="color:red">${errorMessage}</div>
	  <input type="text" name="username" placeholder="Username"><br>
	  <input type="password" name="password" placeholder="password"><br>
	  
	  <input type="submit" value="Login">

</form>

<a href="${pageContext.request.contextPath}/register">Register</a> if haven't account
</body>
</html>