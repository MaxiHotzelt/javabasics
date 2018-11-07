package com.empirie.aufgaben.basics.schleifen.rot13;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

	public static void main (String[] args) {
		
		boolean again = true;
		Rot13 rot13 = new Rot13();
		
		int verschiebenUm = 0;
		String text = "";
		String nochmal = "";
		
		while(again) {
			//eingaben
			System.out.print("Gebe den zu verschluesselnden Text ein: ");
			text = readText();
			System.out.print("\nGebe an, um wie viele Stellen dein Text verschoben werden soll: ");
			verschiebenUm = readInt();
			
			
			rot13.setVerschiebenUm(verschiebenUm);
			rot13.setText(text);
			System.out.println(rot13.textVerschluesseln());
			System.out.println(rot13.textEntschluesseln());
			
			System.out.print("\nNeuen Text verschluesseln? (y/n): ");
			nochmal = readText();
			
			again = (nochmal.equals("y")) ? true : false;
			
		}
		
		
		/*
		rot13.setVerschiebenUm(2);
		rot13.setText("Hello my name is Max");
		System.out.println(rot13.textVerschluesseln());
		System.out.println(rot13.textEntschluesseln());
		*/
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