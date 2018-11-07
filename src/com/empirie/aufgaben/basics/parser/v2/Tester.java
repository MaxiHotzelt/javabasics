package com.empirie.aufgaben.basics.parser.v2;

public class Tester {
	public static void main(String[] args) {
		Taschenrechner rechner = new Taschenrechner();
		System.out.println("\nBerechnung 		: 3/5*8.625");
		System.out.println("Mein Ergebnis		: " + rechner.getErgebnis("3/5*8.625"));	
		System.out.println("Richtiges Ergebnis	: 5175");
		
		System.out.println("\nBerechnung 		: 72-3/5*8,625-5");
		System.out.println("Mein Ergebnis		: " + rechner.getErgebnis("72-3/5*8.625-5"));	
		System.out.println("Richtiges Ergebnis	: 61.8250");

		System.out.println("\nBerechnung 		: -1+(8*9-3/5(4+(5)-3/8)-5)/-2");
		System.out.println("Mein Ergebnis		: " + rechner.getErgebnis("-1+(8*9-3/5(4+(5)-3/8)-5)/-2"));	
		System.out.println("Richtiges Ergebnis	: -31.9125");
		
		System.out.println("\nBerechnung 		: 8/(-2(3))");
		System.out.println("Mein Ergebnis		: " + rechner.getErgebnis("8/(-2(3))"));	
		System.out.println("Richtiges Ergebnis	: -1.33333333333");
		
		System.out.println("\nBerechnung 		: 2*-25.5");
		System.out.println("Mein Ergebnis		: " + rechner.getErgebnis(" 2*-25.5"));	
		System.out.println("Richtiges Ergebnis	: -51");

		System.out.println("\nBerechnung 		: 2*(-2+((-6-3)-2)/2-3+(-5-2*5))");
		System.out.println("Mein Ergebnis		: " + rechner.getErgebnis("2*(-2+((-6-3)-2)/2-3+(-5-2*5))"));	
		System.out.println("Richtiges Ergebnis	: -51");
		
		System.out.println("\nBerechnung 		: -2-(-6)");
		System.out.println("Mein Ergebnis		: " + rechner.getErgebnis("-2-(-6)"));	
		System.out.println("Richtiges Ergebnis	: 4");
		
		System.out.println("\nBerechnung 		: (8-(3+2)/3)");
		System.out.println("Mein Ergebnis		: " + rechner.getErgebnis("(8 - (3 + 2) / 3 ) "));	
		System.out.println("Richtiges Ergebnis	: 6.33333333333");
		
		System.out.println("\nBerechnung 		: 2*3-5+((8-(3+2)/3)*1+2/1)-15");
		System.out.println("Mein Ergebnis		: " + rechner.getErgebnis("2*3-5 + ((8 - (3 + 2) / 3 ) * 1 + 2 / 1) -15"));	
		System.out.println("Richtiges Ergebnis	: -5.66666666667");
		
		
		System.out.println("\nBerechnung 		: 6-5+((8-5/3)+2)-15\"");
		System.out.println("Mein Ergebnis		: " + rechner.getErgebnis("6-5+8.333333333333332-15"));	
		System.out.println("Richtiges Ergebnis	: -5.66666666667");
		
		System.out.println("\nBerechnung 		: -2+((-6-3)-2)");
		System.out.println("Mein Ergebnis		: " + rechner.getErgebnis("-2+((-6-3)-2)"));	
		System.out.println("Richtiges Ergebnis	: -13");

		System.out.println("\nBerechnung 		: 2+25");
		System.out.println("Mein Ergebnis		: " + rechner.getErgebnis("2+25"));	
		System.out.println("Richtiges Ergebnis	: 27");

		System.out.println("\nBerechnung 		: 6(5/6-5*5)*(2+3-4)");
		System.out.println("Mein Ergebnis		: " + rechner.getErgebnis("6(5/6-5*5)*(2+3-4)"));	
		System.out.println("Richtiges Ergebnis	: -145");

		System.out.println("\nBerechnung 		: 9(2+3)(4+6)");
		System.out.println("Mein Ergebnis		: " + rechner.getErgebnis("9(2+3)(4+6)"));	
		System.out.println("Richtiges Ergebnis	: 450");

		System.out.println("\nBerechnung 		: 46*5(4+69-741/2.5)");
		System.out.println("Mein Ergebnis		: " + rechner.getErgebnis("46*5(4+69-741/2.5)"));	
		System.out.println("Richtiges Ergebnis	: -51382");

		System.out.println("\nBerechnung 		: 1-2");
		System.out.println("Mein Ergebnis		: " + rechner.getErgebnis("1-2"));	
		System.out.println("Richtiges Ergebnis	: -1");

		System.out.println("\nBerechnung 		: -2(-2-2)");
		System.out.println("Mein Ergebnis		: " + rechner.getErgebnis("-2(-2-2)"));	
		System.out.println("Richtiges Ergebnis	: 8");
	}
}
