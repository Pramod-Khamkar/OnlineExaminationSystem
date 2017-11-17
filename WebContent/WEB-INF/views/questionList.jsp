<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Question List</title>
</head>
<body>
<%@include file="/WEB-INF/views/chooseLanguageAdmin.jsp" %>
<br>
	
<div class="w3-container">
  <h2 style="text-align: center;">${language} Language Questions</h2>
<c:choose>
	<c:when test="${questionList ne null}">
	  <table class="w3-table-all">
	    <thead>
	      <tr class="w3-red">
	        <th>Questions</th>
			<th>Update</th>
			<th>Delete</th>
	      </tr>
	    </thead>
	    <c:forEach var="question" items="${questionList}">
	    <tr>
			<td>
				Question Id :  ${question.questionId}<br>
				Question Description :	${question.questionDescription}<br>
				Option A :	${question.optionA}<br>
				Option B :	${question.optionB}<br>
				Option C :	${question.optionC}<br>
				Option D :	${question.optionD}<br>
				Correct Answer :  ${question.correctAnswer}<br>
			</td>
			<td>
				<a href="updateOperationOnQuestion.html?questionId=${question.questionId}&language=${question.language}" class="w3-button w3-blue">
				Update</a>
			</td>
			<td>
				<a href="deleteOperationOnQuestions.html?questionId=${question.questionId}&language=${question.language}" class="w3-button w3-red">
				Delete</a>
			</td>
		</tr>
			</c:forEach>
	  </table>
  </c:when>
  <c:otherwise>
  	<h2 style="color: red;">No Record Found</h2>
  </c:otherwise>
 </c:choose>
  <div style="color: red;text-align: center;">${message}</div>
</div>
</body>
</html>