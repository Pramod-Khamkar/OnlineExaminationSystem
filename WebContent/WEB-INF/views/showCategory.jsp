<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Category</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="text/javascript" src="resources/js/tabs.js"></script>
<link rel="stylesheet" href="resources/css/sidebar.css">
</head>
<body>
<div id="main">
	<div class="w3-container">
  		<div class="w3-panel w3-pale-green w3-bottombar w3-border-green w3-border">
  		<h2>Instructions </h2>
    	<li>Choose language first</li>
    	<li>Choose appropriate answers</li>
    	<li>After selecting answer click on <b>Save</b> Button to save your answer</li>
    	<li>For next question use question selector shown at bottom</li>
    	<li>After successfull completion of test click on <b>I Am Done With Test</b> button</li>  
    	<li>For logout use <b>&#9776;</b> icon on top right corner</li>  	
  		</div>
	</div>
	<br><br><br>																			
	<form action="getQuestions.html" method="get" style="text-align: center;">
			<label><b>Choose Language : </b></label>
				<select name="language" class="w3-indigo w3-large">
					<option value="C">C</option>
					<option value="CPP">C++</option>
					<option value="Java">JAVA</option>
				</select>
				<input type="hidden" name="pageNo" value="1"> &nbsp;&nbsp;
			<input type="submit" value="Start Quiz!" >
	</form>
</div>
</body>
</html>