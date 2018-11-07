package com.empirie.aufgaben.basics.variablen.taschenrechner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
*
* Das ist ein Taschenrechner-Programm. Es kann zwei Zahlen mit einem beliebigem Operator verrechnen.
*
* @author Maxi Hotzelt
* @version 1.0
*/

public class Taschenrechner {
	
	
	/**
	* 
	* Dieses Programm fragt nach zwei Zahlen und einem Operator, welche dann
	* zu einem Ergebnis verrechnet werden. Dieses wird dann in der Konsole ausgegeben.
	*
	* @param args Standardparameter
	*
	*/
	public static void main(String[] args) {
		
		
		/* Anfangsübungen 
		
		//numbers
		short shortType = 123;
		int integerType = 5098428;
		long longType = 50984284469846l;
		float floatType = 42.324234234f;
		double doubleType = 4.54534535345442423423423423423423;
		
		//alphabetic stuff
		String stringType = "Hallo";
		char charType = 'c';
		
		
		//true false
		boolean booleanType = true;
		
		
		
		System.out.print(shortType + "\n");
		System.out.print(integerType + "\n");
		System.out.print(longType + "\n");
		System.out.print(doubleType + "\n");
		System.out.print(floatType + "\n");
		System.out.print(stringType + "\n");
		System.out.print(charType + "\n");
		System.out.print(booleanType + "\n");
		
		*/
		
		/* Taschenrechner V_1
		double ergebnis = 0;
		String operator;
		
		
		System.out.println("Herzlich Willkommen bei deinem Taschenrechner, bitte eine Rechenoperation ein:");
		
		//number1
		System.out.print("Zahl 1: ");
		double zahl1 = readInt();
		
		//operator
		System.out.print("Operator: ");
		operator = readText();
		
		//number 2
		System.out.print("Zahl 2: ");
		double zahl2 = readInt();
		
		
		//check operator
		if(operator.equals("+")) {
			ergebnis = zahl1 + zahl2;	
		} else if(operator.equals("-")) {
			ergebnis = zahl1 - zahl2;	
		} else if(operator.equals("*")) {
			ergebnis = zahl1 * zahl2;	
		} else if(operator.equals("/")){ 
			ergebnis = zahl1 / zahl2;	
		} else {
			System.out.println("Falscher Operator, bitte versuche es erneut...");
		}
		
		
		
		System.out.println(zahl1 + operator + zahl2 + " = " + ergebnis);
		*/
				
		/* Taschenrechner V_2
		double dZahl1 = 0, dZahl2 = 0, dErgebnis = 0;
		String operator = "", sRepeat;
		boolean repeat = true, isOperator = false;
		
		
		
		while(repeat) {
			isOperator = false;
			
			//number1
			System.out.print("Zahl 1: ");
			dZahl1 = readInt();
			
			//operator
			while(!isOperator) {
				System.out.print("Operator: ");
				operator = readText();
				if(operator.equals("+")) {
					isOperator = true;
				} else if(operator.equals("-")) {
					isOperator = true;		
				} else if(operator.equals("*")) {
					isOperator = true;
				} else  if(operator.equals("/")) {
					isOperator = true;
				} else {
					System.out.println("Falscher Operator - bitte versuche es erneut...");
					isOperator = false;
				}
			}
			
			//number 2
			System.out.print("Zahl 2: ");
			dZahl2 = readInt();
			
			//check operator
			if(operator.equals("+")) {
				dErgebnis = dZahl1 + dZahl2;
			} else if(operator.equals("-")) {
				dErgebnis = dZahl1 - dZahl2;
			} else if(operator.equals("*")) {
				dErgebnis = dZahl1 * dZahl2;
			} else if(operator.equals("/")){ 
				dErgebnis = dZahl1 / dZahl2;
			} 

			
			//show ergebnis
			System.out.println(dZahl1 + operator + dZahl2 + " = " + dErgebnis);
			
			
			//ask for repeat
			System.out.println("Neue Berechnung: y/n");
			sRepeat = readText();
			if(sRepeat.equals("y")) {
				repeat = true;
			} else {
				repeat = false;
			}
			
		}
		*/
			
		/* Taschenrechner V_3
		double dZahl1 = 0, dZahl2 = 0, dErgebnis = 0;
		String sOperator = "", sRepeat;
		char cOperator =' ';
		boolean repeat = true, isOperator = false;
		
		
		while(repeat) {
			
			//reset isOperator
			isOperator = false;
			
			//number1
			System.out.print("Zahl 1: ");
			dZahl1 = readInt();
			
			
				
			//operator
			while(!isOperator) {
				
				System.out.print("Operator: ");
				sOperator = readText();
				
				//get operator as char
				cOperator = sOperator.charAt(0);
				
				switch(cOperator) {
				case '+' :
					isOperator = true;
					break;
				case '-' :
					isOperator = true;
					break;
				case '*' :
					isOperator = true;
					break;
				case '/' :
					isOperator = true;
					break;
				default: 
					System.out.println("Falscher Operator - bitte versuche es erneut...");
					isOperator = false;
					break;
				}
			}
			
			
			
			//number 2
			System.out.print("Zahl 2: ");
			dZahl2 = readInt();
			
			
			//check operator
			switch(cOperator) {
				case '+' :
					dErgebnis = dZahl1 + dZahl2;
					break;
				case '-' :
					dErgebnis = dZahl1 - dZahl2;
					break;
				case '*' :
					dErgebnis = dZahl1 * dZahl2;
					break;
				case '/' :
					dErgebnis = dZahl1 / dZahl2;
					break;
				default: break;
			}

			
			//show result
			System.out.println(dZahl1 + sOperator + dZahl2 + " = " + dErgebnis);
			
			
			//ask for repeat
			System.out.println("Neue Berechnung: y/n");
			sRepeat = readText();
			if(sRepeat.equals("y")) {
				repeat = true;
			} else {
				repeat = false;
			}
			
		}
		*/
			
		/* Taschenrechner V_4
		double dZahl1 = 0, dZahl2 = 0, dErgebnis = 0;
		String sOperator = "", sRepeat;
		char cOperator =' ';
		boolean repeat = true, isOperator = false;
		
		
		
		do {
			//reset isOperator
			isOperator = false;
			
			//number1
			System.out.print("Zahl 1: ");
			dZahl1 = readInt();
			
			
				
			//operator
			do {
				System.out.print("Operator: ");
				sOperator = readText();
				
				//get operator as char
				cOperator = sOperator.charAt(0);
				
				switch(cOperator) {
				case '+' :
					isOperator = true;
					break;
				case '-' :
					isOperator = true;
					break;
				case '*' :
					isOperator = true;
					break;
				case '/' :
					isOperator = true;
					break;
				default: 
					System.out.println("Falscher Operator - bitte versuche es erneut...");
					isOperator = false;
					break;
				}
			} while(!isOperator);
			
			
			//number 2
			System.out.print("Zahl 2: ");
			dZahl2 = readInt();
			
			
			//check operator
			switch(cOperator) {
				case '+' :
					dErgebnis = dZahl1 + dZahl2;
					break;
				case '-' :
					dErgebnis = dZahl1 - dZahl2;
					break;
				case '*' :
					dErgebnis = dZahl1 * dZahl2;
					break;
				case '/' :
					dErgebnis = dZahl1 / dZahl2;
					break;
				default: break;
			}

			
			//show result
			System.out.println(dZahl1 + sOperator + dZahl2 + " = " + dErgebnis);
			
			
			//ask for repeat
			System.out.println("Neue Berechnung: y/n");
			sRepeat = readText();
			if(sRepeat.equals("y")) {
				repeat = true;
			} else {
				repeat = false;
			}
			
			
		} while(repeat);
	}
	*/
		
		//Taschenrechner V_5
		double dZahl1 = 0, dZahl2 = 0, dErgebnis = 0;
		String sOperator = "", sRepeat;
		char cOperator =' ';
		boolean repeat = true, isOperator = false, jumpOut = false;
		
		
		
		do {
			//reset stuff
			isOperator = false;
			jumpOut = false;
			
			//number1
			System.out.print("Zahl 1: ");
			dZahl1 = readInt();
			
			
				
			//operator
			System.out.print("Operator: ");
			sOperator = readText();
			
			//get operator as char
			cOperator = sOperator.charAt(0);
				
			//check if valid operator	
			if(!(cOperator == '+' || cOperator == '-' || cOperator == '*' || cOperator == '/')) {
				continue;
			} 
			
			
			//number 2
			System.out.print("Zahl 2: ");
			dZahl2 = readInt();
			
			
			//check operator
			switch(cOperator) {
				case '+' :
					dErgebnis = dZahl1 + dZahl2;
					break;
				case '-' :
					dErgebnis = dZahl1 - dZahl2;
					break;
				case '*' :
					dErgebnis = dZahl1 * dZahl2;
					break;
				case '/' :
					dErgebnis = dZahl1 / dZahl2;
					break;
				default: break;
			}
			

			
			//show result
			System.out.println(dZahl1 + sOperator + dZahl2 + " = " + dErgebnis);
			
			
			//ask for repeat
			System.out.println("Neue Berechnung: y/n");
			sRepeat = readText();
			if(sRepeat.equals("y")) {
				repeat = true;
			} else {
				repeat = false;
			}
			
			
		} while(repeat);
	}
	

	/**
	* Diese Methode liest einen Text ein und gibt den eingelesenen String zurück
	*
	* @return String text
	*
	*
	*
	*
	*/
	private static String readText() {
		try {
			return new BufferedReader(new InputStreamReader(System.in)).readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	/**
	* 
	* Diese Methode liest Zahlen eine und gibt diese dann zurück
	*
	* @return integers
	*
	*
	*
	*/
	private static int readInt() {
		try {
			return Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
	
	
	
	
	
	
	
}