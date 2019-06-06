package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domains.Nivel;
import domains.Usuario;
import exceptions.DAOException;
import interfaces.metodosDB;
import recursos.Costantes;
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
			st = con.prepareStatement(DbQuery.getRecuperarusuario());
			if(usuario.getNombre()== null) {
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
				System.out.println(usuario.getCorreo());
			}
			rs=st.executeQuery(); 
			if (rs.next()){
				nivel = new Nivel();
				nivel.setNivel(rs.getString("nivel"));
				nivel = new NivelDAO(con).recuperarNivel(nivel);
				usuario1= new Usuario(rs.getString("nombre"),rs.getString("contrasena"),rs.getString("correo"),rs.getString("empresa"),nivel,rs.getBoolean("activa"),rs.getDate("fechaCreacion"));
				System.out.println(usuario1);
			}		
		} catch (SQLException e) {
			throw new DAOException(Costantes.DB_ERR, e);
		} finally {
			closeResultSet(rs);
			closePreparedStatement(st);
		}
		return usuario1;
	}
	public Usuario recuperarCodigoResetPassword(Usuario usuario) throws DAOException {
		PreparedStatement st = null;
		ResultSet rs =null;
		Usuario usuario1=null;
		Nivel nivel=null;
		try {
			st = con.prepareStatement(DbQuery.getRecuperarcodigoresetpassword());
			if(usuario.getNombre()== null) {
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
				System.out.println(usuario.getCorreo());
			}
			rs=st.executeQuery(); 
			if (rs.next()){
				usuario1= new Usuario();
				System.out.println(usuario1);
			}		
		} catch (SQLException e) {
			throw new DAOException(Costantes.DB_ERR, e);
		} finally {
			closeResultSet(rs);
			closePreparedStatement(st);
		}
		return usuario1;
	}
}
