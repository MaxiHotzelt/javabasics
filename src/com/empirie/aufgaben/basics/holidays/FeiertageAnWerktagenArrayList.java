package com.empirie.aufgaben.basics.holidays;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 
 * @author hotzelm
 * Entählt alle Feiertage an Werktagen
 */
@SuppressWarnings("serial")
public class FeiertageAnWerktagenArrayList extends ArrayList<Feiertag> {
	
	public FeiertageAnWerktagenArrayList(FeiertagArrayList alleFeiertage) {
		feiertageAnWerktagenArrayListAnlegen(alleFeiertage);
	}
	
	private void feiertageAnWerktagenArrayListAnlegen(FeiertagArrayList alleFeiertage) {
		for (Feiertag feiertag : alleFeiertage) {
			if(feiertag.getDatum().get(GregorianCalendar.DAY_OF_WEEK) > 1 && feiertag.getDatum().get(GregorianCalendar.DAY_OF_WEEK) < 7) {
				this.add(feiertag);
			}
		}
	}
	
	public void feiertageAnWerktagenAusgeben() {
		java.text.SimpleDateFormat dateFormatYear = new java.text.SimpleDateFormat("yyyy");
		
		System.out.println(MessageFormat.format("\n--- Feiertage an Werktagen für das Jahr {0} ---", 
				dateFormatYear.format(this.get(0).getDatum().getTime())));
		
		for (Feiertag feiertag : this) {
			feiertag.tagAusgeben(false);
		}
	}

	public void feiertageAnWerktagenExportieren() {
		Scanner sc = new Scanner(System.in);
		String dateiName = System.getProperty("user.home") + "/Desktop/csv/";
		System.out.print("Gib den Dateinamen an: ");
		dateiName = dateiName.concat(sc.nextLine() + "feiertageAnWerktagen.csv");
		
		
		CSVUtils csvDatei = new CSVUtils(dateiName);
		
		
		java.text.SimpleDateFormat dateFormatYear = new java.text.SimpleDateFormat("yyyy");
		csvDatei.schreibeText(MessageFormat.format("--- Feiertage an Werktagen für das Jahr {0} ---", 
				dateFormatYear.format(this.get(0).getDatum().getTime())));
		for(int i = 0; i < this.size(); i++) {
			csvDatei.schreibeText(this.get(i).getCSVEintrag(false));
			
		}
		
		csvDatei.beendeCSV();
		csvDatei = null;
	}
	
	public void urlaubseffizienzAusgeben() {
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd.MM.yyyy");
		java.text.SimpleDateFormat dateFormatDay = new java.text.SimpleDateFormat("EEEE");
		
		for(int i = 0; i <= 52; i++) {
			boolean isUebrschriftAusgegeben = false;
				boolean isKalenderwocheGefunden = false;
				int anzahlFeiertage = 2;
				ArrayList<Integer> kws = new ArrayList<Integer>();
			
			for(int j = 0; j < this.size(); j++) {
				if(this.get(j).getKalenderwoche() == i) {
					isKalenderwocheGefunden = true;
					anzahlFeiertage++;
					kws.add(j);
					if(!isUebrschriftAusgegeben) {
						System.out.println(MessageFormat.format("\n\n------- Kalenderwoche {0} -------",
								this.get(j).getKalenderwoche()));
						isUebrschriftAusgegeben = true;
					}
				}
			}
			
			if(isKalenderwocheGefunden) {
				System.out.println(MessageFormat.format("\nArbeitstage		: {0}"
					+ "\nFreie Tage		: {1}"
					+ "\nUrlaubseffizienz	: {2}%", 
					7 - anzahlFeiertage, anzahlFeiertage, (int)Math.round((100/7)*anzahlFeiertage)));
				System.out.println("\nFeiertage:");
				for (Integer feiertag : kws) {
					this.get(feiertag);
					System.out.println(MessageFormat.format(
							  "\nName		: {0}"
							+ "\nDatum		: {1}"
							+ "\nWochentag	: {2}",
							this.get(feiertag).getName(), 
							dateFormat.format(this.get(feiertag).getDatum().getTime()), 
							dateFormatDay.format(this.get(feiertag).getDatum().getTime())
							));
					System.out.print("Bundesland	: ");
					
					for(int l = 0; l < this.get(feiertag).getBundeslaender().size(); l++) {
						if(l+1 == this.get(feiertag).getBundeslaender().size()) {
							System.out.println(this.get(feiertag).getBundeslaender().get(l));
						} else {
							System.out.print(this.get(feiertag).getBundeslaender().get(l) + ", ");
						}
						
					}
				}
			}
		}
	}
	
	public void urlaubseffizienzExportieren() {
		
	}
	

}
