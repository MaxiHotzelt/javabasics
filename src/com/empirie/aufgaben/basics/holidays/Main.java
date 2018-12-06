package com.empirie.aufgaben.basics.holidays;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		hauptmenu();
		//test();

		
	}
	
	private static void hauptmenu() {
		Scanner sc = new Scanner(System.in);
		ListeAllerFeiertage feiertage;
		ListeAllerBrueckentage brueckentage;
		int option = 1; 
		int jahr;
		
		
		while(option != 4) {
			System.out.print("\n\n----- Feier- und Brückentage ----- \n"
					+ "----------- Hauptmenü ----------\n\n"
					+ "<1>: Feiertage ausgeben \n"
					+ "<2>: Brückentage ausgeben \n"
					+ "<3>: Urlaubseffizienz ausgeben \n"
					+ "<4>: Programm beenden \n\n"
					+ "Wähle eine Option: ");
			
			
			option = sc.nextInt();
			
			switch(option) {
				case 1:
					System.out.print("\n\n----- Feiertage ausgeben -----\n\n"
							+ "Wähle ein Jahr: ");
					jahr = sc.nextInt();
					feiertage = new ListeAllerFeiertage(jahr);
					feiertage.feiertageAusgeben();
					
					feiertage = null;
					break;
				case 2:
					System.out.print("\n\n----- Brückentage ausgeben -----\n\n"
							+ "Wähle ein Jahr: ");
					jahr = sc.nextInt();
					feiertage = new ListeAllerFeiertage(jahr);
					brueckentage = new ListeAllerBrueckentage(feiertage);
					brueckentage.brueckentageAusgeben();
					
					brueckentage = null;
					break;
				case 3:
					System.out.print("\n\n----- Urlaubseffizienz ausgeben -----\n\n"
							+ "Wähle ein Jahr: ");
					jahr = sc.nextInt();
					feiertage = new ListeAllerFeiertage(jahr);
					brueckentage = new ListeAllerBrueckentage(feiertage);
					ListeAllerKalenderwochenMitBrueckentagen brueckentagsKWListe = new ListeAllerKalenderwochenMitBrueckentagen(brueckentage.getAlleBrueckentage());
					brueckentagsKWListe.listeAllerKalenderwochenMitBrueckentagenAusgeben();
					
					brueckentagsKWListe = null;
					break;
				case 4:
					break;
				default:
					break;
			}
			
		}
		
		sc.close();
	}
	
	private static void test() {
		ListeAllerFeiertage feiertage2018 = new ListeAllerFeiertage(2018);
		feiertage2018.feiertageAusgeben();
		
		ListeAllerBrueckentage brueckentage2018 = new ListeAllerBrueckentage(feiertage2018);
		brueckentage2018.brueckentageAusgeben();
		ListeAllerKalenderwochenMitBrueckentagen brueckentagsKWListe = new ListeAllerKalenderwochenMitBrueckentagen(brueckentage2018.getAlleBrueckentage());
		brueckentagsKWListe.listeAllerKalenderwochenMitBrueckentagenAusgeben();;
	}
}
