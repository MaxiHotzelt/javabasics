package com.empirie.aufgaben.basics.rekursion.bruteforce.bruteforceloesung;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		int length = 100;
		long startTime = 0; 
		long endTime = 0; 
		double gesamtZeit = 0;
		
		String passwort = "";
		
		System.out.print("Gib das zu suchende PW ein: ");
		passwort = readText();
		
		BruteForce bF = new BruteForce(passwort, length);
		
		
		
		startTime = System.currentTimeMillis();
		for(int i = 0; i < length; i++) {
			bF.bruteForce(0, i);
		}
		endTime = System.currentTimeMillis();
		gesamtZeit = (double)(endTime - startTime) / 1000;
		System.out.println("Gebrauchte Zeit: " + gesamtZeit + " sek.");
	
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