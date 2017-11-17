<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/css/loginformstyles.css">
<title>Sign In</title>
</head>
<body>
	<h3 class="w3-center w3-teal">
		<tags:message code="label.signIn"></tags:message>
	</h3>
	<div style="color: red; text-align: center">${message}</div>
	
	<tags:url value="loginUser.html" var="loginUser"></tags:url>
	<form:form action="${loginUser}" method="post" cssClass="form">
		<div class="imgcontainer">
			<img src="resources/img/user.png" alt="User Login" class="avatar">
		</div>

		<div class="container">
			<label><b><tags:message code="label.userName" /></b></label> 
				<input type="text" placeholder="Enter Username" name="username" required> 
			<label><b><tags:message code="label.password" /></b></label>
				<input type="password" placeholder="Enter Password" name="password" required>
			<button type="submit">Login</button>
			<input type="checkbox" checked="checked"> Remember me
		</div>
		<div class="container" style="background-color: #f1f1f1">
			<button type="reset" class="cancelbtn">Reset</button>
			<span class="psw"><a href="userSignUp.html">Sign Up Here</a></span>
		</div>
		<br>
		
	</form:form>
		
</body>
</html>