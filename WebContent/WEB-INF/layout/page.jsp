<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Online Examination System</title>
</head>
<body>
	<div id="header">
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</div>
	
	<div id="navbar">
		<tiles:insertAttribute name="navbar"></tiles:insertAttribute>
	</div>
	
	<div id="content">
		<tiles:insertAttribute name="body"></tiles:insertAttribute>
	</div>
	
	<div id="footer">
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>
</body>
</html>