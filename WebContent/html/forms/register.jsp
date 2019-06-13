<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="row">
	<form action="CuentaServlets" method="post">
	<div class="input-field col s4 center-align">
		<input placeholder="" type="text" id="name"
			name="name" class="validate" required> 
			<label for="name">Nombre de usuario</label>
	</div>
	<div class="col s3"></div>
	<div class="input-field col s4 center-align">
		<input placeholder="" type="password"
			id="pass" name="pass" class="validate" required> 
			<label for="desc">Contraseña</label>
	</div>
</div>
<div class="row">
	<div class="input-field col s4 center-align">
		<input placeholder="" type="text" id="email"
			name="email" class="validate" required> 
			<label for="name">Correo Electronico</label>
	</div>
	<div class="col s3"></div>
	<div class="input-field col s4 center-align">
		<input placeholder="" type="text"
			id="empresa" name="empresa" class="validate"> 
			<label for="desc">Empresa</label>
	</div>
	<input placeholder="" type="text"
			id="methodDAO" name="methodDAO" class="validate hide" value="insert"> 
			
	<div class="col s6 "><button class="waves-effect waves-light btn-small" type="submit" name="submit">Registrarme!</button></div>	
	
	</form>
</div>
