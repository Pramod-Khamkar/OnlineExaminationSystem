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
<meta name="viewport" content="width=device-width, initial-scale=1">
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
	<tags:url value="registerUser.html" var="registerUser"></tags:url>

	<form:form action="${registerUser}" commandName="user" method="post" cssClass="form">
		<div class="container">
			<label><b><tags:message code="label.firstName" /> :</b></label>
				<form:input path="firstName" placeholder="Type First Name"/>
				<form:errors path="firstName" cssClass="errors" />
			<br>
			<label><b><tags:message code="label.lastName" /> :</b></label> 
				<form:input path="lastName"  placeholder="Type Last Name"/>
				<form:errors path="lastName" cssClass="errors"></form:errors>
			<br>
			<label><b><tags:message code="label.gender" /> :</b></label>
				<form:radiobutton path="gender" value="Male" />Male
				<form:radiobutton path="gender" value="Female" />Female
			<br>
			
			<label><b><tags:message code="label.age" /> :</b></label> 
				<form:input path="age"  placeholder="Type Your Age"/>
				<form:errors path="age" cssClass="errors"></form:errors>
			<br>
				<br>
			<label><b><tags:message code="label.dob" /> :</b></label>
				<!-- <div class="controls_c">
              	 -->	<form:input type="text" path="dateOfBirth" id="datepicker" placeholder="Select Date Of Birth"/>
        		<!-- </div> -->
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
			<label><b><tags:message code="label.qlfy" /> :</b></label> 
			<br>
			<label><b><tags:message code="label.sscMarks" /> :</b></label> 
				<form:input path="marks_ssc"  placeholder="Type 10th Marks"/>
				<form:errors path="marks_ssc" cssClass="errors"></form:errors>
			<br>
		
			<label><b><tags:message code="label.hscMarks" /> :</b></label> 
				<form:input path="marks_hsc"  placeholder="Type 12th Marks"/>
				<form:errors path="marks_hsc" cssClass="errors"></form:errors>
			<br>
			
			<label><b><tags:message code="label.gradCollegeName" /> :</b></label> 
				<form:input path="graduationCollageName"  placeholder="Type Graduation College Name"/>
				<form:errors path="graduationCollageName" cssClass="errors"></form:errors>
			<br>	
			
			<label><b><tags:message code="label.gradMarks" /> :</b></label> 
				<form:input path="marks_graduation"  placeholder="Type Graduation Marks"/>
				<form:errors path="marks_graduation" cssClass="errors"></form:errors>
			<br>
			
			<label><b><tags:message code="label.postGradCollegeName" /> :</b></label> 
				<form:input path="postGraduationCollageName"  placeholder="Type PostGraduation College Name"/>
				<form:errors path="postGraduationCollageName" cssClass="errors"></form:errors>
			<br>	
			
			<label><b><tags:message code="label.postGradMarks" /> :</b></label> 
				<form:input path="marks_postgraduation"  placeholder="Type PostGraduation Marks"/>
				<form:errors path="marks_postgraduation" cssClass="errors"></form:errors>
			<br>
			
		</div>
		<div class="container" style="background-color: #f1f1f1">
				<input type="submit" value="Submit" >
		</div>
		<br>
	</form:form>
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