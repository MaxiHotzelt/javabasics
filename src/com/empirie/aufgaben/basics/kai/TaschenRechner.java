package com.empirie.aufgaben.basics.kai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaschenRechner{

	public static void main(String[] args) {
		boolean weiter = true;
		System.out.println("Herzlich Willkommen bei deinen Taschrechner bitte gib 2 Zahlen ein: ");
		do {
			System.out.print("Zahl 1:");
			double Zahl1 = readInt();
			System.out.print("Bitte gib den Operator ein:");
//String operator =  operator;// dein aktueller Operator an Stelle X 
			char operator = readText().charAt(0);
			
//Prüfung des Operators
			if( operator == '+' || operator == '-' || operator == '*' || operator == '/' ) { 
				
				System.out.print("Zahl 2:");
				double Zahl2 = readInt();

//Testen des Operators 
				switch (operator) {
					case '+' :
						System.out.println(Zahl1 + Zahl2);
					break;
					case '-' :
						System.out.println(Zahl1 - Zahl2);
					break;
					case '*' :
						System.out.println(Zahl1 * Zahl2);
					break;
					case '/' :
						System.out.println(Zahl1 / Zahl2);
					break;
					default:
						System.out.println("Fehlerhafte Eingabe");
					}
//Abfrage zum beenden
					System.out.println("Wollen Sie noch einmal Berechnen? y/n");
					String neu = readText();
					if (neu.equals("n")) {
						weiter = false;
					} 
			}		
			else{
				System.out.println("Error! Falscher Operator!");
			}		
				
		}while(weiter==true);

	}
	
	private static String readText() {
		try {
			return new BufferedReader(new InputStreamReader(System.in)).readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	
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