package com.empirie.aufgaben.basics.schleifen.rot13;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Rot13 {

	private String text;
	private int verschiebenUm = 13;
	private char[] alphabet = 	  {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	private char[] alphabetKlein = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	
	
	private	String textVerschluesselt = "";
	private	String textEntschluesselt = "";
	
	public Rot13 (){
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void setVerschiebenUm(int zahl) {
		this.verschiebenUm = zahl;
	}
	
	
	public String textVerschluesseln(){
		
		//einzelne Buchstaben in array pushen
		char[] textArray = this.text.toCharArray();
		
		//durchläuft alle buchstaben des textes
		for(int i = 0; i < textArray.length; i++) {
			//durchläuft das alphabet
			for(int j = 0; j < alphabet.length; j++) {
				//wenn char ein Großbuchstabe ist
				if(textArray[i] == alphabet[j]) {
					if(j + verschiebenUm > alphabet.length-1) {
						textVerschluesselt += Character.toString(alphabet[(j + verschiebenUm) - alphabet.length]);
					} else {
						textVerschluesselt += Character.toString(alphabet[j + verschiebenUm] );
					}
				} 
				//wenn char ein Kleinbuchstabe ist
				else if(textArray[i] == alphabetKlein[j]) {
					if(j + verschiebenUm > alphabet.length-1) {
						textVerschluesselt += Character.toString(alphabetKlein[(j + verschiebenUm) - alphabet.length]);
					} else {
						textVerschluesselt += Character.toString(alphabetKlein[j + verschiebenUm]);
					}
				} 
				//wenn char ein Leerzeichen ist
				else if(textArray[i] == ' '){
					textVerschluesselt += " ";
					break;
				}
			}
		}
			
			return textVerschluesselt;
	}
	
	
	public String textEntschluesseln(){
		
		//einzelne Buchstaben in array pushen
		char[] textArray = this.textVerschluesselt.toCharArray();
		
		//durchläuft alle buchstaben des textes
		for(int i = 0; i < textArray.length; i++) {
			//durchläuft das alphabet
			for(int j = 0; j < alphabet.length; j++) {
				
				
				//wenn char ein Großbuchstabe ist
				if(textArray[i] == alphabet[j]) {
					if(j - verschiebenUm < 0) {
						textEntschluesselt += Character.toString(alphabet[alphabet.length + (j - verschiebenUm)]);
					} else {
						textEntschluesselt += Character.toString(alphabet[j - verschiebenUm] );
					}
				} 
				//wenn char ein Kleinbuchstabe ist
				else if(textArray[i] == alphabetKlein[j]) {
					if(j - verschiebenUm < 0) {
						textEntschluesselt += Character.toString(alphabetKlein[alphabet.length + (j - verschiebenUm)]);
					} else {
						textEntschluesselt += Character.toString(alphabetKlein[j - verschiebenUm]);
					}
				} 
				//wenn char ein Leerzeichen ist
				else if(textArray[i] == ' '){
					textEntschluesselt += " ";
					break;
				}
								
								
			}
		}
			
			return textEntschluesselt;
	}

}



















