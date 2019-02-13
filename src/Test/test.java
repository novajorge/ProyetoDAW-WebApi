package Test;

import java.io.FileReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;

import bbdd.ConexionMariaDB;
import daos.NivelDAO;
import daos.UsuarioDAO;
import domains.Nivel;
import domains.Usuario;
import exceptions.DAOException;
import exceptions.DomainException;
import exceptions.ServiceException;
import interfaces.ErroresDB;

public class test {

	public static void main(String[] args) throws ServiceException {
		// TODO Auto-generated method stub
		//Probando la conexion a la base de datos de forma individual
		//Con la clase /WebApi/src/bbdd/ConexionMariaDB.java
		
		ConexionMariaDB conMariaDB;
		try {
			conMariaDB = new ConexionMariaDB("src/");
			Connection con =  conMariaDB.getObjConexion(); //probamos a traernos la conexion7
			System.out.println("Estamos conectados a:"+con.getCatalog());
			
			//probamos nivel
			Nivel niv = new Nivel();
			NivelDAO nivDAO = new NivelDAO(con);
			niv.setNivel("admin");
			niv = nivDAO.recuperarNivel(niv);
			try{
				System.out.println(niv.toString());
			}catch (DomainException e) {
				throw new ServiceException("ServiceExceipto;", e);
			}
			
			//fin prueba nivel
			
			//Prueba Usuario
			
			Usuario usu = new Usuario();
			UsuarioDAO usuDAO = new UsuarioDAO(con);
			usu.setNombre("jorge");
			System.out.println(usu.toString());
			usu = usuDAO.recuperarUsuario(usu);
			try{
				System.out.println(usu.toString());
			}catch (DomainException e) {
				throw new ServiceException("ServiceExceipto;", e);
			}
			
			con.close();
			// cerramos la conexion
		} catch (DAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		String passwordToHash = "1234";
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        System.out.println(generatedPassword);
	}

}
