<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="row">
	<form class="col s12" action="LoginSesion" method="post">
		<div class="row">
			<div class="input-field col s8 center-align">
				<input placeholder="usuario o correo electronico" type="text"
					id="user" name="user" class="validate" required> <label for="user">Usuario
					o Correo Electronico</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s8 center-align">
				<input placeholder="password" id="password" type="password"
					 name="passwd" class="validate" required>
				<label for="password">Contraseņa</label>
			</div>
		</div>
		<div class="row">
			<div class="toolbar-section">
				<div class="col s6 "><button class="waves-effect waves-light btn-small" type="submit" name="submit">Entrar!</button></div>
				<div class="col s6 ">
					<a id="showRecuperarContrasena" class="right-align" >Recuperar contraseņa</a>
				</div>
			</div>
		</div>
	</form>
</div>
