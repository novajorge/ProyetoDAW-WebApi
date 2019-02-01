<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!--Import Google Icon Font-->
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<!--Import materialize.css-->
		<link type="text/css" rel="stylesheet" href="resources/css/materialize.css"  media="screen,projection"/>
	
	<!--Let browser know website is optimized for mobile-->
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<!--  Include JQuery -->
		<script src="resources/js/jquery-3.3.1.min.js"></script>
	
	<title>Apps Api Aplication</title>
</head>
<body>
	<!--  Menu web -->
	<% session = request.getSession(); %>
	<%@include  file="html/menuPrim.jsp" %>
  	<!-- // Menu web // -->
  	<!--  Modal para el login y el registro -->
  	<%@include  file="html/loginModal.jsp" %>
  	<!--  // Modal para el login y el registro // -->
  	
	 <!--JavaScript at end of body for optimized loading-->
	<script type="text/javascript" src="resources/js/materialize.min.js"></script>
	<script type="text/javascript" src="resources/js/dinamismo.js"></script>
</body>
</html>