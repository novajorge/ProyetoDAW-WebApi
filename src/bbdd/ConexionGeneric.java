/**
 * 
 */
package bbdd;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import domains.Database;
import exceptions.DAOException;

/**
 * @author jorge.arroyo.rey
 *
 */
public class ConexionGeneric {
	// VARIABLES
	private Connection objConexion;
	private String jdbc_DRIVER, db_URL, db_Database, db_User, db_Pass;

	// CONTRUCTORES
	public ConexionGeneric(Database database) throws DAOException { 
		try {
			Class.forName(jdbc_DRIVER); 
				objConexion = DriverManager.getConnection("jdbc:mariadb://" + db_URL + "/" + db_Database, db_User,db_Pass);
		} catch (ClassNotFoundException e) {
			throw new DAOException("no se ha cargado los controladores jdbc", e);
		} catch (SQLException e) {
			throw new DAOException("no se ha establecido la conexion a la bbdd", e);
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
}
