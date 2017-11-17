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
<title>Navbar</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login Form</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<p>Index Page</p>
	<div class="w3-bar w3-light-grey w3-border w3-xlarge" style="padding-top: 25px">
		<a href="index.html" class="w3-bar-item w3-button w3-green">
			<i class="fa fa-home"></i>
		</a> 
		<div class="w3-large">
			<a href="userSignIn.html" class="w3-bar-item w3-button w3-hover-orange">
				<img alt="User Login" src="resources/img/user.png" width=25px height="25px"/> User Login
			</a> 
		</div>
		<div class="w3-large w3-right">
			<a href="adminSignIn.html" class="w3-bar-item w3-button w3-hover-orange">
				<img alt="Admin Login" src="resources/img/admin.png" width=25px height="25px"/>
			</a> 
		</div>
	</div>
</body>
</html>