package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import domains.Database;
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
		try {
			st = con.prepareStatement(DbQuery.getRecuperarcodigoresetpassword());
			st.setString(1, usuario.getCorreo());
			System.out.println(st.toString());
			rs=st.executeQuery(); 
			if (rs.next()){
				usuario1 = new Usuario();
				usuario1.setResetPass(rs.getString("passwordReset")); 
			}
		} catch (SQLException e) {
			throw new DAOException(Costantes.DB_ERR, e);
		} finally {
			closeResultSet(rs);
			closePreparedStatement(st);
		}
		return usuario1;
	}
	public void insertarusuario(Usuario in_user) throws DAOException {
		PreparedStatement st = null;
		try {
			
			st = con.prepareStatement(DbQuery.getInsertarusuario());
			st.setString(1, in_user.getNombre());
			st.setString(2, in_user.getContrasena());
			st.setString(3, in_user.getCorreo());
			st.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
			st.setString(5, in_user.getEmpresa());
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			throw new DAOException(Costantes.DB_ERR, e);
			
		} finally {
			closePreparedStatement(st);
		}
		
	}
	public void updatePassword(Usuario in_user) throws DAOException {
		PreparedStatement st = null;
		try {
			
			st = con.prepareStatement(DbQuery.getUpdatepasswordusuario());
			st.setString(1, in_user.getContrasena());
			st.setString(3, in_user.getCorreo());
			st.setString(2, null);
			System.out.println(st.toString());
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			throw new DAOException(Costantes.DB_ERR, e);
			
		} finally {
			closePreparedStatement(st);
		}
		
	}
	public void setResetPassword(Usuario in_user) throws DAOException {
		PreparedStatement st = null;
		try {
			
			st = con.prepareStatement(DbQuery.getInsertcodigoresetpassword());
			st.setString(1, in_user.getResetPass());
			st.setString(2, in_user.getCorreo());
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			throw new DAOException(Costantes.DB_ERR, e);
			
		} finally {
			closePreparedStatement(st);
		}
		
	}
}
