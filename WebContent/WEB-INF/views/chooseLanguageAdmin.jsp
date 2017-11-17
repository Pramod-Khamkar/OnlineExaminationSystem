<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Category</title>
</head>
<body background="pink">
<div class="w3-center" style="margin-top: 50px;">
	<form action="getQuestionFromDB.html" method="post" style="text-align: center;">
			<label><b>Choose Language:</b></label>
				<select name="language" class="w3-indigo w3-large">
					<option value="C">C</option>
					<option value="CPP">C++</option>
					<option value="Java">JAVA</option>
				</select>
				&nbsp;&nbsp;&nbsp;
			<input type="submit" value="Get Question List">
	</form>
	
	<div style="color: red; text-align: center;">${message}</div>
</div>
</body>
</html>