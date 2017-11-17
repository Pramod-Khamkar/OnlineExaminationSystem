<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/css/loginformstyles.css">
<title>Update User Details</title>
<style>
.errors {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
<h3 class="w3-center w3-teal">
		<tags:message code="label.updateUserDetails"></tags:message>
	</h3>
	<div style="color: red; text-align: center;">${message}</div>
	<br>
<c:choose>
	<c:when test="${user ne null}">
		<tags:url value="updateUser.html" var="updateUser"></tags:url>
	
		<form:form action="${updateUser}" commandName="user" method="post" cssClass="form">
			<div class="container">
				<label><b><tags:message code="label.userId" /> :</b></label>
					<input type="text" value="${user.userId}" name="userId" readonly="readonly"/>
				<br>
				<label><b><tags:message code="label.firstName" /> :</b></label>
					<input type="text" value="${user.firstName}" name="firstName" placeholder="Type First Name" />
				<br>
				<label><b><tags:message code="label.lastName" /> :</b></label> 
					<input type="text" value="${user.lastName}"  name="lastName" placeholder="Type Last Name"/>
				<br>
				<label><b><tags:message code="label.gender" /> :</b></label>
					<input type="text" value="${user.gender}"  name="gender" readonly="readonly"/>
				<br>
				
				<label><b><tags:message code="label.age" /> :</b></label> 
					<input type="text" value="${user.age}"  name="age" placeholder="Type Your Age"/>
				<br>
					<br>
				<label><b><tags:message code="label.dob" /> :</b></label>
	              		<input type="text" value="${user.dateOfBirth}" name="dateOfBirth" id="datepicker" placeholder="Select Date Of Birth"/>
	        		<br>
	        	<label><b><tags:message code="label.phone" /> :</b></label> 
					<input type="text" value="${user.phone}" name="phone" placeholder="Type Last Name"/>
				<br>
				
				<label><b><tags:message code="label.mailId" /> : </b></label>
					<input type="text" value="${user.mailId}" name="mailId" placeholder="Type Email Id"/>
				<br>
				<label><b><tags:message code="label.password"  /> : </b></label>
					<input type="text" value="${user.password}" name="password" placeholder="Type Password"/>
							<br>
				<label><b><tags:message code="label.qlfy" /> :</b></label> 
				<br>
				<label><b><tags:message code="label.sscMarks" /> :</b></label> 
					<input type="text" value="${user.marks_ssc}" name="marks_ssc" placeholder="Type 10th Marks"/>
				<br>
			
				<label><b><tags:message code="label.hscMarks" /> :</b></label> 
					<input type="text" value="${user.marks_hsc}" name="marks_hsc" placeholder="Type 12th Marks"/>
				<br>
				
				<label><b><tags:message code="label.gradCollegeName" /> :</b></label> 
					<input type="text" value="${user.graduationCollageName}" name="graduationCollageName" placeholder="Type Graduation College Name"/>
				<br>	
				
				<label><b><tags:message code="label.gradMarks" /> :</b></label> 
					<input type="text" value="${user.marks_graduation}" name="marks_graduation" placeholder="Type Graduation Marks"/>
				<br>
				
				<label><b><tags:message code="label.postGradCollegeName" /> :</b></label> 
					<input type="text" value="${user.postGraduationCollageName}"  name="postGraduationCollageName" placeholder="Type PostGraduation College Name"/>
				<br>	
				
				<label><b><tags:message code="label.postGradMarks" /> :</b></label> 
					<input type="text" value="${user.marks_postgraduation}" name="marks_postgraduation" placeholder="Type PostGraduation Marks"/>
				<br>
			</div>
			<div class="container" style="background-color: #f1f1f1">
					<input type="submit" value="Submit" >
			</div>
			<br>
		</form:form>
	</c:when>
	<c:otherwise>
		<h2 style="color: red; text-align: center;">No record Found</h2>
	</c:otherwise>
</c:choose> 

	<script>
		$(function() {
	        $( "#datepicker" ).datepicker({
	            dateFormat : 'mm/dd/yy',
	            changeMonth : true,
	            changeYear : true,
	            yearRange: '-100y:c+nn',
	            maxDate: '-1d'
	        });
	    });

	</script>
</body>
</html>