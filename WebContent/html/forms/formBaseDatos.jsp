<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div class="row">
	<form class="col s12" id="UpdateDatabase" action="UpdateDatabase"
		method="post">
		<div class="modal-content">
		<div class="row">
			<div class="input-field col s3 center-align">
				<input placeholder="Nombre Base de Datos" type="text" id="name"
					name="name" class="validate white-text" required> <label for="name">Nombre
					Base de Datos</label>
			</div>
			<div class="col s1"></div>
			<div class="input-field col s3 center-align">
				<input placeholder="Pequeña Descripcion" type="text" id="desc"
					name="desc" class="validate white-text"> <label for="desc">Descripcion</label>
			</div>
			<div class="col s1"></div>
			<div class="col s4 center-align">
					<select class=" white-text" name="selectTypes" id="selectTypes">
						<option  value="" disabled>Seleccionar Tipo de base de datos</option>
						<option value="1" >MySQL</option>
						<option value="2" selected>MariaDB</option>
						<option value="3">Oracle</option>
					</select> <label for="desc">Tipo Base de datos</label>
				</div>
		</div>
		<div class="row">
			<div class="input-field col s3 center-align">
				<input placeholder="HOST / IP" type="text" id="host" name="host"
					class="validate white-text" required> <label for="name">Host/IP
					servidor Base de datos)</label>
			</div>
			<div class="col s1"></div>
			<div class="input-field col s3 center-align">
				<input placeholder="Puerto" type="number" id="port" name="port"
					class="validate white-text" required> <label for="desc">Puerto</label>
			</div>
			<div class="col s1"></div>
			<div class="input-field col s3 center-align">
				<input placeholder="Schema" type="text" id="schema" name="schema"
					class="validate white-text" required> <label for="schema">Schema</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s4 center-align">
				<input placeholder="Usuario Base de Datos" type="text" id="user"
					name="user" class="validate white-text" required> <label for="name">Usuario
					de la base de datos</label>
			</div>
			<div class="col s1"></div>
			<div class="input-field col s4 center-align">
				<input placeholder="Contraseña Base de Datos" type="password"
					id="pass" name="pass" class="validate white-text"> <label for="desc">Password
					de la Base de datos</label>
			</div>
			<div class="col s1"></div>
				<div class="input-field col s3 center-align">
					<label> <input type="checkbox" class="filled-in"
						value="true" id="active" name="active" checked="checked" /> <span>Activo</span>
					</label>
				</div>
			
			<input type="text" id="oldName" name="oldName" class="hide">
		<input type="text" id="oldHost" name="oldHost" class="hide">
		<input type="text" id="oldCorreo" name="oldCorreo" class="hide">
		
		</div>

	</div>