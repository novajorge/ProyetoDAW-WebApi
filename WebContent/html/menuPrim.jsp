<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.HashMap, java.util.Map" %>
<% Map<String, String> menuJson =  (Map<String, String>) session.getAttribute("menu"); %>
<div class="navbar-fixed">
	<nav class="grey darken-3">
		<div class=" nav-wrapper">
			<a href="#" class="brand-logo"><img src="resources/images/logo.png" width="64px";></a> <a href="#"
				data-target="mobile-demo" class="sidenav-trigger"><i
				class="material-icons"></i></a>
			<ul class="right hide-on-med-and-down">
				<li class=""><a href="https://github.com/novajorge/ProyetoDAW-WebApi"><%= menuJson.get("menu1") %></a></li>
				<li class=""><a href="#"><%= menuJson.get("menu2") %></a></li>
				<% if(session.getAttribute("usuario") == null){ %>
					<li class=""><a class="modal-trigger" href="#login"><%= menuJson.get("menu3") %></a></li>
				<% }else{ %>
					<li class=""><a href="<%= request.getContextPath() %>/admin"><%= session.getAttribute("usuario") %></a></li>
					<li class=""><a href="LogoutSesion"><%= menuJson.get("menu4") %></a></li>	
				<% } %>
			</ul>
		</div>
	</nav>
</div>
<!--  Menu para el movil -->
	<ul class="sidenav" id="mobile-demo">
		<li class=""><a href="#"><%= menuJson.get("menu1") %></a></li>
		<li class=""><a href="#"><%= menuJson.get("menu2") %></a></li>
		<% if(session.getAttribute("usuario") == null){ %>
			<li class=""><a class="modal-trigger" href="#login"><%= menuJson.get("menu3") %></a></li>
		<% }else{ %>
			<li class=""><a href="LogoutSesion"><%= menuJson.get("menu4") %></a></li>
		<% } %>
	</ul>