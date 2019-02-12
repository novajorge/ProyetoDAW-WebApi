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

public class UsuarioDAO implements metodosDB {

	private Connection con;
	
	public UsuarioDAO(Connection con) {
		this.con = con;
	}
	/*public Usuario insertarUsuario(Usuario usuario) {
		return usuario;	
	}*/
	public Usuario recuperarUsuario(Usuario usuario) throws DAOException {
		PreparedStatement st = null;
		ResultSet rs =null;
		Usuario usuario1=null;
		Nivel nivel=null;
		try {
			System.out.println(con.getCatalog());
			st = con.prepareStatement(DbQuery.getRecuperarusuario());
			if(usuario.getCorreo()== null) {
				String a = "null";
				st.setString(1,a);
			}else {
				st.setString(1,usuario.getNombre());
			}
			if(usuario.getCorreo()== null) {
				String a = "null";
				st.setString(2,a);
			}else {
				st.setString(2,usuario.getCorreo());
			}
			rs=st.executeQuery(); 
			if (rs.next()){
				nivel = new Nivel();
				nivel.setNivel(rs.getString("nivel"));
				nivel = new NivelDAO(con).recuperarUsuario(nivel);
				usuario1= new Usuario(rs.getString("nombre"),rs.getString("contraseña"),rs.getString("correo"),rs.getString("empresa"),nivel,rs.getBoolean("activa"),rs.getDate("fechaCreacion"));
			}		
		} catch (SQLException e) {
			throw new DAOException(DB_ERR, e);
		} finally {
			closeResultSet(rs);
			closePreparedStatement(st);
		}
		return usuario1;
	}
}
