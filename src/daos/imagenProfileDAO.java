package daos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exceptions.DAOException;
import interfaces.metodosDB;
import recursos.DbQuery;

public class imagenProfileDAO implements metodosDB {
	
	private Connection con;
	
	public imagenProfileDAO(Connection con) {
		this.con = con;
	}
	
	public void insertImage() throws DAOException {
		
 
        FileInputStream inputStream = null;
		PreparedStatement st = null;
		ResultSet rs =null;
 
        try {
            File image = new File("C:/honda.jpg");
            inputStream = new FileInputStream(image);
            st = con.prepareStatement(DbQuery.getRecuperarimagen());
            st.setString(1, "Honda Car");
            st.setBinaryStream(2, (InputStream) inputStream, (int)(image.length()));
 
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
	
	public void updateImage() throws DAOException {
		
		 
        FileInputStream inputStream = null;
		PreparedStatement st = null;
		ResultSet rs =null;
 
        try {
            File image = new File("C:/honda.jpg");
            inputStream = new FileInputStream(image);
            st = con.prepareStatement(DbQuery.getRecuperarimagen());
            st.setString(1, "Honda Car");
            st.setBinaryStream(2, (InputStream) inputStream, (int)(image.length()));
 
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

