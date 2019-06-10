package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domains.Database;
import domains.Nivel;
import exceptions.DAOException;
import interfaces.metodosDB;
import recursos.Costantes;
import recursos.DbQuery;

public class DatabaseDAO implements metodosDB {
	private Connection con;
	
	public DatabaseDAO(Connection con) {
		this.con = con;
	}
	/**
	 * necesita un correo y un name para localizar los datos, only one return
	 * @param in_Database
	 * @return
	 * @throws DAOException
	 */
	public Database recuperarDatabase(Database in_Database) throws DAOException {
		PreparedStatement st = null;
		ResultSet rs = null;
		Database database=null;
		
		try {
			st = con.prepareStatement(DbQuery.getRecuperardatabase());
			st.setString(1,in_Database.getCorreo());
			st.setString(2, in_Database.getName());
			st.setString(3, in_Database.getHost());
			TypesDatabaseDAO databaseDAO = new TypesDatabaseDAO(con);
			rs=st.executeQuery();
			if (rs.next()){	
				database= new Database(rs.getString("usuario"), rs.getString("name"),rs.getString("description"), rs.getString("host"), rs.getString("pass"), rs.getString("correo") , rs.getInt("puerto"),databaseDAO.recuperarType(rs.getInt("type")), rs.getBoolean("activa"));
				System.out.println(database);
			}	
		} catch (SQLException e) {
			throw new DAOException(Costantes.DB_ERR, e);
			
		} finally {
			closeResultSet(rs);
			closePreparedStatement(st);
		}
		return database;
	}
	public List<Database> recuperarDatabasesUser(String correo) throws DAOException{
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Database> list_Databases=new ArrayList<Database>();
		try {
			st = con.prepareStatement(DbQuery.getRecuperardatabasesuser());
			st.setString(1,correo);
			TypesDatabaseDAO databaseDAO = new TypesDatabaseDAO(con);
			rs=st.executeQuery();
			while (rs.next()){	
				list_Databases.add(new Database(rs.getString("usuario"), rs.getString("name"),rs.getString("description"), rs.getString("host"), rs.getString("pass"), rs.getString("correo") , rs.getInt("puerto"),databaseDAO.recuperarType(rs.getInt("type")), rs.getBoolean("activa")));
			}	
		} catch (SQLException e) {
			System.out.println(e);
			throw new DAOException(Costantes.DB_ERR, e);
			
		} finally {
			closeResultSet(rs);
			closePreparedStatement(st);
		}
		return list_Databases;
	}
	public void insertarDatabase(Database in_Database) throws DAOException {
		PreparedStatement st = null;
		try {
			st = con.prepareStatement(DbQuery.getInsertardatabase());
			st.setString(1,in_Database.getCorreo());
			st.setString(2,in_Database.getName());
			st.setString(3,in_Database.getDescription());
			st.setString(4,in_Database.getHost());
			st.setInt(5,in_Database.getPuerto());
			st.setString(6,in_Database.getUsuario());
			st.setString(7,in_Database.getPassword());
			st.setBoolean(8,in_Database.isActiva());
			st.setInt(9,in_Database.getType().getId());
			System.out.println(st.toString());
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			throw new DAOException(Costantes.DB_ERR, e);
			
		} finally {
			closePreparedStatement(st);
		}
		
	}
	public void deleteDatabase(Database in_Database) throws DAOException {
		PreparedStatement st = null;
		try {
			st = con.prepareStatement(DbQuery.getDeletedatabase() );
			st.setString(1,in_Database.getCorreo());
			st.setString(2,in_Database.getHost());
			st.setString(3,in_Database.getName());
			System.out.println(st.toString());
			st.execute();
		}catch (SQLException  e) {
			System.out.println(e);
			throw new DAOException(Costantes.DB_ERR, e);
		} finally {
			closePreparedStatement(st);
		}
		
	}
	
	public void updateDatabase(Database in_Database, Database old_DatabaseData) throws DAOException {
		PreparedStatement st = null;
		try {
			st = con.prepareStatement(DbQuery.getUpdateDatabase());
			st.setString(1,in_Database.getName());
			st.setString(2,in_Database.getDescription());
			st.setString(3,in_Database.getHost());
			st.setInt(4,in_Database.getPuerto());
			st.setString(5,in_Database.getUsuario());
			st.setString(6,in_Database.getPassword());
			st.setBoolean(7,in_Database.isActiva());
			st.setInt(8,in_Database.getType().getId());
			
			st.setString(9,old_DatabaseData.getCorreo());
			st.setString(10,old_DatabaseData.getHost());
			st.setString(11,old_DatabaseData.getName());
			
			System.out.println(st.toString());
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			throw new DAOException(Costantes.DB_ERR, e);
			
		} finally {
			closePreparedStatement(st);
		}
		
	}
}

