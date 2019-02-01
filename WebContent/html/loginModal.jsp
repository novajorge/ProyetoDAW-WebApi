<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- Modal Structure -->
<div id="login" class="modal">
	<div class="modal-content">
		<nav>
			<div class="nav-wrapper">
				<ul id="nav-mobile" class="hide-on-med-and-down">
					<li class="active"><a>Ya soy Usuario!</a></li>
					<li class=""><a>Soy nuevo, Dejame Registrarme!</a></li>
				</ul>
			</div>
		</nav>
		<div id="loginIn">
			<%@include file="forms/login.jsp"%>
		</div>
		<div id="registerIn">
			<%@include file="forms/register.jsp"%>
		</div>
	</div>
	<div class="modal-footer">
		<a class="modal-close waves-effect waves-light red btn-small"><i class="material-icons left">close</i>Close</a>
	</div>
</div>