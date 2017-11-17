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
<title>Show User List</title>
</head>
<body>
<div class="w3-container ">
  <h2 class="w3-center w3-teal">User List</h2>
<c:choose>
	<c:when test="${userList ne null}">
	  <table class="w3-table-all" style="text-align: center;">
	    <thead>
	      <tr class="w3-red">
	        <th><tags:message code="label.userId" /></th>
			<th><tags:message code="label.name" /></th>
			<th><tags:message code="label.gender" /></th>
			<th><tags:message code="label.phone" /></th>
			<th><tags:message code="label.mailId" /></th>
			<th><tags:message code="label.password"  /></th>
			<th><tags:message code="label.updateModify"  /></th>
			<th><tags:message code="label.delete" /></th>
	      </tr>
	    </thead>
	    <c:forEach var="user" items="${userList}">
	    <tr>
			<td>${user.userId}</td>
			<td>${user.firstName} ${user.lastName}</td>
			<td>${user.gender}</td>
			<td>${user.phone}</td>
			<td>${user.mailId}</td>
			<td>${user.password}</td>
			<td>
				<a href="updateOperationOnUser.html?userId=${user.userId}" class="w3-button w3-blue">
					<tags:message code="label.update" />
				</a>
			</td>
			<td>
				<a href="deleteOperationOnUser.html?userId=${user.userId}" class="w3-button w3-red">
					<tags:message code="label.delete" />			
				</a>
			</td>
		</tr>
			</c:forEach>
	  </table>
  </c:when>
  <c:otherwise>
  	<h2 style="color: red;">No Record Found</h2>
  </c:otherwise>
 </c:choose>
 <br>
  <div style="color: red;text-align: center;"><h3>${message}</h3></div>
</div>
</body>
</html>