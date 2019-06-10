package recursos;

public class DbQuery {
	
		// usuarios	
		private static final String RecuperarUsuario="Select nombre,contrasena,correo,fechaCreacion,empresa,nivel,activa from usuarios where nvl(nombre,'null') = ? or nvl(correo,'null')=?";
		private static final String RecuperarCodigoResetPassword="Select passwordReset from usuarios where nvl(nombre,'null') = ? or nvl(correo,'null')=?";
		private static final String InsertarUsuario="Insert into usuarios (nombre, contrasena, correo, fechaCreacion, empresa, nivel, activa) values (?,?,?,?,?,?,?)";
		private static final String UpdateStatusUsuario="Update usuarios set activa = ? where correo=?";
		//Falta el update completo
		private static final String DeleteUsuario="Delete from usuarios where correo=?";
		// nivel
		private static final String RecuperarNivel="Select nivel, solicitudes, tiempo from niveles where nivel = ?";
		private static final String RecupearNiveles="Select nivel, solicitudes, tiempo from niveles";
		//mirar que mas necesito aqui
		
		//databases
		private static final String RecuperarDatabase="Select correo, name, description, host, puerto, usuario, pass, activa, type from basededatos where correo = ? and name=? and host = ?";
		private static final String RecuperarDatabases="Select correo, name, description, host, puerto, usuario, pass, activa,type from basededatos";
		private static final String RecuperarDatabasesUser="Select correo, name, description, host, puerto, usuario, pass, activa, type from basededatos where correo = ?";
		private static final String InsertarDatabase="Insert into basededatos (correo,name, description,host,puerto,usuario,pass,activa,type) values (?,?,?,?,?,?,?,?,?)";
		private static final String DeleteDatabase="Delete from basededatos where correo=? and host=? and name=?";
		private static final String UpdateDatabase = "Update basededatos set name = ?, description = ?, host = ?, puerto = ?, usuario = ?, pass = ?, activa = ?, type = ? where correo=? and host=? and name=?";
		
		//typesDatabases
		private static final String RecuperarTypes="Select id, name, connector from basededatos where id = ?";
		private static final String RecuperarTodosTypes="Select id, name, connector from basededatos";
		
		//imagesProfile
		private static final String InsertarImagen = "Insert into basededatos(imagen_title, imagen, email)  values(?,?,?)";
		private static final String RecuperarImagen = "Select imagen_title, imagen, email from basededatos where email = ?";
		private static final String RecuperarImagenes = "Update basededatos set imagen_title = ?, imagen = ?, email = ?  from basededatos where email = ?";
		
		//getters and setters
		public static String getRecuperarusuario() {
			return RecuperarUsuario;
		}
	
		public static String getRecuperarnivel() {
			return RecuperarNivel;
		}

		public static String getRecuperarcodigoresetpassword() {
			return RecuperarCodigoResetPassword;
		}

		public static String getRecuperardatabase() {
			return RecuperarDatabase;
		}
		public static String getInsertarusuario() {
			return InsertarUsuario;
		}

		public static String getUpdatestatususuario() {
			return UpdateStatusUsuario;
		}

		public static String getDeleteusuario() {
			return DeleteUsuario;
		}

		public static String getRecuperardatabases() {
			return RecuperarDatabases;
		}

		public static String getInsertardatabase() {
			return InsertarDatabase;
		}

		public static String getDeletedatabase() {
			return DeleteDatabase;
		}

		public static String getUpdateDatabase() {
			return UpdateDatabase;
		}

		public static String getRecupearniveles() {
			return RecupearNiveles;
		}

		public static String getRecuperardatabasesuser() {
			return RecuperarDatabasesUser;
		}

		public static String getUpdatedatabase() {
			return UpdateDatabase;
		}

		public static String getRecuperartypes() {
			return RecuperarTypes;
		}

		public static String getRecuperartodostypes() {
			return RecuperarTodosTypes;
		}

		public static String getInsertarimagen() {
			return InsertarImagen;
		}

		public static String getRecuperarimagen() {
			return RecuperarImagen;
		}

		public static String getRecuperarimagenes() {
			return RecuperarImagenes;
		}

	
}
