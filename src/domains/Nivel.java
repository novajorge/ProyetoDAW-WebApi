/**
 * 
 */
package domains;

import org.json.simple.JSONObject;


/**
 * @author Jorge
 *	1 feb. 2019
 */
public class Nivel{
	String nivel;
	double solicitudes;
	int tiempo;
	
	//CONSTRUCTORES
	public Nivel() {};
	/**
	 * 
	 * @param nivel
	 * @param solicitudes
	 * @param tiempo
	 */
	public Nivel(String nivel, double solicitudes, int tiempo) {
		this.nivel = nivel;
		this.solicitudes = solicitudes;
		this.tiempo = tiempo;
	}
	//METODOS

	//INTERFACES

	
	//GETTERS AND SETTERS

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public double getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(double solicitudes) {
		this.solicitudes = solicitudes;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	@Override
	public String toString() {
		return "Nivel [nivel=" + nivel + ", solicitudes=" + solicitudes + ", tiempo=" + tiempo + "]";
	}

}
