package daos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Blob;

import exceptions.DAOException;
import interfaces.metodosDB;
import recursos.DbQuery;

public class imagenProfileDAO implements metodosDB {
	
	private Connection con;
	
	public imagenProfileDAO(Connection con) {
		this.con = con;
	}
	
	public void insertImage(File image, String name, String email) throws DAOException {
		
 
        FileInputStream inputStream = null;
		PreparedStatement st = null;
		ResultSet rs =null;
 
        try {
            inputStream = new FileInputStream(image);
            st = con.prepareStatement(DbQuery.getInsertarimagen());
            st.setString(1, name);
            st.setBinaryStream(2, (InputStream) inputStream, (int)(image.length()));
            st.setString(3, email);
            System.out.println(st.toString());
            st.executeUpdate();
 
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: - " + e);
        } catch (SQLException e) {
            System.out.println("SQLException: - " + e);
        } finally {
            closeResultSet(rs);
			closePreparedStatement(st);
        }
    }
	
	public byte[ ] recuperarImagen(String email) throws DAOException {
		try {
			
		} catch (Exception e) {
			System.out.println(e);
		}
    }
	public void updateImage(File image, String name, String email) throws DAOException {
		
		 
        FileInputStream inputStream = null;
		PreparedStatement st = null;
		ResultSet rs =null;
 
        try {
            inputStream = new FileInputStream(image);
            st = con.prepareStatement(DbQuery.getRecuperarimagen());
            st.setString(1, name);
            st.setBinaryStream(2, (InputStream) inputStream, (int)(image.length()));
            st.setString(3, email);
            st.executeUpdate();
 
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: - " + e);
        } catch (SQLException e) {
            System.out.println("SQLException: - " + e);
        } finally {
            closeResultSet(rs);
			closePreparedStatement(st);
        }
    }
}

