/**
 * 
 */
package domains;

import java.sql.Date;

/**
 * @author jorge.arroyo.rey
 *
 */
public class Database {
	private String usuario,host, password, correo, name, description, schema;
	private  int puerto;
	private TypesDatabase type;
	private boolean activa;


	//CONSTRUCTORES
	public Database() {}

/**
 * 
 * @param usuario
 * @param name
 * @param description
 * @param host
 * @param password
 * @param correo
 * @param puerto
 * @param activa
 * @param type
 * @param schema
 */
	public Database(String usuario, String name, String description ,String host, String password, String correo, int puerto, TypesDatabase type, boolean activa, String schema) {
		super();
		this.name = name;
		this.description = description;
		this.usuario = usuario;
		this.host = host;
		this.password = password;
		this.correo = correo;
		this.puerto = puerto;
		this.activa = activa;
		this.type = type;
		this.schema= schema;
	}

public String getUsuario() {
	return usuario;
}

public void setUsuario(String usuario) {
	this.usuario = usuario;
}

public String getHost() {
	return host;
}

public void setHost(String host) {
	this.host = host;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getCorreo() {
	return correo;
}

public void setCorreo(String correo) {
	this.correo = correo;
}

public int getPuerto() {
	return puerto;
}

public void setPuerto(int puerto) {
	this.puerto = puerto;
}

public boolean isActiva() {
	return activa;
}

public void setActiva(boolean activa) {
	this.activa = activa;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public TypesDatabase getType() {
	return type;
}

public void setType(TypesDatabase type) {
	this.type = type;
}



@Override
public String toString() {
	return "Database [usuario=" + usuario + ", host=" + host + ", password=" + password + ", correo=" + correo
			+ ", name=" + name + ", description=" + description + ", schema=" + schema + ", puerto=" + puerto
			+ ", type=" + type + ", activa=" + activa + "]";
}

public String getSchema() {
	return schema;
}

public void setSchema(String schema) {
	this.schema = schema;
}


	
	
}

