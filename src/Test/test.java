package Test;

import java.io.File;

import bbdd.ConexionMariaDB;
import daos.imagenProfileDAO;
import exceptions.DAOException;
import exceptions.ServiceException;

public class test {

	public static void main(String[] args) throws ServiceException, DAOException {
		
		try {
			ConexionMariaDB conexion = new ConexionMariaDB("src/");
			imagenProfileDAO da= new imagenProfileDAO(conexion.getObjConexion());
			File f = new File("C:\\Users\\jorge.arroyo.rey\\Downloads\\account-icon-25500.png");
			da.insertImage(f, "cuenta", "jorgear96@gmail.com");
		} catch (Exception e) {
			System.out.println( e);
		}

		
	}


}
