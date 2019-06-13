package Test;

import java.io.File;

import bbdd.ConexionMariaDB;
import daos.imagenProfileDAO;
import exceptions.DAOException;
import exceptions.ServiceException;
import translate.Traductor;

public class test {

	public static void main(String[] args) throws ServiceException, DAOException {
		
		try {
			Traductor Idioma = new Traductor();
			System.out.println(Idioma.getTranslate().get("slider"));
		} catch (Exception e) {
			System.out.println( e);
		}

		
	}


}
