<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<h1>REGISTER</h1>
	<form action="${pageContext.request.contextPath}/register" method="post" >
	 
	  <div style="color:red">${errorMessage}</div>
	  <input type="text" name="username" placeholder="Username"><br>
	  <input type="password" name="password" placeholder="Password"><br>
	  
	  <input type="submit" value="Register">

	</form>

</body>
</html>