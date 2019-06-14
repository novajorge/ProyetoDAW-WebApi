package Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import bbdd.ConexionGeneric;
import bbdd.ConexionMariaDB;
import daos.DatabaseDAO;
import domains.Database;
import exceptions.DAOException;
import exceptions.ServiceException;
import translate.Traductor;

public class test {

	public static void main(String[] args) throws ServiceException, DAOException {
		
		try {

			ConexionMariaDB conPrin = new ConexionMariaDB("src/");
			DatabaseDAO dao = new DatabaseDAO(conPrin.getObjConexion());
			List<Database> da = new ArrayList<Database>();
			
			da = dao.recuperarDatabasesUser("jorgear96@gmail.com");
			
			ConexionGeneric con = new ConexionGeneric(da.get(0));
			
			System.out.println(con.getObjConexion().getCatalog());
		} catch (Exception e) {
			System.out.println(e);
		}

		
	}


}
