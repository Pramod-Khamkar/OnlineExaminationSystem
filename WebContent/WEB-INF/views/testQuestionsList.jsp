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
<title>testQuestionsList</title>
</head>
<body>

<table >
	
		
		<div style="color: blue; text-align: center;"><h3>${language} Programming Test</h3></div><br><br>
		<div style="color: red; text-align: center;">${message}</div><br><br>
		<c:if test="${questionList != null}">
			<c:set var="i" value="${1}"></c:set>
			<c:forEach var="question" items="${questionList}">
				<tr><td> Question <c:out value="${i}"></c:out> : </td></tr>
				<tr><td> ${question.questionDescription}</td></tr>
				 <tr><td> Option A : ${question.optionA}</td></tr>
				 <tr><td> Option B : ${question.optionB}</td></tr>
				 <tr><td> Option C : ${question.optionC}</td></tr>
				 <tr><td> Option D : ${question.optionD}</td></tr>
				<tr><td> Type Answer : <input type="text" name="answer"></td></tr>
				<c:set var="i" value="${i + 1}" scope="page"/>
				<tr><td></td></tr>
			</c:forEach>
		<%-- <table>
				<tr>${questionList.questionDescription}<tr>
				 <tr><td> <input type="radio" name="answer" value="A"> ${questionList.optionA}</td></tr>
				 <tr><td> <input type="radio" name="answer" value="B"> ${questionList.optionB}</td></tr>
				 <tr><td> <input type="radio" name="answer" value="C"> ${questionList.optionC}</td></tr>
				 <tr><td> <input type="radio" name="answer" value="D"> ${questionList.optionD}</td></tr>
		</table> --%>
		</c:if>
		<input type="hidden" value="${language}" name="language">
		<input type="submit" value="Submit Test">
	</form>
</table>
</body>
</html>