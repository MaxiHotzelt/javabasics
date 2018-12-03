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