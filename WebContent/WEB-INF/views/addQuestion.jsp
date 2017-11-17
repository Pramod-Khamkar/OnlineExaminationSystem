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
<link rel="stylesheet" href="resources/css/loginformstyles.css">
<script type="text/javascript" src="resources/js/tabs.js"></script>
<title>Add Questions</title>
</head>
<body>
<h3 class="w3-center w3-teal">
		<tags:message code="label.addQuestions"></tags:message>
</h3>
	<div style="color: red; text-align: center;">${message}</div>
	<tags:url value="addQuestionToTable.html" var="addQuestion"></tags:url>

	<form:form action="${addQuestion}" commandName="question" method="post">
		<div class="container">
			<label>
				<b>
					<tags:message code="label.chooseLanguage"></tags:message>:
				</b>
			</label>
				<form:select path="language" cssStyle="text-align:center;">
					<form:option value="C">
						<tags:message code="label.c"></tags:message>
					</form:option>
					<form:option value="CPP">
						<tags:message code="label.cpp"></tags:message>
					</form:option>
					<form:option value="Java">
						<tags:message code="label.java"></tags:message>
					</form:option>
				</form:select>
			<br>
			<label style="text-align: center;">
				<b><tags:message code="label.questionDescription"></tags:message>:</b>
			</label>
				<form:textarea path="questionDescription" placeholder="Type Question" cols="60" rows="5"/>
				<form:errors path="questionDescription" cssClass="errors" />
			<br>
			<label>
				<b><tags:message code="label.optionA"></tags:message>:</b>
			</label> 
				<form:input path="optionA"  placeholder="Type Option A"/>
				<form:errors path="optionA" cssClass="errors"></form:errors>
			<br>
		  	<label>
		  		<b><tags:message code="label.optionB"></tags:message>:</b>
		  	</label> 
				<form:input path="optionB"  placeholder="Type Option B "/>
				<form:errors path="optionB" cssClass="errors"></form:errors>
			<br>
			
			<label>
				<b><tags:message code="label.optionC"></tags:message>: </b>
			</label>
				<form:input path="optionC" placeholder="Type Option C"/>
				<form:errors path="optionC" cssClass="errors"></form:errors>
			<br>
			<label>
				<b><tags:message code="label.optionD"></tags:message>: </b>
			</label>
				<form:input path="optionD" placeholder="Type Option D"/>
				<form:errors path="optionD" cssClass="errors"></form:errors>
			<br>
			<label>
				<b><tags:message code="label.correctAnswer"></tags:message>: </b>
			</label>
				<form:input path="correctAnswer" placeholder="Type Correct Answer"/>
				<form:errors path="correctAnswer" cssClass="errors"></form:errors>
			<br>	
		</div>
		<div class="container" style="background-color: #f1f1f1">
				<input type="submit" value="Submit" >
		</div>
		<br>
	</form:form>
	
</body>
</html>