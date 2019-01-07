package com.empirie.aufgaben.basics.holidays;

import java.util.Scanner;

public class Feiertagsverwaltung {
	
	private int option = 1;
	private int jahr;
	private FeiertagArrayList feiertage;
	private FeiertageAnWerktagenArrayList feiertageAnWerktagen;
	private Scanner sc = new Scanner(System.in);
	private String dateiAlsCSVExportieren = "n";
	
	public static void main(String[] args) {
		
		
		new Feiertagsverwaltung().hauptmenu();
		//test();

	}
	
	private void hauptmenu()  {
		
		
		while(option != 4) {
			System.out.print("\n\n-------- Feiertage -------- \n"
					+ "-------- Hauptmenü --------\n\n"
					+ "<1>: Feiertage ausgeben \n"
					+ "<2>: Feiertage an Werktagen ausgeben \n"
					+ "<3>: Urlaubseffizienz ausgeben \n"
					+ "<4>: Programm beenden \n\n"
					+ "Wähle eine Option: ");
				
			
				option = Integer.parseInt(sc.nextLine());
			
			
			switch(option) {
				case 1:
					System.out.println("\n\n----- Feiertage ausgeben -----\n\n"
							+ "Welches Jahr soll ausgegeben werden?");
					setUserEingaben();
					if(dateiAlsCSVExportieren.equals("y")) {
						feiertage.feiertageExportieren();
					}
					feiertage.feiertageAusgeben();
					
					break;
				case 2:
					System.out.println("\n\n----- Feiertage an Werktagen ausgeben -----\n\n"
							+ "Welches Jahr soll ausgegeben werden?");
					setUserEingaben();
					feiertageAnWerktagen = new FeiertageAnWerktagenArrayList(feiertage);
					if(dateiAlsCSVExportieren.equals("y")) {
						feiertageAnWerktagen.feiertageAnWerktagenExportieren();
					}
					feiertageAnWerktagen.feiertageAnWerktagenAusgeben();
					
					
					break;
				case 3:
					System.out.println("\n\n----- Urlaubseffizienz ausgeben -----\n\n"
							+ "Welches Jahr soll ausgegeben werden?");
					setUserEingaben();
					feiertageAnWerktagen = new FeiertageAnWerktagenArrayList(feiertage);
					if(dateiAlsCSVExportieren.equals("y")) {
						
					}
					feiertageAnWerktagen.urlaubseffizienzAusgeben();
					
					break;
				case 4:
					break;
				default:
					break;
			}
			
		}
		
		sc.close();
	}
	
	private void setUserEingaben() {
		System.out.print("Auswahl: ");
		jahr = Integer.parseInt(sc.nextLine());
		
		System.out.println("\nDatei als CSV exportieren? (y/n)");
		System.out.print("Auswahl: ");		
		dateiAlsCSVExportieren = sc.nextLine();
		
		feiertage = new FeiertagArrayList(jahr);
	}
}
