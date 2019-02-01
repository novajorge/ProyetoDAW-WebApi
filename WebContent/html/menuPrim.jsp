<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="navbar-fixed">
	<nav class="grey darken-3">
		<div class=" nav-wrapper">
			<a href="#" class="brand-logo">Logo</a> <a href="#"
				data-target="mobile-demo" class="sidenav-trigger"><i
				class="material-icons">menu</i></a>
			<ul class="right hide-on-med-and-down">
				<li class=""><a href="#">BLOG</a></li>
				<li class=""><a href="#">API DOCUMENTATION</a></li>
				<li class=""><a href="#">PLANS</a></li>
				<li class=""><a href="#">CONTACT</a></li>
				<% if(session != null){ %>
					<li class=""><a class="modal-trigger" href="#login">LOGIN</a></li>
				<% }else{ %>
					<li class=""><a href="#">LOGOUT</a></li>
				<% } %>
			</ul>
		</div>
	</nav>
</div>
<!--  Menu para el movil -->
	<ul class="sidenav" id="mobile-demo">
		<li class=""><a href="#">BLOG</a></li>
		<li class=""><a href="#">API DOCUMENTATION</a></li>
		<li class=""><a href="#">PLANS</a></li>
		<li class=""><a href="#">CONTACT</a></li>
		<% if(session == null){ %>
			<li class=""><a class="modal-trigger" href="#login">LOGIN</a></li>
		<% }else{ %>
			<li class=""><a href="#">LOGOUT</a></li>
		<% } %>
	</ul>