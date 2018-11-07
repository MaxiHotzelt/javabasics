package com.empirie.aufgaben.basics.kai;

public class Tester {

	public static void main(String[] args) {
		TaschenrechnerOperator to = new TaschenrechnerOperator();
		to.isValid("1+2");
		System.out.println("3\n");
		to.isValid("5/4");
		System.out.println("1.25\n");
		to.isValid("5(6+3-5)");
		System.out.println("20\n");
		to.isValid("6(5/6-5*5)*(2+3-4)");
		System.out.println("-145\n");
		to.isValid("9(2+3)*(4+6)");
		System.out.println("450\n");
		to.isValid("46*5(4+69-741/2.5)");
		System.out.println("-51382\n");
		to.isValid("-1+(8*9-3/5(4+(5)-3/8)-5)/-2");
		System.out.println("-31.9125\n");
		to.isValid("1-2");
		System.out.println("-1\n");
		to.isValid("8/(-2(3))");  
		System.out.println("-1.33333333333\n");  
		to.isValid(" 2*-25.5");    
		System.out.println("-51\n");
		to.isValid("-2-(-6)");    
		System.out.println("4\n");
		to.isValid("6-5+8.333332-15");
		System.out.println("-5.666668\n");    
		to.isValid("2+25");    
		System.out.println("27\n");
      	to.isValid("1(1*(2+3))");
		System.out.println("5\n");
      	to.isValid("-2+((-6-3)-2)");    //-> hier endlos schleife
		System.out.println("-13\n");
		to.isValid("(8 + 2) / 5  ");   // -> hier fehler
		System.out.println("\n\n1.25");
		to.isValid("2*3-5 + ((8 - (3 + 2) / 3 ) * 1 + 2 / 1) -15"); // hier fehler    
		System.out.println("1.25");
		to.isValid("2*(-2+((-6-3)-2)/2-3+(-5-2*5))");   // -> endlos schleife
		System.out.println("1.25");
		to.isValid("(1/4-3/2)+(9*7/2)*(4+5)");
		System.out.println("1.25");
		to.isValid("2/4((4-6+8*5)/4(4+5-6))");
		System.out.println("1.25");
	}
}