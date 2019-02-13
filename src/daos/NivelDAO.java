package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domains.Nivel;
import domains.Usuario;
import exceptions.DAOException;
import interfaces.metodosDB;
import recursos.DbQuery;

/**
 * @author Jorge
 * 12/02/2019
 */
public class NivelDAO implements metodosDB{
	private Connection con;
	
	public NivelDAO(Connection con) {
		this.con = con;
	}
	
	public Nivel recuperarUsuario(Nivel nivel) throws DAOException {
		PreparedStatement st = null;
		ResultSet rs = null;
		Nivel nivel1=null;
		try {
			System.out.println(DbQuery.getRecuperarusuario());
			st = con.prepareStatement(DbQuery.getRecuperarusuario());
			st.setString(1,nivel.getNivel());
			rs=st.executeQuery();
			if (rs.next()){	
				rs.getString("nivel");
				nivel1= new Nivel(rs.getString("nivel"),rs.getDouble("solicitudes"),rs.getInt("tiempo"));
			}		
		} catch (SQLException e) {
			throw new DAOException(DB_ERR, e);
		} finally {
			closeResultSet(rs);
			closePreparedStatement(st);
		}
		return nivel1;
	}
	
}
