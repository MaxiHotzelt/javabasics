package com.empirie.aufgaben.basics.holidays;

import java.util.Scanner;

public class Holidays {
	
	public static void main(String[] args) {
		
		
		new Holidays().hauptmenu();
		//test();

	}
	
	private void hauptmenu()  {
		Scanner sc = new Scanner(System.in);
		HolidayArrayList feiertage;
		ListeAllerBrueckentage brueckentage;
		int option = 1; 
		int jahr;
		
		
		while(option != 4) {
			String dateiAlsCSVExportieren = "n";
			System.out.print("\n\n----- Feier- und Brückentage ----- \n"
					+ "----------- Hauptmenü ----------\n\n"
					+ "<1>: Feiertage ausgeben \n"
					+ "<2>: Brückentage ausgeben \n"
					+ "<3>: Urlaubseffizienz ausgeben \n"
					+ "<4>: Programm beenden \n\n"
					+ "Wähle eine Option: ");
				
			
				option = Integer.parseInt(sc.nextLine());
			
			
			switch(option) {
				case 1:
					System.out.print("\n\n----- Feiertage ausgeben -----\n\n"
							+ "Wähle ein Jahr: ");
					jahr = Integer.parseInt(sc.nextLine());
					
					System.out.println("\nDatei als CSV exportieren? (y/n)");
					System.out.print("\nAuswahl: ");		
					dateiAlsCSVExportieren = sc.nextLine();
					
					feiertage = new HolidayArrayList(jahr);
					if(dateiAlsCSVExportieren.equals("y")) {
						feiertage.feiertageExportieren();
					}
					feiertage.feiertageAusgeben();
					
					break;
				case 2:
					System.out.print("\n\n----- Brückentage ausgeben -----\n\n"
							+ "Wähle ein Jahr: ");
					jahr = Integer.parseInt(sc.nextLine());
					
					System.out.println("\nDatei als CSV exportieren? (y/n)");
					System.out.print("\nAuswahl: ");		
					dateiAlsCSVExportieren = sc.nextLine();
					feiertage = new HolidayArrayList(jahr);
					brueckentage = new ListeAllerBrueckentage(feiertage);
					if(dateiAlsCSVExportieren.equals("y")) {
						brueckentage.brueckentageExportieren();
					}
					
					brueckentage.brueckentageAusgeben();
					
					break;
				case 3:
					System.out.print("\n\n----- Urlaubseffizienz ausgeben -----\n\n"
							+ "Wähle ein Jahr: ");
					jahr = Integer.parseInt(sc.nextLine());
					
					System.out.println("\nDatei als CSV exportieren? (y/n)");
					System.out.print("\nAuswahl: ");		
					dateiAlsCSVExportieren = sc.nextLine();
					
					feiertage = new HolidayArrayList(jahr);
					brueckentage = new ListeAllerBrueckentage(feiertage);
					ListeAllerKalenderwochenMitBrueckentagen brueckentagsKWListe = new ListeAllerKalenderwochenMitBrueckentagen(brueckentage.getAlleBrueckentage());
					if(dateiAlsCSVExportieren.equals("y")) {
						brueckentagsKWListe.listeAllerKalenderwochenMitBrueckentagenExportieren();
					}
					
					brueckentagsKWListe.listeAllerKalenderwochenMitBrueckentagenAusgeben();
					
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
		HolidayArrayList feiertage2018 = new HolidayArrayList(2018);
		feiertage2018.feiertageAusgeben();
		
		ListeAllerBrueckentage brueckentage2018 = new ListeAllerBrueckentage(feiertage2018);
		brueckentage2018.brueckentageAusgeben();
		ListeAllerKalenderwochenMitBrueckentagen brueckentagsKWListe = new ListeAllerKalenderwochenMitBrueckentagen(brueckentage2018.getAlleBrueckentage());
		brueckentagsKWListe.listeAllerKalenderwochenMitBrueckentagenAusgeben();;
	}
}
