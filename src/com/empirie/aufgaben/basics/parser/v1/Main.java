package com.empirie.aufgaben.basics.parser.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main (String[] args) {
		System.out.print("Berechnung: ");
		String rechnung = readText();
		Taschenrechner rechner = new Taschenrechner(rechnung);
		
		System.out.println(rechner.getErgebnis());
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
}
