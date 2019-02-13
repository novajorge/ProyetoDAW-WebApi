/**
 * 
 */
package interfaces;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exceptions.DAOException;

/**
 * @author Jorge
 *
 */
public interface metodosDB extends ErroresDB{

	
	 default void closeResultSet(ResultSet rs) throws DAOException {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			throw new DAOException(DB_ERR, e);
		}
	}

	 default void closePreparedStatement(PreparedStatement st) throws DAOException {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			throw new DAOException(DB_ERR, e);
		}
	}
	 default void closeCallableStatement(CallableStatement st) throws DAOException {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			throw new DAOException(DB_ERR, e);
		}
	}
}
