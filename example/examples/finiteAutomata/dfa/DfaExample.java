package examples.finiteAutomata.dfa;

import java.util.concurrent.ConcurrentSkipListSet;

import core.State;
import core.State.StateType;
import core.languages.Alphabet;
import core.languages.Symbol;
import finiteAutomata.FiniteAutomaton;
import finiteAutomata.controllers.DfaController;

public class DfaExample {

	public static void main(String[] args) {
		ConcurrentSkipListSet<State> states = new ConcurrentSkipListSet<State>();
		ConcurrentSkipListSet<State> finalStates = new ConcurrentSkipListSet<State>();

		Alphabet alphabet = new Alphabet("abcdario");
		alphabet.add(new Symbol<String>("a"));
		alphabet.add(new Symbol<String>("b"));
		alphabet.add(new Symbol<Integer>(15));
		
		State s1 = new State("s1", StateType.DEFAULT);
		State s2 = new State("s2", StateType.FINAL);
		State initialState = new State("Initial state", StateType.START);
		
		initialState.addReaction(new Symbol<String>("a"), s1);
		initialState.addReaction(new Symbol<String>("b"), initialState);
		s1.addReaction(new Symbol<String>("b"), s2);
		
		finalStates.add(s2);
		states.add(s1);
		states.add(s2);
		states.add(initialState);
		
		try {
			FiniteAutomaton m1 = new FiniteAutomaton("M1", states, alphabet, initialState, finalStates);
			System.out.println(m1);

			DfaController m1c = new DfaController(m1, "a");
			m1c.readInput();
			m1c.readInput("b");
			System.out.println("Que estado terminou?");
			System.out.println(m1c.getCurrentState());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
