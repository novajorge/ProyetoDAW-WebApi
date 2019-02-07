/**
 * 
 */
package translate;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * @author Jorge
 *
 */
public class Traductor {
	JSONParser jsonParser = new JSONParser();
	String idioma, url;
	HashMap<String, HashMap> arrayIdioma;

	public Traductor(String idioma,String url) throws IOException, ParseException{
		this.idioma = idioma;
		this.url = url;
		//recorro la carpeta languajes para ver que carpetas hay creadas
		//si entre ellas esta la carpeta == que el idioma
		//pasaremos a añadir idioma
		//si no cogemos el idioma ingles por defecto
		añadirIdiomaArray();
	}

	private void añadirIdiomaArray() throws IOException, ParseException {
		
		//comprobaremos que el archivo lang.json exista si no es asi mostraremos un error y cambiaremos idioma
		//idoma en ingles, este podra ser una copia pero dentro de java.resources
		//comprobaremos tambien que no este vacio.
		try (FileReader reader = new FileReader(url+"/"+idioma+"/lang.json"))
		{
			Gson gson = new Gson(); 
			//Read JSON filed
			Object obj = jsonParser.parse(reader);
			JSONObject objJSon = (JSONObject) obj;
			
			//recogemos el menu
			JSONObject menu = (JSONObject) objJSon.get("menu");

			HashMap <String, String>menuMap = gson.fromJson(menu.toJSONString());
			//recogemos el footer
			JSONObject footer = (JSONObject) objJSon.get("footer");
			
			System.out.println(menu.toJSONString());
			System.out.println(footer.toJSONString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public HashMap<String,HashMap> getArrayIdioma(){
		return arrayIdioma;	
	}
}
