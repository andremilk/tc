package finiteAutomata.dfa;

import java.util.concurrent.ConcurrentSkipListSet;

import core.State;
import core.languages.Alphabet;

/**
 * This class will be used to create a finite automaton.
 * @author andreluiz
 *
 */
public class DfaController {
	
	/**
	 * States that this automaton.
	 */
	private ConcurrentSkipListSet<State> states;
	
	/**
	 * Automaton's alphabet.
	 */
	private Alphabet alphabet;
	
	/**
	 * Initial state for this automaton.
	 */
	private State initialState;
	
	/**
	 * Set of final states for this automaton.
	 */
	private ConcurrentSkipListSet<State> finalStates;
	
	/**
	 * Alias for the automaton.
	 */
	private String alias;

	/**
	 * Constructor for DfaController. This will create an automaton with the given parameters.
	 * @param alias Readable name for the automaton.
	 * @param states Set of states for this automaton.
	 * @param alphabet Alphabet that this automaton will recognize.
	 * @param initialState Initial state for this automaton. This state should be included on the states set as well.
	 * @param finalStates Final states. These states should be included on the states set as well.
	 * @throws Exception Thrown if initialState or the finalStates are not included on the states set.
	 */
	public DfaController(String alias, ConcurrentSkipListSet<State> states, Alphabet alphabet, 
			State initialState, ConcurrentSkipListSet<State> finalStates) throws Exception {
		this.alias = alias;
		this.states = states;
		this.alphabet = alphabet;
		if(states.contains(initialState) || !states.containsAll(finalStates)) {
			this.initialState = initialState;
			this.finalStates = finalStates;
		}
		else
			throw new Exception("Initial or final states are not on the states set");
	}

	public ConcurrentSkipListSet<State> getStates() {
		return states;
	}

	public void setStates(ConcurrentSkipListSet<State> states) {
		this.states = states;
	}

	public Alphabet getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(Alphabet alphabet) {
		this.alphabet = alphabet;
	}

	public State getInitialState() {
		return initialState;
	}

	public void setInitialState(State initialState) {
		this.initialState = initialState;
	}

	public ConcurrentSkipListSet<State> getFinalStates() {
		return finalStates;
	}

	public void setFinalStates(ConcurrentSkipListSet<State> finalStates) {
		this.finalStates = finalStates;
	}

	@Override
	public String toString() {
		String tmp = new String();
		tmp += alias;
		tmp += "\n States:\n  ";
		for(State s: states)
			tmp += s;
		
		tmp += "Alphabet: ";
		tmp += alphabet;
		tmp += "\n Initial State:\n" + initialState;
		tmp += "\n Final States:\n";
		for(State s: finalStates)
			tmp += s;
		return tmp;
	}
	
	
}
