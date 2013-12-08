package core;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

import core.languages.Alphabet;
import core.languages.Symbol;

public class State {

	private String label;
	private StateType type;
	private ConcurrentSkipListMap<Symbol, ConcurrentSkipListSet <State>> reactions;

	public static enum StateType {
		FINAL,
		START,
		DEFAULT
	}
	
	public State(String label) {
		this(label, StateType.DEFAULT);
	}
	
	public State(String label, StateType type) {
		this.label = label;
		this.type = type;
		this.reactions = new ConcurrentSkipListMap<Symbol, ConcurrentSkipListSet <State>>();
	}

}

