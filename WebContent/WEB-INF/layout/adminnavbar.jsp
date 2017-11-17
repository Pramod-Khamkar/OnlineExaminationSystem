<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script type="text/javascript" src="resources/js/tabs.js"></script>
<title>Admin NavBar</title>
</head>
<body>
	<p>Index Page</p>

		<div class="w3-sidebar w3-bar-block w3-card-2 w3-animate-left w3-left"
			style="display: none; padding-top: 25px;" id="leftMenu">
			<button onclick="closeLeftMenu()" class="w3-bar-item w3-button w3-large">
				<tags:message code="label.close"></tags:message> &times;
			</button>
			<a href="addQuestion.html" class="w3-bar-item w3-button">
				<tags:message code="label.addQuestions"></tags:message>
			</a>
			<a href="chooseLanguageAdmin.html" class="w3-bar-item w3-button">
				<tags:message code="label.showQuestions"></tags:message>
			</a>
			<hr>
			<a href="showUserList.html" class="w3-bar-item w3-button">
				<tags:message code="label.showRegisteredUser"></tags:message>
			</a>
			<a href="showMarksList.html" class="w3-bar-item w3-button">
				<tags:message code="label.showUserMarks"></tags:message>
			</a>
		</div>

		<div class="w3-sidebar w3-bar-block w3-card-2 w3-animate-right w3-right"
			style="display: none; right: 0; padding-top: 25px;" id="rightMenu">
			<button onclick="closeRightMenu()"	class="w3-bar-item w3-button w3-large w3-hover-red">
				<tags:message code="label.close"></tags:message> &times;
			</button>
			<a href="#" title="User Details" class="w3-bar-item w3-button w3-hover-blue">
				<b>${adminDetails.firstName} ${adminDetails.lastName}</b>
			</a>
			<a href="logOutAdmin.html"	title="Sign Out" class="w3-bar-item w3-button w3-hover-red">
				<i class="fa fa-sign-out w3-large"></i> 
				<tags:message code="label.signOut"></tags:message>
			</a>
		</div>
		
		<div class="w3-teal" style="padding-top: 25px">
 			<span class="w3-button w3-teal w3-xlarge w3-left" style="font-size:30px;cursor:pointer" onclick="openLeftMenu()">&#9776;</span>
 			<span class="w3-button w3-teal w3-xlarge w3-hover-teal">
 				<h6>
 					<tags:message code="label.welcome"></tags:message> : <b>${adminDetails.firstName} ${adminDetails.lastName}</b>
 				</h6>
 			</span>
  			<span class="w3-button w3-teal w3-xlarge w3-right" onclick="openRightMenu()">&#9776;</span>
  		</div>
</body>
</html>