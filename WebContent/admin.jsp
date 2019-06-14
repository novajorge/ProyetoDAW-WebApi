<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<%
	if (session.getAttribute("usuario") != null) {
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<!--  Imports de html y css en el head -->
<%@include file="resources/importsHead.html"%>
<!--  // Imports de html y css en el head // -->
<body style="background-image: url('resources/images/prism.png');">
	<%@ page import="translate.*"%>
	<%
		Traductor Idioma = new Traductor(request.getLocale().toString(), application.getRealPath("languajes"));
	%>
	<%
		session.setAttribute("menuAdmin", Idioma.getTranslate().get("menuAdmin"));
	%>

	<div class="row">
		<div class="col s3">
			<!--  Menu web -->
			<%@include file="html/menuAdmin.jsp"%>
			<!-- // Menu web // -->
		</div>
		<div class="col s9">
			<!--  card api -->
			<%@include file="html/cardApi.jsp"%>
			<!-- //card api // -->

			<a class="hide" id="userHide"><%=(String) session.getAttribute("usuario")%></a>
			<a class="hide" id="emailHide"><%=(String) session.getAttribute("email")%></a>
			<!-- Modal Structure -->
			<div id="modal1" class="modal modal modal-fixed-footer">
				<%@include file="html/forms/addDatabase.jsp"%>
			</div>

			<!-- Modal Structure -->
			<div id="modal2" class="modal bottom-sheet">
				<form id="delDatabase" action="DelDatabase" method="post">
					<div class="modal-content">
						<h5>¿Seguro que quieres eliminar esta Base de Datos?</h5>

						<input type="text" id="name" name="name" class="hide"> <input
							type="text" id="host" name="host" class="hide">
					</div>
					<div class="modal-footer">
						<button
							class="modal-close waves-effect waves-light btn-small red left"
							type="submit" name="">Eliminar!</button>
					</div>
				</form>

			</div>

			<!--  modal cuenta -->
			<%@include file="html/modalCuenta.jsp"%>


			<div class="row" id="cardDatabase">
				<div class="col s12">
					<div class="card blue-grey darken-1">
						<div class="card-content white-text">
							<span class="card-title"></span>
							<p></p>

							<div class="divider"></div>

							<%@include file="html/forms/formBaseDatos.jsp"%>

						</div>
						<div class="card-action">
							<button class="waves-effect waves-light btn-small right"
								type="submit" name="submit">Actualizar!</button>
							<a class="waves-effect waves-light btn green rigth" id="pingDatabaseForm">Test Database</a>
							</form>

							<!-- Modal Trigger -->
							<a class="waves-effect waves-light btn modal-trigger red"
								href="#modal2">Eliminar</a>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>



	</div>




	<%
		if (session.getAttribute("DatabaseAdded") != null) {
	%>
	<script type="text/javascript">
		M.toast({
			html : 'Database Added!'
		})
	</script>
	<%
		session.setAttribute("DatabaseAdded", null);
	%>
	<%
		}
	%>
	<%
		if (session.getAttribute("DatabaseDelete") != null) {
	%>
	<script type="text/javascript">
		M.toast({
			html : 'Database Delete!',
			classes : 'red'
		})
	</script>
	<%
		session.setAttribute("DatabaseDelete", null);
	%>
	<%
		}
	%>
	<%
		if (session.getAttribute("DatabaseUpdate") != null) {
	%>
	<script type="text/javascript">
		M.toast({
			html : 'Database Update!',
			classes : 'blue'
		})
	</script>
	<%
		session.setAttribute("DatabaseUpdate", null);
			}
	%>

	<%
		if (session.getAttribute("CuentaUpdate") != null) {
	%>
	<script type="text/javascript">
		M.toast({
			html : 'Cuenta Update!',
			classes : 'blue'
		})
	</script>
	<%
		session.setAttribute("CuentaUpdate", null);
			}
	%>

	<%
		if (session.getAttribute("PasswordBothIncorrects") != null) {
	%>
	<script type="text/javascript">
		M.toast({
			html : 'Passwords dont match!',
			classes : 'red'
		})
	</script>
	<%
		session.setAttribute("PasswordBothIncorrects", null);
			}
	%>

	<%
		if (session.getAttribute("PasswordIncorrect") != null) {
	%>
	<script type="text/javascript">
		M.toast({
			html : 'Old Password incorrect!',
			classes : 'red'
		})
	</script>
	<%
		session.setAttribute("PasswordIncorrect", null);
			}
	%>
</body>
</html>
<%
	} else {
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}
%>