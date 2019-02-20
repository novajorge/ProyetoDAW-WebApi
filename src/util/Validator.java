package util;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;
import javax.xml.bind.DatatypeConverter;

import recursos.Costantes;


/**
 * Clase que maneja las validaciones de los formatos de los datos de la aplicacion
 * 
 */
public class Validator {

	/**
	 * Metodo que comprueba la cantidad de caracteres de una cadena
	 * 
	 * @param cadena
	 *            Cadena a comprobar
	 * @param min
	 *            Minimo de caracteres
	 * @param max
	 *            Maximo de caracteres
	 * @return boolean; true = valido
	 */
	public static boolean length(String cadena, int min, int max) {
		boolean validation = false;
		if (cadena != null) {
			cadena=cadena.trim();
			if (cadena.length() >= min && cadena.length() <= max) {
				validation = true;
			}
		}
		return validation;

	}
	/**
	 * Metodo que comprueba la cantidad de caracteres de una cadena
	 * 
	 * @param cadena
	 *            Cadena a comprobar
	 * @param min
	 *            Minimo de caracteres
	 * @param max
	 *            Maximo de caracteres
	 * @return boolean; true = valido
	 */
	public static boolean lengthDecimal(double numero, int precision, int escala) {
		// los ceros a la izquierda ,y a la derecha de la parte decimal, son omitidos
		//en java por el tipo Double.
		String decimal=null;
		if (numero < 0)numero *= -1;
		// para la parte entera
		if ((int)numero >= Math.pow(10,  precision - escala))
			return false;
		// para los decimales
		decimal=new Double(numero).toString();
		decimal=decimal.substring(decimal.indexOf(".")+1);
	
		if(decimal.length()<=escala){
	
		return true;
		}
		else{
			
			return false;
		}
			
	}

	/*
	 * public static boolean alphanumeric(String cadena){ boolean validation = false; if (cadena != null){ String regex = "[a-zA-Z0-9\\s]+"; if
	 * (cadena.matches(regex)){ validation = true; } } return validation; }
	 */

	/**
	 * Comprueba si un email es valido
	 * 
	 * @param email
	 * @param emailMax
	 * @param emailMin
	 * @return boolean; true = email valido
	 */
	public static boolean email(String email, int emailMin, int emailMax) {
		boolean validation = false;
		if (Validator.length(email, emailMin, emailMax)) {
			String regex = "/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/";
			if (email.matches(regex)) {
				validation = true;
			}
		}
		return validation;

	}

	/**
	 * Comprueba que el telefono solo tiene numeros y espacios, puede tener '+' delante
	 * 
	 * @param phoneNo
	 * @return boolean
	 */
	public static boolean telephone(String phoneNo, int min, int max) {
		boolean validation = false;
		if (Validator.length(phoneNo, min, max)) {
			phoneNo = phoneNo.trim();
			if(phoneNo.length()>0){
				
		
				String regex = "^[+]?([0-9]|\\s)+";
				if (phoneNo.matches(regex)) {
					validation = true;
				}
			
			}else{
				validation=true;
			}
		}
		return validation;
	}


	/**
	 * Comprueba que el DNI es valido
	 * 
	 * @param dni
	 * @return boolean
	 */

	public static boolean DNI(String dni) {
		boolean validation = false;
		if (dni != null) {
			dni=dni.trim();
			String regex = "[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}\\-[A-Za-z]{1}";
			if (dni.matches(regex)) {
				char[] letras = "TRWAGMYFPDXBNJZSQVHLCKE".toCharArray();
				int numeroDNI = 0;
				char miLetra;

				// Quito los caracteres que no necesito
				dni = dni.replace(".", "");
				dni = dni.replace("-", "");

				// Separo la letra de los nÃºmeros
				miLetra = dni.charAt(dni.length() - 1);
				dni = dni.substring(0, dni.length() - 1);
				try {
					numeroDNI = Integer.parseInt(dni);
					if (letras[numeroDNI % 23] == miLetra) {
						validation = true;
					}
				} catch (NumberFormatException e) {
					validation = false;
				}

			}
		}
		return validation;
	}
	public static boolean esEmail(String email) {
        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher mather = pattern.matcher(email);
 
        if (mather.find() == true) {
           return true;
        } else {
           return false;
        }
	}
	
	public static boolean contraseñaMD5Correcta(String formPassword, String dbPassword) throws NoSuchAlgorithmException {
	    String hash = dbPassword;
	    String password = formPassword;
	         
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(password.getBytes());
	    byte[] digest = md.digest();
	    String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
	    //System.out.println(myHash);
	    //System.out.println(hash);
	    
	    return myHash.equals(hash.toUpperCase());
	}

	public static boolean verify(String gRecaptchaResponse) {
        if (gRecaptchaResponse == null || gRecaptchaResponse.length() == 0) {
            return false;
        }
 
        try {
            URL verifyUrl = new URL(Costantes.SITE_VERIFY_URL);
 
            // Open a Connection to URL above.
            HttpsURLConnection conn = (HttpsURLConnection) verifyUrl.openConnection();
 
            // Add the Header informations to the Request to prepare send to the server.
            conn.setRequestMethod("POST");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
 
            // Data will be sent to the server.
            String postParams = "secret=" + Costantes.SECRET_KEY //
                    + "&response=" + gRecaptchaResponse;
 
            // Send Request
            conn.setDoOutput(true);
 
            // Get the output stream of Connection.
            // Write data in this stream, which means to send data to Server.
            OutputStream outStream = conn.getOutputStream();
            outStream.write(postParams.getBytes());
 
            outStream.flush();
            outStream.close();
 
            // Response code return from Server.
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode=" + responseCode);
 
            // Get the Input Stream of Connection to read data sent from the Server.
            InputStream is = conn.getInputStream();
 
            JsonReader jsonReader = Json.createReader(is);
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
 
            // ==> {"success": true}
            System.out.println("Response: " + jsonObject);
 
            boolean success = jsonObject.getBoolean("success");
            return success;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    } 
	
	
	
	
	public static void main(String []a){
		
		System.out.println(Validator.lengthDecimal( -22, 5,2));
		double a1=0;
		System.out.println(a1);
	}
	
	
	
}
