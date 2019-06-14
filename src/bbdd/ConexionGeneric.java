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

	// CONTRUCTORES
	public ConexionGeneric(Database database) throws DAOException { 
		try {
			System.out.println("Conectando Datbase");
			System.out.println(database.toString());
			if(database.getType().getName().equals("MySQL")) {
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				System.out.println("MySQL");
			}if(database.getType().getName().equals("MariaDB")) {
				Class.forName("org.mariadb.jdbc.Driver"); 
				System.out.println("MariaDB");
			}if(database.getType().getName().equals("Oracle")) {
				Class.forName("com.mysql.jdbc.Driver"); 
				System.out.println("Oracle");
			}
			System.out.println(database.getType().getConnector() + database.getHost()+":"+database.getPuerto() + "/" + database.getSchema());
			objConexion = DriverManager.getConnection(database.getType().getConnector() + database.getHost()+":"+database.getPuerto() + "/" + database.getSchema(), database.getUsuario(),database.getPassword());
			
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
