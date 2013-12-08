package examples.core;

import core.State;
import core.State.StateType;
import core.languages.Symbol;

public class StateExample {

	public static void main(String[] args) {
		State s1 = new State("s1", StateType.DEFAULT);
		State s2 = new State("s2", StateType.FINAL);
		Symbol<String> a = new Symbol<String>("A");
		Symbol<String> b = new Symbol<String>("B");
		s1.addReaction(a, s2);
		s1.addReaction(b, s2);
		System.out.println(s1);
	}

}
