package domains;

public class Describe {
	String field,type, nullFild, key, defaultFild, extra;
	
	public Describe() {}

	public Describe(String field, String type, String nullFild, String key, String defaultFild, String extra) {
		super();
		this.field = field;
		this.type = type;
		this.nullFild = nullFild;
		this.key = key;
		this.defaultFild = defaultFild;
		this.extra = extra;
	}

	@Override
	public String toString() {
		return "Describe [field=" + field + ", type=" + type + ", nullFild=" + nullFild + ", key=" + key
				+ ", defaultFild=" + defaultFild + ", extra=" + extra + "]";
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNullFild() {
		return nullFild;
	}

	public void setNullFild(String nullFild) {
		this.nullFild = nullFild;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getDefaultFild() {
		return defaultFild;
	}

	public void setDefaultFild(String defaultFild) {
		this.defaultFild = defaultFild;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}
	
}
