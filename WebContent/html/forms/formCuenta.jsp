<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


	<div class="row">
		<div class="input-field col s4 center-align">
			<input type="text" id="name" name="name"
				class="validate" required> <label for="name">Nombre
				de usuario</label>
		</div>
		<div class="col s3"></div>
		<div class="input-field col s4 center-align">
			<input placeholder="Contraseña Antigua" type="password" id="pass" name="pass"
				class="validate" > <label for="pass">Contraseña Antigua</label>
		</div>
		<div class="input-field col s4 center-align">
			<input  type="password" id="newpass1" name="newpass1"
				class="validate" > <label for="newpass1">Contraseña</label>
		</div>
		<div class="col s3"></div>
		<div class="input-field col s4 center-align">
			<input  type="password" id="newpass2" name="newpass2"
				class="validate" > <label for="newpass2">Repite Contraseña</label>
		</div>
	</div>
	<div class="row">
		<div class="input-field col s4 center-align">
			<input type="text" id="email" name="email" class="validate" disabled> <label for="email" >Correo
				Electronico</label>
		</div>
		<div class="col s3"></div>
		<div class="input-field col s4 center-align">
			<input  type="text" id="empresa" name="empresa"
				class="validate"> <label for="desc">Empresa</label>
		</div>
	</div>
	<div class="row">
		<div class="input-field col s4 center-align">
			<input type="File" id="file" name="file"
				class="waves-effect waves-light btn validate">
		</div>
		<div class="col s3"></div>
		<div class="input-field col s2 center-align">
			<label> <input type="checkbox" class="filled-in" value="true"
				id="active" name="active" checked="checked" disabled /> <span>Activa</span>
			</label>
		</div>
	</div>
	<input type="text" value="update" name="methodDAO"class="hide">
