package domains;
/**
 * 
 * @author jorge.arroyo.rey
 *
 */
public class TypesDatabase {
	private int id;
	private String name, connector;
	public TypesDatabase(int id, String name, String connector) {
		super();
		this.id = id;
		this.name = name;
		this.connector = connector;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getConnector() {
		return connector;
	}
	public void setConnector(String connector) {
		this.connector = connector;
	}
	@Override
	public String toString() {
		return "TypesDatabase [id=" + id + ", name=" + name + ", connector=" + connector + "]";
	}
	
	
}
