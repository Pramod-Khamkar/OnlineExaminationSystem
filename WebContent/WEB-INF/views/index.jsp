<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login Form</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="<c:url value='resources/js/tabs.js'/>"></script>

<style>
	.mySlides {display:none;}
</style>
</head>
<body onload="startTime()">
	<h2 class="w3-center w3-text-red"><b>Welcome</b></h2>
	<h3 class="w3-center w3-text-pink">Happy Learning</h3>
	<br>
	<div class="w3-content w3-section" style="max-width:700px; ">
 		<img class="mySlides" src="resources/img/1.jpg" style="width:100%">
  		<img class="mySlides" src="resources/img/2.jpg" style="width:100%">
  		<!-- <img class="mySlides" src="resources/img/3.jpg" style="width:100%"> -->
  		<img class="mySlides" src="resources/img/4.jpg" style="width:100%">
	</div>
	
<script>
var myIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 2000); // Change image every 2 seconds
}
</script>
	
	
</body>
</html>