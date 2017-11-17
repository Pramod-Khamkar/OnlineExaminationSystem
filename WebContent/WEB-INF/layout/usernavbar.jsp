<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script type="text/javascript" src="resources/js/tabs.js"></script>
<!-- <link rel="stylesheet" href="resources/css/sidebar.css"> -->
<title>User NavBar</title>
</head>
<body>
	<p>Index Page</p>

		<div class="w3-sidebar w3-bar-block w3-card-2 w3-animate-right w3-right"
			style="display: none; right: 0; padding-top: 25px;" id="rightMenu">
			<button onclick="closeRightMenu()"	class="w3-bar-item w3-button w3-large w3-hover-red">
				<tags:message code="label.close"></tags:message> &times;
			</button>
			<a href="#" title="Sign Out" class="w3-bar-item w3-button w3-hover-blue"><b>${userDetails.firstName} ${userDetails.lastName}</b></a>
			<a href="logOutUser.html"	title="Sign Out" class="w3-bar-item w3-button w3-hover-red">
				<i class="fa fa-sign-out w3-large"></i> 
				<tags:message code="label.signOut"></tags:message>
			</a>
		</div>
		
		<div class="w3-teal" style="padding-top: 25px">
			<button class="w3-button w3-teal w3-large w3-left w3-hover-teal" >
				<tags:message code="label.welcome"></tags:message> : <b>${userDetails.firstName} ${userDetails.lastName}</b>
			</button>
  			<button class="w3-button w3-teal w3-xlarge w3-right" onclick="openRightMenu()">&#9776;</button>
  		<div class="w3-container"></div>
  		
  		<%-- <div id="mySidenav" class="sidenav">
			<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">
				<tags:message code="label.close"></tags:message> &times;
			</a>
			<a href="#" title="User Name" class="w3-button w3-hover-blue" ><b>${userDetails.firstName} ${userDetails.lastName}</b></a>
			<a href="logOutUser.html"  title="Sign Out" class="signout w3-button w3-hover-blue" >
				<i class="fa fa-sign-out "></i> 
				<tags:message code="label.signOut"></tags:message>
			</a>
		</div>
		
		<div class="w3-teal" style="padding-top: 25px">
			<button class="w3-button w3-teal w3-large w3-left w3-hover-teal" >
				<tags:message code="label.welcome"></tags:message> : <b>${userDetails.firstName} ${userDetails.lastName}</b>
			</button>
  			<span style="font-size:30px;cursor:pointer; margin-right: 25px;" class="w3-right" onclick="openNav()">&#9776;</span>
  		<div class="w3-container"></div> --%>
  </div>
</body>
</html>