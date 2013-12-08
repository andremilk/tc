package core.languages;

/**
 * Class representing symbols. These symbols will populate alphabets.
 * @author andreluiz
 *
 * @param <T> A Symbol can be any kind of object.
 */
public class Symbol<T> implements Comparable<T> {

	/**
	 * This attribute will hold the object type of the symbol.
	 */
	private Class<? extends Object> type;
	
	/**
	 * String value/alias to the symbol.
	 */
	private String value;
	
	/**
	 * Default constructor for a Symbol.
	 * @param obj Object to be used on the construction. It can be an object of any type.
	 */
	public Symbol(Object obj) {
		this.value = obj.toString();
		type = obj.getClass();
	}

	/**
	 * 
	 * @return type of the object used on the construction.
	 */
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

	@Override
	public String toString() {
		return "Symbol [type=" + type + ", value=" + value + "]";
	}

	@Override
	public int compareTo(Object arg0) {
		Symbol tmp = (Symbol) arg0;
		return this.getValue().compareTo(tmp.getValue());
	}

}
