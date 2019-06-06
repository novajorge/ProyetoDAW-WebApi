<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
<div class="row">
	<form class="col s12" action="RecuperarContrasena" method="post">
		<div class="row">
			<div class="input-field col s8 center-align">
				<input placeholder="usuario o correo electronico" type="text"
					id="user" name="user" class="validate"> <label for="user" required>Usuario
					o Correo Electronico</label>
			</div>
		</div>
		<div class="row">
			<!-- reCAPTCHA -->
 			<div class="g-recaptcha" data-sitekey="6LcM05IUAAAAAOBs8b2TTA5dwg8Hvv0OlUboC8c2"></div>

		</div>
		<div class="row">
			<div class="toolbar-section">
				<div class="col s6 "><button class="waves-effect waves-light btn-small" type="submit" name="submit">Recupera la contraseña</button></div>
			</div>
		</div>
	</form>
</div>