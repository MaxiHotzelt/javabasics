package com.empirie.aufgaben.basics.holidays;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 
 * @author hotzelm
 * Liste, welche alle Feiertage bei Initialisierung bereits enthält
 */
@SuppressWarnings("serial")
public class FeiertagArrayList extends ArrayList<Feiertag> {


	public FeiertagArrayList(int jahr) {
		feiertagslisteAnlegen(jahr);
	}
	

	
	private void feiertagslisteAnlegen(int jahr) {
		GregorianCalendar gruendonnerstag = new GregorianCalendar();
		GregorianCalendar karfreitag = new GregorianCalendar();
		GregorianCalendar ostersonntag = new GregorianCalendar();
		GregorianCalendar ostermontag = new GregorianCalendar();
		GregorianCalendar christiHimmelfahrt = new GregorianCalendar();
		GregorianCalendar pfingstsonntag = new GregorianCalendar();
		GregorianCalendar pfingstmontag = new GregorianCalendar();
		GregorianCalendar fronleichnam = new GregorianCalendar();
		GregorianCalendar bussUndBettag = new GregorianCalendar();
		
		ostersonntag = osterdatumBerechnen(jahr);
		
		gruendonnerstag.setTime(ostersonntag.getTime());
		gruendonnerstag.add(Calendar.DATE, -3);
		
		karfreitag.setTime(ostersonntag.getTime());
		karfreitag.add(Calendar.DATE, -2);
		
		ostermontag.setTime(ostersonntag.getTime());
		ostermontag.add(Calendar.DATE, 1);
	    
		christiHimmelfahrt.setTime(ostersonntag.getTime());
		christiHimmelfahrt.add(Calendar.DATE, 39);
		
		pfingstsonntag.setTime(ostersonntag.getTime());
		pfingstsonntag.add(Calendar.DATE, 49);
		
		pfingstmontag.setTime(ostersonntag.getTime());
		pfingstmontag.add(Calendar.DATE, 50);
		
		fronleichnam.setTime(ostersonntag.getTime());
		fronleichnam.add(Calendar.DATE, 60);

		bussUndBettag.set(jahr, 10, 23);
		if(bussUndBettag.get(Calendar.DAY_OF_WEEK) > 4) {
			bussUndBettag.set(Calendar.DAY_OF_WEEK, 4);
		} else {
			bussUndBettag.add(Calendar.WEEK_OF_YEAR, -1);
			bussUndBettag.set(Calendar.DAY_OF_WEEK, 4);
		}
		
		
		
		this.add(new Feiertag(1, 1, jahr,"Neujahrstag", new ArrayList<String>(Arrays.asList("Alle Bundesländer"))));
		this.add(new Feiertag(6, 1, jahr,"Heilige Drei Könige", new ArrayList<String>(Arrays.asList("Baden-Württemberg", "Bayern", "Sachsen-Anhalt"))));
		this.add(new Feiertag(gruendonnerstag,"Gründonnerstag", new ArrayList<String>(Arrays.asList("Baden-Württemberg (für Schüler)"))));
		this.add(new Feiertag(karfreitag,"Karfreitag", new ArrayList<String>(Arrays.asList("Alle Bundesländer"))));
		this.add(new Feiertag(ostersonntag,"Ostersonntag", new ArrayList<String>(Arrays.asList("Brandenburg"))));
		this.add(new Feiertag(ostermontag,"Ostermontag", new ArrayList<String>(Arrays.asList("Alle Bundesländer"))));
		this.add(new Feiertag(1, 5, jahr,"1. Mai / Tag der Arbeit", new ArrayList<String>(Arrays.asList("Alle Bundesländer"))));
		this.add(new Feiertag(christiHimmelfahrt,"Christi-Himmelfahrt", new ArrayList<String>(Arrays.asList("Alle Bundesländer"))));
		this.add(new Feiertag(pfingstsonntag,"Pfingstsonntag", new ArrayList<String>(Arrays.asList("Brandenburg"))));
		this.add(new Feiertag(pfingstmontag,"Pfingstmontag", new ArrayList<String>(Arrays.asList("Alle Bundesländer"))));
		this.add(new Feiertag(fronleichnam,"Fronleichnam", new ArrayList<String>(Arrays.asList("Baden-Württemberg", "Bayern", "Hessen", "Nordrhein-Westfahlen", "Rheinland-Pfalz", "Saarland"))));
		this.add(new Feiertag(8, 8, jahr,"Augsburger Hohes Fest", new ArrayList<String>(Arrays.asList("Bayern (nur in Augsburg)"))));
		this.add(new Feiertag(15, 8, jahr,"Mariä Himmelfahrt", new ArrayList<String>(Arrays.asList("Bayern (in katholischen Gemeinden)", "Saarland"))));
		this.add(new Feiertag(3, 10, jahr,"Tag der Deutschen Einheit", new ArrayList<String>(Arrays.asList("Alle Bundesländer"))));
		this.add(new Feiertag(31, 10, jahr,"Reformationstag", new ArrayList<String>(Arrays.asList("Brandenburg","Bremen", "Hamburg", "Mecklenburg-Vorpommern", "Niedersachsen", "Sachsen", "Sachsen-Anhalt", "Schleswig-Holstein", "Thüringen"))));
		this.add(new Feiertag(1, 11, jahr,"Allerheiligen", new ArrayList<String>(Arrays.asList("Baden-Württemberg", "Bayern", "Nordrhein-Westfalen", "Rheinland-Pfalz", "Saarland"))));
		this.add(new Feiertag(bussUndBettag,"Buß- und Bettag", new ArrayList<String>(Arrays.asList("Bayern (für Schüler)", "Sachsen"))));
		this.add(new Feiertag(25, 12, jahr,"1. Weihnachtstag", new ArrayList<String>(Arrays.asList("Alle Bundesländer"))));
		this.add(new Feiertag(26, 12, jahr,"2. Weihnachtstag", new ArrayList<String>(Arrays.asList("Alle Bundesländer"))));
	}
	
