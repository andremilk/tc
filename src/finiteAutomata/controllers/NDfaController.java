package finiteAutomata.controllers;

import java.util.concurrent.ConcurrentSkipListSet;

import core.State;
import core.languages.Symbol;
import finiteAutomata.FiniteAutomaton;

public class NDfaController {
	/**
	 * Current state of the automaton.
	 */
	private ConcurrentSkipListSet<State> currentStates;
	
	/**
	 * Input sequence for the automaton.
	 */
	private Symbol<?>[] input;
	
	/**
	 * Automaton to be controlled.
	 */
	private FiniteAutomaton dfa;
	
	/**
	 * Constructor of a DfaController.
	 * @param dfa Automaton to be controlled.
	 */
	public NDfaController(FiniteAutomaton dfa) {
		this.dfa = dfa;
		this.currentStates = new ConcurrentSkipListSet<State>();
		this.currentStates.add(dfa.getInitialState());
	}

	/**
	 * Constructor of a DfaController.
	 * @param dfa Automaton to be controlled.
	 * @param input Input to be read consisted of an array of Symbols.
	 */
	public NDfaController(FiniteAutomaton dfa, Symbol<?>[] input) {
		this.dfa = dfa;
		this.input = input;
		this.currentStates = new ConcurrentSkipListSet<State>();
		this.currentStates.add(dfa.getInitialState());

	}
	
	/**
	 * Constructor of a DfaController.
	 * @param dfa Automaton
	 * @param input String input to be read. The string will be converted to an array of Symbols.
	 */
	public NDfaController(FiniteAutomaton dfa, String input) {
		this.dfa = dfa;
		this.input = new Symbol[input.length()];
		for(int i = 0; i < input.length(); i++)
			this.input[i] = new Symbol(input.toCharArray()[i]);
		this.currentStates = new ConcurrentSkipListSet<State>();
		this.currentStates.add(dfa.getInitialState());
	}
	
	/**
	 * Reads the input all the way through.
	 */
	public void readInput() {
		ConcurrentSkipListSet<State> tmp = new ConcurrentSkipListSet<State>();
		this.setCurrentStates(this.getDfa().getInitialState());
		
		for(Symbol s: input) {
			for(State state: this.getCurrentStates()) {
				if(state.getReactions().containsKey(s)) 
					tmp.addAll(state.getReactions().get(s));
			}
			this.setCurrentStates(tmp);
		}
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
		Symbol[] tmp = new Symbol[s.length()];
		for(int i = 0; i < s.length(); i++)
			tmp[i] = new Symbol(s.toCharArray()[i]);
		
		this.setInput(tmp);
		this.readInput();
	}
	


	public ConcurrentSkipListSet<State> getCurrentStates() {
		return currentStates;
	}

	public void setCurrentStates(ConcurrentSkipListSet<State> concurrentSkipListSet) {
		this.currentStates = concurrentSkipListSet;
	}
	
	public void setCurrentStates(State state) {
		this.currentStates = new ConcurrentSkipListSet<State>();
		this.currentStates.add(state);
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

	public FiniteAutomaton getDfa() {
		return dfa;
	}

	public void setDfa(FiniteAutomaton dfa) {
		this.dfa = dfa;
	}
	
}
