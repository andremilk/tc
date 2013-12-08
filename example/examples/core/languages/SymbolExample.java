package examples.core.languages;

import core.languages.Symbol;

public class SymbolExample {


	public static void main(String[] args) {
		Symbol intSymbol = new Symbol(new Integer(15));
		Symbol strSymbol = new Symbol(new String("This is a test"));
		System.out.println(intSymbol);
		System.out.println(strSymbol);

	}

}
