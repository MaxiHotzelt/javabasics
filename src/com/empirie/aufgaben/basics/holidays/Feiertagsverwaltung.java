package com.empirie.aufgaben.basics.holidays;

import java.util.Scanner;

public class Feiertagsverwaltung {
	
	public static void main(String[] args) {
		
		
		new Feiertagsverwaltung().hauptmenu();
		//test();

	}
	
	private void hauptmenu()  {
		Scanner sc = new Scanner(System.in);
		FeiertagArrayList feiertage;
		BrueckentageArrayList brueckentage;
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
					
					feiertage = new FeiertagArrayList(jahr);
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
					feiertage = new FeiertagArrayList(jahr);
					brueckentage = new BrueckentageArrayList(feiertage);
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
					
					feiertage = new FeiertagArrayList(jahr);
					brueckentage = new BrueckentageArrayList(feiertage);
					KWsMitBrueckentagenArrayList brueckentagsKWListe = new KWsMitBrueckentagenArrayList(brueckentage);
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
	
	@SuppressWarnings("unused")
	private static void test() {
		FeiertagArrayList feiertage2018 = new FeiertagArrayList(2018);
		feiertage2018.feiertageAusgeben();
		
		BrueckentageArrayList brueckentage2018 = new BrueckentageArrayList(feiertage2018);
		brueckentage2018.brueckentageAusgeben();
		KWsMitBrueckentagenArrayList brueckentagsKWListe = new KWsMitBrueckentagenArrayList(brueckentage2018);
		brueckentagsKWListe.listeAllerKalenderwochenMitBrueckentagenAusgeben();;
	}
}
