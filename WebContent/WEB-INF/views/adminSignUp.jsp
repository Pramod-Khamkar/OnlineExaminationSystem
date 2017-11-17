<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/css/loginformstyles.css">
<title>Sign Up</title>
<style>
.errors {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
	<h3 class="w3-center w3-teal">
		<tags:message code="label.signUp"></tags:message>
	</h3>
	<div style="color: red; text-align: center;">${message}</div>
	<tags:url value="registerAdmin.html" var="registerAdmin"></tags:url>

	<form:form action="${registerAdmin}" commandName="admin" method="post" cssClass="form">
		<div class="container">
			<label><b><tags:message code="label.firstName" /> :</b></label>
				<form:input path="firstName" placeholder="Type First Name"/>
				<form:errors path="firstName" cssClass="errors" />
			<br>
			<label><b><tags:message code="label.lastName" /> :</b></label> 
				<form:input path="lastName"  placeholder="Type Last Name"/>
				<form:errors path="lastName" cssClass="errors"></form:errors>
			<br>
		  	<label><b><tags:message code="label.phone" /> :</b></label> 
				<form:input path="phone"  placeholder="Type Last Name"/>
				<form:errors path="phone" cssClass="errors"></form:errors>
			<br>
			
			<label><b><tags:message code="label.mailId" /> : </b></label>
				<form:input path="mailId" placeholder="Type Email Id"/>
				<form:errors path="mailId" cssClass="errors"></form:errors>
			<br>
			<label><b><tags:message code="label.password"  /> : </b></label>
				<form:password path="password" placeholder="Type Password"/>
				<form:errors path="password" cssClass="errors"></form:errors>
			<br>	
		</div>
		<div class="container" style="background-color: #f1f1f1">
				<input type="submit" value="Submit" >
		</div>
		<br>
	</form:form>
</body>