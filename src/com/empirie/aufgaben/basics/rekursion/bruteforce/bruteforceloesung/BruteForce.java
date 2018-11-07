package com.empirie.aufgaben.basics.rekursion.bruteforce.bruteforceloesung;



public class BruteForce {
	
	StringBuffer hackedPw  = new StringBuffer();
	private String passwort = "";
	private boolean foundPw = false;
	
	
	public BruteForce(String passwort, int length) {
		this.passwort = passwort;
		this.hackedPw.setLength(length);
	}
	
	
	
	private int versuche = 0;
	
	//usable chars
	private char[] viableChars1 =	{ 	
								'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 
								'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
							};
							
							
	private char[] viableChars2 =	{'a', 'b', 'c'};
	
	private char[] viableChars =	"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
	
	
	
	
	/**
	*	idx - gibt an, an welcher Stelle gerade Buchstaben verändert werden
	*	schleifenToGo - sagt jeder Schleife, wie oft die Methode noch aufgerufen werden muss
	*/
	public void bruteForce(int idx, int schleifenToGo) {
		
		
		for(int i = 0; i < viableChars.length; i++) {
			//stops execution, if pw is found
			if(foundPw == true) return;
			
			
			versuche++;
			hackedPw.setCharAt(idx, viableChars[i]);
			//System.out.println(hackedPw);
			
			
			
			//prüft hackedPw mit richtigem Pw und gibt dieses aus, falls gefunden
			if(hackedPw.toString().trim().equals(passwort)) {
				System.out.println("Gefunden! - PW lautet: " + hackedPw + "\nGebrauchte Versuche: " + versuche);
				foundPw = true;
			}
			
			//ruft sich anhand der gebrauchten Schleifen selbst wieder auf
			if(schleifenToGo != 0) {
				bruteForce(idx+1, schleifenToGo - 1);
			}
		}
		
		
    }
	
	

		
	
	
	
	
}