<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--  Imports de html y css en el head -->
<%@include file="resources/importsHead.html"%>
<!--  // Imports de html y css en el head // -->
<%@ page import="java.util.HashMap, java.util.Map" %>
<title>Apps Api Aplication</title>
</head>
<body>
	<%@ page import="translate.*"%>
	<%
		Traductor Idioma = new Traductor(request.getLocale().toString(), application.getRealPath("languajes"));
	%>
	<%
		session.setAttribute("menu", Idioma.getTranslate().get("menu"));
		session.setAttribute("footer", Idioma.getTranslate().get("footer"));
		
	%>
	<!--  Menu web -->
	<%@include file="html/menuPrim.jsp"%>
	<!-- // Menu web // -->

	<!--  Modal para el login y el registro -->
	<%@include file="html/loginModal.jsp"%>
	<!--  // Modal para el login y el registro // -->

	  <div class="carousel carousel-slider center " style="height: 680px;">
    <div class="carousel-fixed-item center">
      <a id="registrateButton" class="btn waves-effect white grey-text darken-text-2 modal-trigger"  href="#login">Registrate</a>
    </div>
    <div class="carousel-item amber white-text" href="#two!">
      <h2>Prueba a unirte y prueba nuestra herramienta</h2>
      <p class="white-text">Es gratis !!</p>
      
      <p class="white-text">Facil y sencilla</p>
    </div>
    <div class="carousel-item green white-text" href="#three!">
      <h2>Un proyecto Open Source</h2>
      <p class="white-text">Accesible en github</p>
    </div>
    <div class="carousel-item blue white-text" href="#four!">
      <h2>Proyecto desarrollado para el instituto I.E.S Luis Vives</h2>
      <p class="white-text">Proyecto en fase alpha</p>
    </div>
  </div><div style="height: 0px;"></div>
	

	<!--  Modal para el footer -->
	<%@ include file="html/footer.jsp" %>
	<!--  // Modal para el footer // -->
	<!--JavaScript at end of body for optimized loading-->
	<script type="text/javascript" src="resources/js/materialize.min.js"></script>
	<script type="text/javascript" src="resources/js/dinamismo.js"></script>
	
	 <% if(session.getAttribute("PasswordChange") != null){ %>
 <script type="text/javascript">M.toast({html: 'Password Change!'}) </script>
 	<% session.setAttribute("PasswordChange", null);%>
 <%} %>
 
 	<%if (session.getAttribute("ContraseñaIncorrecta") != null) {%>
	<script type="text/javascript">M.toast({html : 'Contraseña Incorrecta!',classes : 'red'})</script>
	<%session.setAttribute("ContraseñaIncorrecta", null);}%>
	
	 	<%if (session.getAttribute("errorGeneric") != null) {%>
	<script type="text/javascript">M.toast({html : 'Error Generico!',classes : 'red'})</script>
	<%session.setAttribute("errorGeneric", null);}%>
</body>
</html>