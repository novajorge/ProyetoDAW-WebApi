

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="row">
	<div class="row">
		<div class="col s12 center-aling">
			<h4  class="center-align">Añadir Base de Datos</h4>
		</div>
	</div>
	<form class="col s11" id="addDatabase" action="AddDatabase"
		method="post">
		<div class="modal-content">
			<div class="row">
				<div class="input-field col s3 center-align">
					<input placeholder="Nombre Base de Datos" type="text" id="name"
						name="name" class="validate" required> <label for="name">Nombre
						Base de Datos</label>
				</div><div class="col s1 "></div>
				<div class="input-field col s3 center-align">
					<input placeholder="Pequeña Descripcion" type="text" id="desc"
						name="desc" class="validate" > <label for="desc">Descripcion</label>
				</div>
				<div class="col s4 center-align">
					<select name="selectTypes2" id="selectTypes2">
						<option value="" disabled selected>Seleccionar Tipo de base de datos</option>
						<option value="1">MySQL</option>
						<option value="2" selected>MariaDB</option>
						<option value="3">Oracle</option>
					</select> <label for="desc">Tipo Base de datos</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s4 center-align">
					<input placeholder="HOST / IP" type="text" id="host" name="host"
						class="validate" required> <label for="name">Host/IP
						servidor Base de datos)</label>
				</div>
				<div class="col s1"></div>
				<div class="input-field col s2 center-align">
					<input placeholder="Puerto" type="number" id="port" name="port"
						class="validate" required> <label for="desc">Puerto</label>
				</div>
				<div class="col s1"></div>
			<div class="input-field col s4 center-align">
				<input placeholder="Schema" type="text" id="schema" name="schema"
					class="validate" required> <label for="schema">Schema</label>
			</div>
			</div>
			<div class="row">
				<div class="input-field col s4 center-align">
					<input placeholder="Usuario Base de Datos" type="text" id="user"
						name="user" class="validate" required> <label for="name">Usuario
						de la base de datos</label>
				</div>
				<div class="col s1"></div>
				<div class="input-field col s4 center-align">
					<input placeholder="Contraseña Base de Datos" type="password"
						id="pass" name="pass" class="validate" required> <label for="desc">Password
						de la Base de datos</label>
				</div>
				<div class="col s1"></div>
				<div class="input-field col s3 center-align">
					<label> <input type="checkbox" class="filled-in"
						value="true" id="active" name="active" checked="checked" /> <span>Activo</span>
					</label>
				</div>
			</div>
			<input value="<%=session.getAttribute("email")%>" name="email"
				id="email" class="hide">
		</div>

		<div class="modal-footer"> 
			<div class=" left ">
					<a class="waves-effect waves-light btn green" id="testDatabaseNew">Test Database</a>
			</div>
			<button class=" right waves-effect waves-light btn-small" id="testDatabase"
				name="">Añadir!</button>
		</div>
	</form>
</div>
