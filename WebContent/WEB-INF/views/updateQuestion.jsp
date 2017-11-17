<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/loginformstyles.css">
<title>update Question</title>
</head>
<body>
<h3 class="w3-center w3-teal">
		<tags:message code="label.updateQuestion"></tags:message>
</h3>
<tags:url value="updateQuestion.html" var="updateQuestion"></tags:url>
<form:form action="${updateQuestion}" commandName="question" method="post" cssClass="form">
		<div class="container">
			<label><b>Question Id:</b></label>
				<input type="text" value="${question.questionId}" name="questionId" readonly="readonly"> 
			<br>
			<label><b>Language:</b></label>
				<input type="text" value="${question.language}" name="language"> 
			<br>
			<label><b>questionDescription:</b></label>
			
				<input type="text" value="${question.questionDescription}"  name="questionDescription"  cols="50" rows="5"></textarea>
			<br>
			<label><b>optionA:</b></label> 
				<input type="text" value="${question.optionA}" name="optionA"  placeholder="Type Option A"/>
			<br>
		  	<label><b>optionB:</b></label> 
				<input type="text" value="${question.optionB}" name="optionB" placeholder="Type Option B "/>
			<br>
			
			<label><b>optionC: </b></label>
				<input type="text"  value="${question.optionC}" name="optionC" placeholder="Type Option C"/>
			<br>
			<label><b>optionD: </b></label>
				<input type="text" value="${question.optionD}" name="optionD" placeholder="Type Option D"/>
			<br>
			<label><b>correctAnswer: </b></label>
				<input value="${question.correctAnswer}" name="correctAnswer" placeholder="Type Correct Answer"/>
			<br>	
		</div>
		<div class="container" style="background-color: #f1f1f1">
				<input type="submit" value="Submit" >
		</div>
		<br>
	</form:form>
	<div style="color: red; text-align: center;">${message}</div>
</body>
</html>