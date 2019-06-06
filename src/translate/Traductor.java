/**
 * 
 */
package translate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
/**
 * @author Jorge
 *
 */
public class Traductor {
	JSONParser jsonParser = new JSONParser();
	String idioma, url;
	String idiomaDefault ="es_ES";
	HashMap<String,Map> translate;
	Gson gson = new Gson(); 
	public Traductor(String idioma,String url) throws IOException, ParseException{
		this.idioma = idioma;
		this.url = url;
		translate = new HashMap<String,Map>();
		//recorro la carpeta languajes para ver que carpetas hay creadas
		if(comprobarIdioma(url,idioma)) {
			//si entre ellas esta la carpeta == que el idioma
			añadirIdiomaArray(url,idioma);
		}else {
			añadirIdiomaArray(url, this.idiomaDefault);
		}
		
		//pasaremos a añadir idioma
		//si no cogemos el idioma Español por defecto
		
	}

	private void añadirIdiomaArray(String url, String idioma) throws IOException, ParseException {
		
		//comprobaremos que el archivo lang.json exista si no es asi mostraremos un error y cambiaremos idioma
		//idoma en ingles, este podra ser una copia pero dentro de java.resources
		//comprobaremos tambien que no este vacio.
		
		try (FileReader reader = new FileReader(url+"/"+idioma+"/lang.json"))
		{
			//Read JSON filed
			Object obj = jsonParser.parse(reader); //parsea el file en Object generico
			JSONObject objJSon = (JSONObject) obj; //leemos el json entero y de alli sacaremos las secciones
			Type type = new TypeToken<Map<String, String>>(){}.getType(); // definimos el tipo de map que vamos a usar
			//recogemos el menu
			JSONObject menu = (JSONObject) objJSon.get("menu");
			Map<String, String> menuMap = gson.fromJson(menu.toJSONString(), type);
			translate.put("menu", menuMap);
			//System.out.println(menuMap.toString());
			//recogemos el footer
			JSONObject footer = (JSONObject) objJSon.get("footer");
			Map<String, String> menuFooter= gson.fromJson(footer.toJSONString(), type);
			translate.put("footer", menuFooter);
			
			//recogemos MenuAdmin
			JSONObject menAdmin = (JSONObject) objJSon.get("menuAdmin");
			Map<String, String> menuAdmin= gson.fromJson(menAdmin.toJSONString(), type);
			translate.put("menuAdmin", menuAdmin);
			

			//System.out.println(menuFooter.toString());
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public HashMap<String,Map> getTranslate(){
		return translate;	
	}
	// obtenemos las carpetas con idiomas creadas
	private boolean comprobarIdioma (String url,String idioma) {
		File dir = new File(url);
		String[] lenguajes = dir.list();
		for(String leng : lenguajes) {
			if(leng == idioma) {
				return true;
			}
		}
		//recorremos para ver si exisrte el idioma con la variable idioma
		return false;
		
	}
}
