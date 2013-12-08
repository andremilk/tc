package finiteAutomata.dfa;

import java.util.concurrent.ConcurrentSkipListSet;

import core.State;
import core.languages.Symbol;

/**
 * Class that will control the automaton.
 * @author andreluiz
 *
 */
public class DfaController {
	
	/**
	 * Current state of the automaton.
	 */
	private State currentState;
	
	/**
	 * Input sequence for the automaton.
	 */
	private Symbol<?>[] input;
	
	/**
	 * Automaton to be controlled.
	 */
	private Dfa dfa;
	
	/**
	 * Constructor of a DfaController.
	 * @param dfa Automaton to be controlled.
	 */
	public DfaController(Dfa dfa) {
		this.dfa = dfa;
		currentState = dfa.getInitialState();
	}

	/**
	 * Constructor of a DfaController.
	 * @param dfa Automaton to be controlled.
	 * @param input Input to be read consisted of an array of Symbols.
	 */
	public DfaController(Dfa dfa, Symbol<?>[] input) {
		this.dfa = dfa;
		this.input = input;
		currentState = dfa.getInitialState();

	}
	
	/**
	 * Constructor of a DfaController.
	 * @param dfa Automaton
	 * @param input String input to be read. The string will be converted to an array of Symbols.
	 */
	public DfaController(Dfa dfa, String input) {
		this.dfa = dfa;
		this.input = new Symbol[input.length()];
		for(int i = 0; i < input.length(); i++)
			this.input[i] = new Symbol(input.toCharArray()[i]);
		currentState = dfa.getInitialState();
	}
	
	/**
	 * Reads the input all the way through.
	 */
	public void readInput() {
		for(Symbol s: input)
			if(this.getCurrentState().getReactions().containsKey(s))
				this.setCurrentState(this.getCurrentState().getReactions().get(s).first());
			else
				this.setCurrentState(new State("Not accepted"));
	}
	
	/**
	 * Reads one given symbol.
	 * @param s Symbol to be read.
	 */
	public void readInput(Symbol s) {
		this.setInput(s);
		this.readInput();
	}
	
	public void readInput(String s) {
		this.setInput(new Symbol(s));
		this.readInput();
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State concurrentSkipListSet) {
		this.currentState = concurrentSkipListSet;
	}

	public Symbol<?>[] getInput() {
		return input;
	}

	public void setInput(Symbol<?>[] input) {
		this.input = input;
	}
	
	public void setInput(Symbol s) {
		Symbol<?>[] symbol = new Symbol<?>[1];
		symbol[0] = s;
		this.setInput(symbol);
	}

	public Dfa getDfa() {
		return dfa;
	}

	public void setDfa(Dfa dfa) {
		this.dfa = dfa;
	}
	
}
