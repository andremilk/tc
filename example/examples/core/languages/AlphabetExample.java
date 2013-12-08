package examples.core.languages;

import core.languages.Alphabet;
import core.languages.Symbol;

public class AlphabetExample {

	public static void main(String[] args) {
		Alphabet abcd = new Alphabet("abcdario");
		Symbol<String> a = new Symbol<String>(new String("a"));
		Symbol<Integer> one = new Symbol<Integer>(new Integer(1));
		abcd.add(a);
		abcd.add(one);
		System.out.println(abcd.toString());
	}

}
