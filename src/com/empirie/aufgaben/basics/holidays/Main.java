package com.empirie.aufgaben.basics.holidays;

import java.util.Scanner;

public class Main {
	
	
	
	public static void main(String[] args) {
		
		hauptmenu();
		
//		Feiertagsliste feiertage2018 = new Feiertagsliste(2018);
//		feiertage2018.feiertageAusgeben();
//		
//		Brueckentagsliste brueckentage2018 = new Brueckentagsliste(feiertage2018);
//		brueckentage2018.brueckentageAusgeben();
		
	}
	
	public static void hauptmenu() {
		Scanner sc = new Scanner(System.in);
		Feiertagsliste feiertage;
		int option = 1; 
		int jahr;
		
		
		while(option != 3) {
			System.out.print("\n\n----- Feier- und Brückentage ----- \n"
					+ "----------- Hauptmenü ----------\n\n"
					+ "<1>: Feiertage ausgeben \n"
					+ "<2>: Brückentage ausgeben \n"
					+ "<3>: Programm beenden \n\n"
					+ "Wähle eine Option: ");
			
			
			option = sc.nextInt();
			
			switch(option) {
				case 1:
					System.out.print("\n\n----- Feiertage ausgeben -----\n\n"
							+ "Wähle ein Jahr: ");
					jahr = sc.nextInt();
					feiertage = new Feiertagsliste(jahr);
					feiertage.feiertageAusgeben();
					
					feiertage = null;
					break;
				case 2:
					System.out.print("\n\n----- Brückentage ausgeben -----\n\n"
							+ "Wähle ein Jahr: ");
					jahr = sc.nextInt();
					feiertage = new Feiertagsliste(jahr);
					Brueckentagsliste brueckentage = new Brueckentagsliste(feiertage);
					brueckentage.brueckentageAusgeben();
					
					brueckentage = null;
					break;
				case 3:
					break;
				default:
					break;
			}
			
		}
		
		sc.close();
	}
	
}
