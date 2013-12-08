package core;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

import core.languages.Symbol;

/**
 * Class representing a State. 
 * The State object will have a certain type, a label and a reaction function which consists on a Map 
 * whereas a Symbol as a key and the values are sets of States.
 * @author andreluiz
 *
 */
public class State {

	/**
	 * Readable label representing the state.
	 */
	private String label;
	
	/**
	 * Type of the state.
	 */
	private StateType type;
	
	/**
	 * Map of reactions. 
	 */
	private ConcurrentSkipListMap<Symbol, ConcurrentSkipListSet <State>> reactions;

	/**
	 * Type of states to be used.
	 * @author andreluiz
	 *
	 */
	public static enum StateType {
		FINAL,
		START,
		DEFAULT
	}
	
	/**
	 * Default constructor for the State class. This constructor will create a StateType.DEFAULT state.
	 * @param label Alias to the state being created.
	 */
	public State(String label) {
		this(label, StateType.DEFAULT);
	}
	
	/**
	 * Constructor for the State class.
	 * @param label Alias to the state being created.
	 * @param type Type of the new State object. 
	 */
	public State(String label, StateType type) {
		this.label = label;
		this.type = type;
		this.reactions = new ConcurrentSkipListMap<Symbol, ConcurrentSkipListSet <State>>();
	}

}

