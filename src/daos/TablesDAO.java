package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domains.Database;
import domains.Describe;
import domains.Nivel;
import exceptions.DAOException;
import interfaces.metodosDB;
import recursos.Costantes;
import recursos.DbQuery;

public class TablesDAO  implements metodosDB{
	private Connection con;
	
	public TablesDAO(Connection con) {
		this.con = con;
	}
	public List<String> recuperarTableNames() throws DAOException {
		List<String> listaTableNames = new ArrayList<String>();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = con.prepareStatement(DbQuery.getVertablas());
			rs=st.executeQuery();
			System.out.println(st.toString());
			while (rs.next()){	
				listaTableNames.add(rs.getString(1));
			}	
		} catch (SQLException e) {
			throw new DAOException(Costantes.DB_ERR, e);
			
		} finally {
			closeResultSet(rs);
			closePreparedStatement(st);
		}
		return listaTableNames;
		
	}
	public List<Describe> recuperarDescribe(String table) throws DAOException {
		List<Describe> litDesc = new ArrayList<Describe>();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = con.prepareStatement("DESCRIBE "+ table);
			rs=st.executeQuery();
			
			while (rs.next()){	
				litDesc.add(new Describe(rs.getString("Field"),rs.getString("Type"), rs.getString("Null"), rs.getString("Key"), rs.getString("Default"), rs.getString("Extra")));
			}	
		} catch (SQLException e) {
			System.out.println(e);
			throw new DAOException(Costantes.DB_ERR, e);
			
		} finally {
			closeResultSet(rs);
			closePreparedStatement(st);
		}
		return litDesc;
		
	}
}
