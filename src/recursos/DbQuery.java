package recursos;

public class DbQuery {
	
		// usuarios	
		private static final String RecuperarUsuario="Select nombre,contraseña,correo,fechaCreacion,empresa,nivel,activa from usuarios where nvl(nombre,'null') = ? or nvl(correo,'null')=?";
	
		// nivel
		private static final String RecuperarNivel="Select nivel, solicitudes, tiempo from niveles where nivel = ?";
		


		//getters and setters
		public static String getRecuperarusuario() {
			return RecuperarUsuario;
		}
	
		public static String getRecuperarnivel() {
			return RecuperarNivel;
		}
		

	
}
