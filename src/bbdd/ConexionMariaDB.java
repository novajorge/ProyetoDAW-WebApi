package bbdd;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import exceptions.DAOException;

/**
 * 
 * @author Jorge
 * @version 1.0
 */
public class ConexionMariaDB {
	// VARIABLES
	private Connection objConexion;
	private String jdbc_DRIVER, db_URL, db_Database, db_User, db_Pass;
	private static final String CONEXIONDB ="WEB-INF/conf/conexionjson.json";

	// CONTRUCTORES
	public ConexionMariaDB(String ruta) throws DAOException { 
		try { 
			parseJson(ruta+CONEXIONDB); 
			Class.forName(jdbc_DRIVER); 
				objConexion = DriverManager.getConnection("jdbc:mariadb://" + db_URL + "/" + db_Database, db_User,db_Pass);
		} catch (ClassNotFoundException e) {
			throw new DAOException("no se ha cargado los controladores jdbc", e);
		} catch (SQLException e) {
			throw new DAOException("no se ha establecido la conexion a la bbdd", e);
		}
	}


	// METODOS
	private boolean parseJson(String ruta) {
		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
		boolean ok = false;
		try (FileReader reader = new FileReader(ruta)) {
			// Read JSON filed
			Object obj = jsonParser.parse(reader);
			JSONObject objJSon = (JSONObject) obj;
			JSONObject database = (JSONObject) objJSon.get("database");

			jdbc_DRIVER = (String) database.get("jdbc_DRIVER");
			db_URL = (String) database.get("db_URL");
			db_Database = (String) database.get("db_DATABASE");
			db_User = (String) database.get("db_User");
			db_Pass = (String) database.get("db_Pass");

			ok = true;
			return ok;

		} catch (Exception e) {
			System.out.println("Error :" + e);
			return ok;
		}

	}

	// GETS
	public Connection getObjConexion() {
		return objConexion;
	}

	// SETS
	public void setObjConexion(Connection objConexion) {
		this.objConexion = objConexion;
	}

	public static void main(String[] args) {

	}
}
