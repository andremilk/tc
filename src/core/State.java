package core;

import java.util.Collections;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

import core.languages.Symbol;

/**
 * Class representing a State. 
 * The State object will have a certain type, a label and a reaction function which consists on a Map 
 * whereas a Symbol as a key and the values are sets of States.
 * @author andreluiz
 * @param <T>
 *
 */
public class State implements Comparable {

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
	private ConcurrentSkipListMap<Symbol, ConcurrentSkipListSet<State>> reactions;

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
		this.setLabel(label);
		this.setType(type);
		this.setReactions(new ConcurrentSkipListMap<Symbol, ConcurrentSkipListSet <State>>());
	}
	
	/**
	 * Adds one Symbol to the reaction map.
	 * @param symbol Symbol to be added.
	 * @param state State to which the symbol will lead.
	 */
	public void addReaction(Symbol symbol, State state) {
		ConcurrentSkipListSet<State> s = new ConcurrentSkipListSet<State>();
		s.add(state);
		this.getReactions().put(symbol, s);
	}

	/**
	 * Adds Symbol to the reaction map.
	 * @param symbol Symbol to be added.
	 * @param state States to which the symbol will lead.
	 */
	public void addReactions(Symbol symbol, State[] states) {
		ConcurrentSkipListSet<State> s = new ConcurrentSkipListSet<State>();
		Collections.addAll(s, states);
		this.getReactions().put(symbol, s);
	}
	
	/**
	 * Adds many Symbols to point to a state.
	 * @param symbol Symbols that will point to that state.
	 * @param state State to which the symbols will lead.
	 */
	public void addReactions(Symbol[] symbol, State state) {
		ConcurrentSkipListSet<State> s = new ConcurrentSkipListSet<State>();
		s.add(state);
		for(Symbol tmpSymbol: symbol)
			this.getReactions().put(tmpSymbol, s);
	}
	
	public ConcurrentSkipListMap<Symbol, ConcurrentSkipListSet<State>> getReactions() {
		return reactions;
	}

	public void setReactions(ConcurrentSkipListMap<Symbol, ConcurrentSkipListSet<State>> reactions) {
		this.reactions = reactions;
	}

	public StateType getType() {
		return type;
	}

	public void setType(StateType type) {
		this.type = type;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		String tmp = new String();
		tmp += "\t" +  label + ", type=" + type + "\n\t\tReaction function:\n";
		for(Symbol s: this.getReactions().keySet()) {
			tmp += "\t\t\t" + s.getValue() + " { ";
			for(State state: this.getReactions().get(s)) {
				if(state != this.getReactions().get(s).last())
					tmp +=  state.getLabel() + ", ";
				else
					tmp += state.getLabel();
			}
			tmp += " } \n";
		}
		return tmp;
	}


	/**
	 * Compares the states based on it's labels names.
	 */
	@Override
	public int compareTo(Object o) {
		State tmp = (State) o;
		return this.getLabel().compareTo(tmp.getLabel());
	}

}

