

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="row">
	<div class="row">
		<div class="col s12 center-aling">
			<h4  class="center-align">Añadir Base de Datos</h4>
		</div>
	</div>
	<form class="col s12" id="addDatabase" action="AddDatabase"
		method="post">
		<div class="modal-content">
			<div class="row">
				<div class="input-field col s3 center-align">
					<input placeholder="Nombre Base de Datos" type="text" id="name"
						name="name" class="validate"> <label for="name">Nombre
						Base de Datos</label>
				</div><div class="col s1 "></div>
				<div class="input-field col s3 center-align">
					<input placeholder="Pequeña Descripcion" type="text" id="desc"
						name="desc" class="validate"> <label for="desc">Descripcion</label>
				</div>
				<div class="col s5 center-align">
					<select name="selectTypes" id="selectTypes">
						<option value="" disabled selected>Seleccionar Tipo de base de datos</option>
						<option value="1">MySQL</option>
						<option value="2">MariaDB</option>
					</select> <label for="desc">Tipo Base de datos</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s4 center-align">
					<input placeholder="HOST / IP" type="text" id="host" name="host"
						class="validate"> <label for="name">Host/IP
						servidor Base de datos)</label>
				</div>
				<div class="col s2"></div>
				<div class="input-field col s3 center-align">
					<input placeholder="Puerto" type="number" id="port" name="port"
						class="validate"> <label for="desc">Puerto</label>
				</div>
				<div class="col s1"></div>
				<div class="input-field col s2 center-align">
					<label> <input type="checkbox" class="filled-in"
						value="true" id="active" name="active" checked="checked" /> <span>Activo</span>
					</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s4 center-align">
					<input placeholder="Usuario Base de Datos" type="text" id="user"
						name="user" class="validate"> <label for="name">Usuario
						de la base de datos</label>
				</div>
				<div class="col s3"></div>
				<div class="input-field col s4 center-align">
					<input placeholder="Contraseña Base de Datos" type="password"
						id="pass" name="pass" class="validate"> <label for="desc">Password
						de la Base de datos</label>
				</div>
			</div>
			<div class="row">
				<div class="col s3">
					<a class="waves-effect waves-light btn green">Test Database</a>
				</div>
			</div>
			<input value="<%=session.getAttribute("email")%>" name="email"
				id="email" class="hide">
		</div>

		<div class="modal-footer">
			<button class="waves-effect waves-light btn-small" id="testDatabase"
				name="">Añadir!</button>
		</div>
	</form>
	<script type="text/javascript">
		$(document).ready(function() {
			$('select').formSelect();
			$.ajax({
				url : 'RecuperarTypesDatabases',
				data : {},
				success : function(responseText) {
					console.log(responseText);
					/*
					var database = responseText;
					$('#cardDatabase .card-title').text(database.name);
					$('#cardDatabase p').text(database.description);
					
					//form placeholder and value for modify
					$('#UpdateDatabase input#name').val(database.name);
					$('#UpdateDatabase input#host').val(database.host);
					$('#UpdateDatabase input#desc').val(database.description);
					$('#UpdateDatabase input#port').val(database.puerto);
					$('#UpdateDatabase input#active').val(database.activa);
					$('#UpdateDatabase input#user').val(database.usuario);
					$('#UpdateDatabase input#pass').val(database.password);
					
					$('#UpdateDatabase input#oldName').val(database.name);
					$('#UpdateDatabase input#oldHost').val(database.host);
					$('#UpdateDatabase input#oldCorreo').val(database.correo);
					
					//form for delete
					$('#modal2 #delDatabase #name').val(database.name);
					$('#modal2 #delDatabase #host').val(database.host);
					
					$('#cardDatabase').show();
					 */

				}
			});
		});
	</script>
</div>
