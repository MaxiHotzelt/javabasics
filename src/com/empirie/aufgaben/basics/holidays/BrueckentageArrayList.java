package com.empirie.aufgaben.basics.holidays;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 * 
 * @author hotzelm
 * Entählt alle Brückentage
 */
@SuppressWarnings("serial")
public class BrueckentageArrayList extends ArrayList<Brueckentag> {
	
	
	public BrueckentageArrayList(FeiertagArrayList alleFeiertage) {
		brueckentagslisteAnlegen(alleFeiertage);
	}
	
	
	private void brueckentagslisteAnlegen(FeiertagArrayList alleFeiertage) {
		for (Feiertag feiertag : alleFeiertage) {
			if(feiertag.getDatum().get(Calendar.DAY_OF_WEEK) > 1 && feiertag.getDatum().get(Calendar.DAY_OF_WEEK) < 7) {
				this.add(new Brueckentag(feiertag));
			}
		}
	}
	
	public void brueckentageAusgeben() {
		java.text.SimpleDateFormat dateFormatYear = new java.text.SimpleDateFormat("yyyy");
		
		System.out.println(MessageFormat.format("\n--- Brückentage für das Jahr {0} ---", 
				dateFormatYear.format(this.get(0).getDatum().getTime())));
		
		
		for (Brueckentag brueckentag : this) {
			brueckentag.tagAusgeben();
		}
	}
	
	public void brueckentageExportieren()  {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String dateiName = System.getProperty("user.home") + "/Desktop/csv/";
		System.out.print("Gib den Dateinamen an: ");
		dateiName = dateiName.concat(sc.nextLine() + "brueckentage.csv");
		
		
		CSVUtils csvDatei = new CSVUtils(dateiName);
		
		
		java.text.SimpleDateFormat dateFormatYear = new java.text.SimpleDateFormat("yyyy");
		csvDatei.schreibeText(MessageFormat.format("--- Brückentage für das Jahr {0} ---", 
						dateFormatYear.format(this.get(0).getDatum().getTime())));
		for(int i = 0; i < this.size(); i++) {
			csvDatei.schreibeText(this.get(i).getCsvEintrag());
			
		}
		
		csvDatei.beendeCSV();
		csvDatei = null;
	}

}
