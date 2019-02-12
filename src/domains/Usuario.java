/**
 * 
 */
package domains;

import java.sql.Date;

import org.json.simple.JSONObject;


/**
 * @author Jorge
 * 
 */
public class Usuario {

	private String nombre, contrase�a, correo,empresa;
	private Nivel nivel;
	private boolean activa;
	private Date fechaCreacion;


	//CONSTRUCTORES
	public Usuario() {};

	/**
	 * 
	 * @param nombre
	 * @param contrase�a
	 * @param correo
	 * @param empresa
	 * @param nivel
	 * @param activa
	 * @param fechaCreacion 
	 */
	public Usuario(String nombre, String contrase�a, String correo, String empresa, Nivel nivel, boolean activa, Date fechaCreacion) {
		super();
		this.nombre = nombre;
		this.contrase�a = contrase�a;
		this.correo = correo;
		this.fechaCreacion= fechaCreacion;
		this.empresa = empresa;
		this.nivel = nivel;
		this.activa = activa;
	}
	//METODOS
	
	//METODOS IMPLEMENTADOS

	
	//GETTERS AND SETTERS

	public String getNombre() {
		return nombre;
	}


	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getEmpresa() {
		return empresa;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contrase�a=" + contrase�a + ", correo=" + correo + ", empresa="
				+ empresa + ", nivel=" + nivel + ", activa=" + activa + ", fechaCreacion=" + fechaCreacion + "]";
	}
}
