<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>

<link rel="stylesheet" type="text/css" href="<c:url value='/resource/css/style.css'/>">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h1>Welcome to my home page</h1>
	<img src="resource/images/booklogo.jpg" width="600" height="600">
</body>
</html>