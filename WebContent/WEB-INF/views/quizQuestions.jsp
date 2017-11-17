<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz Questions</title>
<!-- <script type="text/javascript">
function radioCheckedStatus(){
	var radio = document.getElementById("radio");
	if(!radio.checked){
		window.alert("Please, Select Option to save your Answer...");
	}
}
</script> -->
</head>
<body>

<div class="w3-container w3-center">
  <h2 class="w3-pale-blue">${language} Programming Test</h2>

<c:choose>
 	<c:when test="${questiontData ne null}">
	  	<form action="collectAnswers.html" method="get">
	  		<table class="w3-card w3-table-all" >
	  		<c:forEach var="question" items="${questiontData}">
	    		<thead>
	      			<tr class="w3-pale-red">
	        			<th>Question ${question.questionId} : ${question.questionDescription}</th>
	      			</tr>
	    		</thead>
	    		<tr>
	      			<td><input type="radio" name="answer" value="A" id="radio">  ${question.optionA}</td>
	    		</tr>
	    		<tr>
	      			<td><input type="radio" name="answer" value="B" id="radio">  ${question.optionB}</td>
	    		</tr>
			    <tr>
			      	<td><input type="radio" name="answer" value="C" id="radio">  ${question.optionC}</td>
			    </tr>
			    <tr>
			      	<td><input type="radio" name="answer" value="D" id="radio">  ${question.optionD}</td>
			    </tr>
			    <tr>
			    	<td>
			    		<input type="hidden" name="questionId" value="${question.questionId}">
 						<input type="hidden" name="correctAnswer" value="${question.correctAnswer}">
 						<input type="hidden" name="language" value="${language}">
 					</td>
			    </tr>
			</c:forEach>
	 	 </table>
	 	 <br>
	  	<input type="submit" value="Save" class="w3-button w3-black w3-hover-green">
	 	</form>
	</c:when>
	<c:otherwise>
  		<h1>No Records Found</h1>
	</c:otherwise>
</c:choose>
<br>
	<div style="text-align: center; color: green;">${message}</div>
<br><br>
<div class="w3-show-inline-block w3-center">
	<div class="w3-bar w3-border ">
		<c:forEach var="i"  begin="1" end="${pageCount}" step="1">
	   		<a href="getQuestions.html?pageNo=${i}&language=${language}" class="w3-button w3-bar-item">[${i}]</a>
	 	</c:forEach>
 	</div>
</div>
 <br>
 <br>
 <br>
 <br>
 
 	<a href="getResult.html?language=${language}">
 		<button class="w3-button w3-red w3-round-large w3-hover-blue">I Am Done With Test</button>
 	</a>
 <br>
 <br>
 <c:if test="${listResults ne null}">
	 <table class="w3-card w3-table-all w3-centered">
	 	<tr class="w3-teal">
	 		<th>Question ID </th>
	 		<th>Your Answer </th>
	 	</tr>
	 	
	 	<c:forEach var="result" items="${listResults}">
	 		<tr>
	 			<td>${result.questionId}</td>
	 			<td>${result.userAnswer}</td>
	 		</tr>
	 	</c:forEach>
	 </table>
</c:if>
 <br>
 <br>
</div>
</body>
</html>