	private GregorianCalendar osterdatumBerechnen(int jahr) {
		int a = jahr % 19;
		int b = jahr / 100;
		int c = jahr % 100;
		int d = b / 4;
		int e = b % 4;
		int f = (b + 8) / 25;
		int g = (b - f + 1) / 3;
		int h = (19 * a + b - d - g + 15) % 30;
		int i = c / 4;
		int k = c % 4;
		int l = (32 + 2 * e + 2 * i - h - k) % 7;
		int m = (a + 11 * h + 22 * l) / 451;
		int n = (h + l - 7 * m + 114) / 31;
		int p = (h + l - 7 * m + 114) % 31;
		
		GregorianCalendar datum = new GregorianCalendar();
		datum.set(jahr, n - 1, p + 1);
		return datum;
	}
	
	public void feiertageAusgeben() {
		java.text.SimpleDateFormat dateFormatYear = new java.text.SimpleDateFormat("yyyy");
		
		System.out.println(MessageFormat.format("\n--- Feiertage für das Jahr {0} ---", 
				dateFormatYear.format(this.get(0).getDatum().getTime())));
		
		for(Feiertag feiertag : this) {
			feiertag.tagAusgeben();
		}
	}
	
	
	@SuppressWarnings("resource")
	public void feiertageExportieren() {
		Scanner sc = new Scanner(System.in);
		String dateiName = System.getProperty("user.home") + "/Desktop/csv/";
		System.out.print("Gib den Dateinamen an: ");
		dateiName = dateiName.concat(sc.nextLine() + "feiertage.csv");
		
		
		CSVUtils csvDatei = new CSVUtils(dateiName);
		
		java.text.SimpleDateFormat dateFormatYear = new java.text.SimpleDateFormat("yyyy");
		csvDatei.schreibeText(MessageFormat.format("--- Feiertage für das Jahr {0} ---", 
				dateFormatYear.format(this.get(0).getDatum().getTime())));
		
		for(int i = 0; i < this.size(); i++) {
			csvDatei.schreibeText(this.get(i).getCsvEintrag());
		}
		
		csvDatei.beendeCSV();	
		csvDatei = null;
	}
}
