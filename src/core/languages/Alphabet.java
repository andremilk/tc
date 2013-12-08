package core.languages;

import java.util.concurrent.ConcurrentSkipListSet;

/**
 * This class will represent an alphabet. 
 * An alphabet can hold symbols of any time.
 * @author andreluiz
 *
 * @param <T> Type of the symbols to be held.
 */
public class Alphabet<Symbol> extends ConcurrentSkipListSet<Symbol> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7654544380638271534L;

	/**
	 * Name of the alphabet.
	 */
	private String alias;
	
	/**
	 * Default constructor. It sets alias to null.
	 */
	public Alphabet() {
		super();
		this.alias = null;
	}
	
	/**
	 * Constructor to create an alphabet with the given name.
	 * @param alias Alphabet's name.
	 */
	public Alphabet(String alias) {
		super();
		this.alias = alias;
	}

	public String getAlias() {
		return alias;
	}
	
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	
	
	@Override
	public String toString() {
		String tmp = new String();
		tmp += alias + "\n Contents:\n";
		for(Symbol s: this)
			tmp += "\t" + s.toString() + "\n";
		
		return tmp;
	}
	
}
