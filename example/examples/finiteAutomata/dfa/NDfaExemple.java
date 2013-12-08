package examples.finiteAutomata.dfa;

import java.util.concurrent.ConcurrentSkipListSet;

import core.State;
import core.State.StateType;
import core.languages.Alphabet;
import core.languages.Symbol;
import finiteAutomata.FiniteAutomaton;
import finiteAutomata.controllers.DfaController;
import finiteAutomata.controllers.NDfaController;

public class NDfaExemple {

	public static void main(String[] args) {
		ConcurrentSkipListSet<State> states = new ConcurrentSkipListSet<State>();
		ConcurrentSkipListSet<State> finalStates = new ConcurrentSkipListSet<State>();

		Alphabet alphabet = new Alphabet("binarios");
		Symbol zero = new Symbol("0");
		Symbol um = new Symbol("1");
		alphabet.add(zero);
		alphabet.add(um);
	
		
		State q1 = new State("q1", StateType.START);
		State q2 = new State("q2", StateType.DEFAULT);
		State q3 = new State("q3", StateType.DEFAULT);
		State q4 = new State("q4", StateType.FINAL);
		
		q1.addReaction(zero, q1);
		q1.addReaction(um, q1);
		q1.addReaction(um, q2);
		
		q2.addReaction(um, q3);
		q2.addReaction(zero, q3);
		
		q3.addReaction(zero, q4);
		q3.addReaction(um, q4);
		
		finalStates.add(q4);
		states.add(q1);
		states.add(q2);
		states.add(q3);
		states.add(q4);
		
		
		try {
			FiniteAutomaton m1 = new FiniteAutomaton("M1", states, alphabet, q1, finalStates);
			//System.out.println(m1);

			NDfaController m1c = new NDfaController(m1);
			//m1c.readInput();
		//	System.out.println(m1c.getDfa().getStates());
			m1c.readInput("000100");
			System.out.println("Que estado terminou?");
			System.out.println(m1c.getCurrentStates());
			
			m1c.readInput("0011");
			System.out.println("Que estado terminou?");
			System.out.println(m1c.getCurrentStates());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}