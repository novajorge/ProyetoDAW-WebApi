<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--  Imports de html y css en el head -->
<%@include file="resources/importsHead.html"%>
<!--  // Imports de html y css en el head // -->

<title>Apps Api Aplication</title>
</head>
<body>
	<%@ page import="translate.*"%>
	<%
		Traductor Idioma = new Traductor(request.getLocale().toString(), application.getRealPath("languajes"));
	%>
	<%
		session.setAttribute("menu", Idioma.getTranslate().get("menu"));
	%>
	<!--  Menu web -->
	<%@include file="html/menuPrim.jsp"%>
	<!-- // Menu web // -->

	<!--  Modal para el login y el registro -->
	<%@include file="html/loginModal.jsp"%>
	<!--  // Modal para el login y el registro // -->

	  <div class="carousel carousel-slider center">
    <div class="carousel-fixed-item center">
      <a class="btn waves-effect white grey-text darken-text-2">Registrate</a>
    </div>
    <div class="carousel-item amber white-text" href="#two!">
      <h2>Second Panel</h2>
      <p class="white-text">This is your second panel</p>
    </div>
    <div class="carousel-item green white-text" href="#three!">
      <h2>Third Panel</h2>
      <p class="white-text">This is your third panel</p>
    </div>
    <div class="carousel-item blue white-text" href="#four!">
      <h2>Fourth Panel</h2>
      <p class="white-text">This is your fourth panel</p>
    </div>
  </div><div style="height: 0px;"></div>
	

	<!--  Modal para el footer -->
	<%@include file="html/footer.jsp"%>
	<!--  // Modal para el footer // -->
	<!--JavaScript at end of body for optimized loading-->
	<script type="text/javascript" src="resources/js/materialize.min.js"></script>
	<script type="text/javascript" src="resources/js/dinamismo.js"></script>
</body>
</html>