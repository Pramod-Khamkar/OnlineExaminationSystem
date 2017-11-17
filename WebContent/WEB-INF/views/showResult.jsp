<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3 class="w3-center w3-teal">
		 Result 
	</h3>
	<div class="w3-container">
  		<div class="w3-panel w3-pale-blue w3-leftbar w3-rightbar w3-border-blue">
  			<p><tags:message code="label.userId" /> : ${testResult.userId}</p>
  			<p><tags:message code="label.name" /> : ${testResult.firstName} ${testResult.lastName}</p>
	    	<p><tags:message code="label.language" /> : ${testResult.language}</p>
	    	<p><tags:message code="label.marks" /> : ${testResult.marks}/10</p>
	    	<p><tags:message code="label.result" /> : ${testResult.result}</p>
	    	<p><tags:message code="label.questionAttempted" /> : ${testResult.questionAttempted}</p>
  		</div>
  	</div>

<div class="w3-center">
	<h3 class="w3-button w3-orange w3-hover-khaki">For Another Quiz,<a href="showCategory.html"> Click Here</a></h3>
</div>
</body>
</html>