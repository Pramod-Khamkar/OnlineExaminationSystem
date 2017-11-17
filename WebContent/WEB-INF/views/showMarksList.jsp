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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Show Mark List</title>
</head>
<body>
<div class="w3-container">
  <h2 style="text-align: center;" class="w3-teal">
  	<tags:message code="label.userMarksList"></tags:message>
  </h2>
<c:choose>
	<c:when test="${testResultList ne null}">
	  <table class="w3-table-all" style="text-align: center;">
	    <thead>
	      <tr class="w3-red">
	        <th><tags:message code="label.userId" /></th>
			<th><tags:message code="label.name" /></th>
			<th><tags:message code="label.mailId" /></th>
			<th><tags:message code="label.testId" /></th>
			<th><tags:message code="label.language" /></th>
			<th><tags:message code="label.questionAttempted" /></th>
			<th><tags:message code="label.marks" /></th>
			<th><tags:message code="label.result" /></th>
			<th><tags:message code="label.delete" /></th>
	      </tr>
	    </thead>
	    <c:forEach var="testResult" items="${testResultList}">
	    <tr>
			<td>${testResult.userId}</td>
			<td>${testResult.firstName} ${testResult.lastName}</td>
			<td>${testResult.mailId}</td>
			<td>${testResult.testId}</td>
			<td>${testResult.language}</td>
			<td>${testResult.questionAttempted}</td>
			<td>${testResult.marks}</td>
			<td>${testResult.result}</td>
			<td>
				<a href="deleteOperationOnUserMarksList.html?testId=${testResult.testId}" class="w3-button w3-red">
					<tags:message code="label.delete" />
				</a>
			</td>
		</tr>
			</c:forEach>
	  </table>
  </c:when>
  <c:otherwise>
  	<h2 style="color: red;">No Mark List Found</h2>
  </c:otherwise>
 </c:choose>
 <br>
  <div style="color: red;text-align: center;"><h3>${message}</h3></div>
  </div>
</body>
</html>