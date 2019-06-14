<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--  Imports de html y css en el head -->
<%@include file="resources/importsHead.html"%>
<!--  // Imports de html y css en el head // -->
<%@ page import="java.util.HashMap, java.util.Map" %>
<title>Recuperar Contraseña</title>
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

	<div class="row">
    <form class="col s12" action="changePassword" method="post">
          <div class="row">
        <div class="input-field col s5">
          <input id="email" name="email" type="email" class="validate" required>
          <label for="email">Email</label>
        </div>
      </div>
        <div class="input-field col s5">
          <input id="password" name="password" type="password" class="validate"required> 
          <label for="password">Password</label>
        </div>
            <div class="row">
        <div class="input-field col s5">
          <input id="codigo" name="codigo" type="text" class="validate" required>
          <label for="codigo">Codigo</label>
        </div>
      </div>
      <div class="col s6 "><button class="waves-effect waves-light btn-small" type="submit" name="submit">Recuperar Cuenta!</button></div>	
    </form>
  </div>

	<!--  Modal para el footer -->
	<%@ include file="html/footer.jsp" %>
	<!--  // Modal para el footer // -->
	<!--JavaScript at end of body for optimized loading-->
	<script type="text/javascript" src="resources/js/materialize.min.js"></script>
	<script type="text/javascript" src="resources/js/dinamismo.js"></script>
	
	<%if (session.getAttribute("EmailSend") != null) {%>
	<script type="text/javascript">M.toast({html : 'Email Send, look ur email!',classes : 'blue'})</script>
	<%session.setAttribute("EmailSend", null);}%>
</body>
</html>