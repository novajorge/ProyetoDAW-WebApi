package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domains.Database;
import domains.TypesDatabase;
import exceptions.DAOException;
import interfaces.metodosDB;
import recursos.Costantes;
import recursos.DbQuery;

public class TypesDatabaseDAO implements metodosDB {
	private Connection con;
	
	public TypesDatabaseDAO(Connection con) {
		this.con = con;
	}
	public TypesDatabase recuperarType(int id) throws DAOException {
		PreparedStatement st = null;
		ResultSet rs = null;
		TypesDatabase types=null;
		try {
			st = con.prepareStatement(DbQuery.getRecuperartypes());
			st.setInt(1,id);
			rs=st.executeQuery();
			if (rs.next()){	
				types= new TypesDatabase(rs.getInt("id"), rs.getString("name"),rs.getString("connector"));
			}	
		} catch (SQLException e) {
			throw new DAOException(Costantes.DB_ERR, e);
			
		} finally {
			closeResultSet(rs);
			closePreparedStatement(st);
		}
		return types;
	}
	public List<TypesDatabase> recuperarTodosTypes() throws DAOException{
		PreparedStatement st = null;
		ResultSet rs = null;
		List<TypesDatabase> listTypes=new ArrayList<TypesDatabase>();
		try {
			st = con.prepareStatement(DbQuery.getRecuperartodostypes());
			rs=st.executeQuery();
			while (rs.next()){	
				listTypes.add(new TypesDatabase(rs.getInt("id"), rs.getString("name"),rs.getString("connector")));
				}	
		} catch (SQLException e) {
			System.out.println(e);
			throw new DAOException(Costantes.DB_ERR, e);
			
		} finally {
			closeResultSet(rs);
			closePreparedStatement(st);
		}
		return listTypes;
	}
	
}
