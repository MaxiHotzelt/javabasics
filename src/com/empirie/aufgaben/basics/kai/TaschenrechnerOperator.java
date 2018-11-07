package com.empirie.aufgaben.basics.kai;

public class TaschenrechnerOperator {
	
	//Prüft ob Eingabe richtige Anzahl an Klammern hat
	public void isValid(String aufgabe) {
		aufgabe = aufgabe.replaceAll(" ", "");
 		int counter = 0;
		char[] isValidArray = aufgabe.toCharArray();
		for(int i=0;i<isValidArray.length;i++) {
			if(isValidArray[i] == '(') {
				counter++;
			}else if(isValidArray[i] == ')'){
				counter--;
			}
		}if(counter == 0) {                         
			
			System.out.print(aufgabe);
			aufgabe = setMultiplyPoint(aufgabe);
			System.out.print(" = ");
			System.out.println(new TaschenrechnerOperator().ausklammern(aufgabe));
		}else {
			System.out.println("Fehler bei Ihrer Eingabe! Bitte Ueberpruefen!: "+ aufgabe);
		}
	}
	
	//Sucht Klammernpaare heraus und gibt diese an istOperator weiter
	public String ausklammern(String aufgabe){
		if(aufgabe.contains("(")||aufgabe.contains("+")||aufgabe.contains("-")||aufgabe.contains("*")||aufgabe.contains("/")){
			if(aufgabe.contains("(")) {													
				int anfangKlammer = aufgabe.lastIndexOf('(');															// letzte (
				int endeKlammer = aufgabe.indexOf(")", anfangKlammer);													// erste )
				String vorKlammer = aufgabe.substring(0, anfangKlammer);												// alles vor letzter (
				String inKlammer = aufgabe.substring(anfangKlammer+1, endeKlammer);										// inhalt der Klammer
				String nachKlammer = aufgabe.substring(endeKlammer+1, aufgabe.length());								// alles nach erster ) 
				if(inKlammer.contains("/")||inKlammer.contains("*")||inKlammer.contains("-")||inKlammer.contains("+")
						&&inKlammer.charAt(0)!='-') {
 					return ausklammern(aufgabe=vorKlammer+ausklammern(istOperator(inKlammer))+nachKlammer);
				}
	 			return ausklammern(vorKlammer+istOperator(inKlammer)+nachKlammer);
			}else if(aufgabe.contains("/")||aufgabe.contains("*")||aufgabe.contains("-")||aufgabe.contains("+")) {
				if(aufgabe.charAt(0)=='-'){
					for(int i=1;i<aufgabe.length();i++) {
						int temp = aufgabe.charAt(i);
						if(temp==42||
						   temp==47||
						   temp==43||
						   temp==45) {
							return ausklammern(istOperator(aufgabe));
						}
					}
					return aufgabe;
				}
				return ausklammern(istOperator(aufgabe));	
			}else {
				return aufgabe;
			}
		}
		return aufgabe;
	}
	
	//Setzt * wenn vor einer ( kein Operator steht 
	public String setMultiplyPoint(String aufgabe) {
		for(int i= 1;i<aufgabe.length();i++) {
			int temp = aufgabe.charAt(i);
			if(temp==40) {
				char zuPruefen = aufgabe.charAt(i-1);
				if(zuPruefen != '+'&&
				   zuPruefen != '-'&&
				   zuPruefen != '*'&&
				   zuPruefen != '/'&&
				   zuPruefen != '('&&
				   zuPruefen != ')'  ){
					String vor = aufgabe.substring(0, i);		
					String nach = aufgabe.substring(i, aufgabe.length());
					return setMultiplyPoint(aufgabe = vor+"*"+nach);
					
				}
			}
		}
		return aufgabe;
	}
	
	//Durchsucht nach Operatoren
	public String istOperator(String aufgabe) {
		if(aufgabe.contains("*")||aufgabe.contains("/")) {
			for(int i=1;i<aufgabe.length();i++) {
				int temp = aufgabe.charAt(i);
				if(temp==42) {																						// *-Operator
					aufgabe = wirdBerechnet(aufgabe,"*",i);
					return aufgabe;
				}else if(temp==47){																					// /-Operator
					aufgabe = wirdBerechnet(aufgabe,"/",i);
					return aufgabe;
				}
			}
		}else if(aufgabe.contains("+")||aufgabe.contains("-")) {
			for(int i=1;i<aufgabe.length();i++) {
				int temp = aufgabe.charAt(i);
				if(temp==43) {																						// +-Operator
					aufgabe = wirdBerechnet(aufgabe,"+",i);
					return aufgabe;
				}else if(temp==45){																					// --Operator
					aufgabe = wirdBerechnet(aufgabe,"-",i);
					return aufgabe;
				}
			}
		}
		return aufgabe;
	}

	//Extrahiert die linke Zahl von Operator 
	public String linkeZahl(String aufgabe, int istOperator) {
		String links = aufgabe.substring(0, istOperator);
		for(int i=links.length()-1;i>0;i--) {
			int temp = links.charAt(i);
			if(temp==42||temp==45||temp==43||temp==47) {
				int vorOperator = aufgabe.charAt(i-1);
				if(vorOperator==42||vorOperator==45||vorOperator==43||vorOperator==47) {
					return links = links.substring(i, links.length());
				}else {
					return links = links.substring(i+1, links.length());
				}
			}
		}
		return links;
	}
		
	
	//Extrahiert die rechte Zahl von Operator
	public String rechteZahl(String aufgabe, int istOperator) {
		String rechts = aufgabe.substring(istOperator+1, aufgabe.length());
		for(int a = 1;a<rechts.length();a++) {
			int zahlenStart = rechts.charAt(a);
			if(zahlenStart==42||zahlenStart==47||zahlenStart==43||zahlenStart==45) {
				rechts = rechts.substring(0, a);
				return rechts;
			}
		}
		return rechts;
	}

	//Berechnet linke mit rechter Zahl und fügt Summe in Aufgabe ein 
	public String wirdBerechnet(String aufgabe, String operator, int indexOperator) {
		double summe;
		double linkeZahl = Double.parseDouble(linkeZahl(aufgabe,indexOperator));									// -> linke zahl  
		double rechteZahl = Double.parseDouble(rechteZahl(aufgabe,indexOperator));									// -> rechte zahl 
		switch(operator) {
		case "*":
			summe = linkeZahl*rechteZahl;
			break;
		case "/":
			summe = linkeZahl/rechteZahl;
			break;
		case "+":
			summe = linkeZahl+rechteZahl;
			break;
		case "-":
			summe = linkeZahl-rechteZahl;
			break;
		default: 
			return aufgabe;
		} 
		//zuschneiden des Strings - einsetzen des Ergebnis
		String summeString = Double.toString(summe);
		String zahlLinks = linkeZahl(aufgabe,indexOperator);
		String zahlRechts = rechteZahl(aufgabe,indexOperator);
		int laengeLinks = zahlLinks.length();
		int laengeRechts = zahlRechts.length();
		String teilLinks = aufgabe.substring(0, indexOperator-(laengeLinks));
		String teilRechts = aufgabe.substring(indexOperator+(laengeRechts+1));
		aufgabe = teilLinks + summeString + teilRechts;
		return aufgabe;		
	}
}