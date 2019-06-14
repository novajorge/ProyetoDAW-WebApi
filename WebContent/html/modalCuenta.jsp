<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- Modal Structure -->
<div id="cuenta" class="modal modal-fixed-footer">
	<form class="col s12" action="CuentaServlets" method="post">
	<div class="modal-content"  id="userINfo">
		<div >
			<%@include file="forms/formCuenta.jsp"%>
		</div>
	</div>
	<div class="modal-footer">
		<div class="left "><button class="waves-effect waves-light btn-small" type="submit" name="submit">Actualizar!</button></div>
		<a href="#!" class="modal-close waves-effect waves-red btn-flat"><i class="material-icons left">close</i>Close</a>
	</div>
	</form>
</div>