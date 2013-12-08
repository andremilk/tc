package core.languages;

public class Symbol<T> {

	private Class<? extends Object> type;
	private String value;
	
	public Symbol(Object obj) {
		this.value = obj.toString();
		type = obj.getClass();
	}

	public Class<? extends Object> getType() {
		return type;
	}

	public void setType(Class<? extends Object> type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
