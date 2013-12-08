package examples.core.languages;

import core.languages.Symbol;

public class SymbolExample {


	public static void main(String[] args) {
		Symbol<Integer> intSymbol = new Symbol<Integer>(new Integer(15));
		Symbol<String> strSymbol = new Symbol<String>(new String("This is a test"));
		System.out.println(intSymbol);
		System.out.println(strSymbol);

	}

}
