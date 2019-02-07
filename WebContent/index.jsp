<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	 <!--  Imports de html y css en el head -->
  	<%@include  file="resources/importsHead.html" %>
  	<!--  // Imports de html y css en el head // -->
	
	<title>Apps Api Aplication</title>
</head>
<body>
<%@ page import="translate.Traductor" %>

<% Traductor Idioma = new Traductor(request.getLocale().toString(),application.getRealPath("languajes")); %>
	<!--  Menu web -->
	<%@include  file="html/menuPrim.jsp" %>
  	<!-- // Menu web // -->
  	<!--  Modal para el login y el registro -->
  	<%@include  file="html/loginModal.jsp" %>
  	<!--  // Modal para el login y el registro // -->
  	
  	<div style="height: 320px;"></div>
  	
  	<!--  Modal para el footer -->
  	<%@include  file="html/footer.jsp" %>
  	<!--  // Modal para el footer // -->
	 <!--JavaScript at end of body for optimized loading-->
	<script type="text/javascript" src="resources/js/materialize.min.js"></script>
	<script type="text/javascript" src="resources/js/dinamismo.js"></script>
</body>
</html>