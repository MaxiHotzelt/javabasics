package com.empirie.aufgaben.basics.holidays;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Feiertagsliste {
	
	private ArrayList<Feiertag> alleFeiertage = new ArrayList<Feiertag>();
	
	public Feiertagsliste(int jahr) {
		feiertagslisteAnlegen(jahr);
	}
	
	public ArrayList<Feiertag> getAlleFeiertage() {
		return alleFeiertage;
	}
	
	private void feiertagslisteAnlegen(int jahr) {
		GregorianCalendar _gruendonnerstag = new GregorianCalendar();
		GregorianCalendar _karfreitag = new GregorianCalendar();
		GregorianCalendar _ostersonntag = new GregorianCalendar();
		GregorianCalendar _ostermontag = new GregorianCalendar();
		GregorianCalendar _christiHimmelfahrt = new GregorianCalendar();
		GregorianCalendar _pfingstsonntag = new GregorianCalendar();
		GregorianCalendar _pfingstmontag = new GregorianCalendar();
		GregorianCalendar _fronleichnam = new GregorianCalendar();
		GregorianCalendar _bussUndBettag = new GregorianCalendar();
		
		_ostersonntag = berechneOsterdatum(jahr);
		
		_gruendonnerstag.setTime(_ostersonntag.getTime());
		_gruendonnerstag.add(Calendar.DATE, -3);
		
		_karfreitag.setTime(_ostersonntag.getTime());
		_karfreitag.add(Calendar.DATE, -2);
		
		_ostermontag.setTime(_ostersonntag.getTime());
		_ostermontag.add(Calendar.DATE, 1);
	    
		_christiHimmelfahrt.setTime(_ostersonntag.getTime());
		_christiHimmelfahrt.add(Calendar.DATE, 39);
		
		_pfingstsonntag.setTime(_ostersonntag.getTime());
		_pfingstsonntag.add(Calendar.DATE, 49);
		
		_pfingstmontag.setTime(_ostersonntag.getTime());
		_pfingstmontag.add(Calendar.DATE, 50);
		
		_fronleichnam.setTime(_ostersonntag.getTime());
		_fronleichnam.add(Calendar.DATE, 60);

		_bussUndBettag.set(jahr, 10, 23);
		if(_bussUndBettag.get(Calendar.DAY_OF_WEEK) > 4) {
			_bussUndBettag.set(Calendar.DAY_OF_WEEK, 4);
		} else {
			_bussUndBettag.add(Calendar.WEEK_OF_YEAR, -1);
			_bussUndBettag.set(Calendar.DAY_OF_WEEK, 4);
		}
		
		
		
		Feiertag neujahr = new Feiertag(1, 1, jahr,"Neujahrstag", new ArrayList<String>(Arrays.asList("Alle Bundesländer")));
		alleFeiertage.add(neujahr);
		Feiertag dreiKoenige = new Feiertag(6, 1, jahr,"Heilige Drei Könige", new ArrayList<String>(Arrays.asList("Baden-Württemberg", "Bayern", "Sachsen-Anhalt")));
		alleFeiertage.add(dreiKoenige);
		Feiertag gruendonnerstag = new Feiertag(_gruendonnerstag,"Gründonnerstag", new ArrayList<String>(Arrays.asList("Baden-Württemberg")));
		alleFeiertage.add(gruendonnerstag);
		Feiertag karfreitag = new Feiertag(_karfreitag,"Karfreitag", new ArrayList<String>(Arrays.asList("Alle Bundesländer")));
		alleFeiertage.add(karfreitag);
		Feiertag ostersonntag = new Feiertag(_ostersonntag,"Ostersonntag", new ArrayList<String>(Arrays.asList("Brandenburg")));
		alleFeiertage.add(ostersonntag);
		Feiertag ostermontag = new Feiertag(_ostermontag,"Ostermontag", new ArrayList<String>(Arrays.asList("Alle Bundesländer")));
		alleFeiertage.add(ostermontag);
		Feiertag ersterMai = new Feiertag(1, 5, jahr,"1. Mai / Tag der Arbeit", new ArrayList<String>(Arrays.asList("Alle Bundesländer")));
		alleFeiertage.add(ersterMai);
		Feiertag christiHimmelfahrt = new Feiertag(_christiHimmelfahrt,"Christi-Himmelfahrt", new ArrayList<String>(Arrays.asList("Alle Bundesländer")));
		alleFeiertage.add(christiHimmelfahrt);
		Feiertag pfingstsonntag = new Feiertag(_pfingstsonntag,"Pfingstsonntag", new ArrayList<String>(Arrays.asList("Brandenburg")));
		alleFeiertage.add(pfingstsonntag);
		Feiertag pfingstmontag = new Feiertag(_pfingstmontag,"Pfingstmontag", new ArrayList<String>(Arrays.asList("Alle Bundesländer")));
		alleFeiertage.add(pfingstmontag);
		Feiertag fronleichnam = new Feiertag(_fronleichnam,"Fronleichnam", new ArrayList<String>(Arrays.asList("Baden-Württemberg", "Bayern", "Hessen", "Nordrhein-Westfahlen", "Rheinland-Pfalz", "Saarland")));
		alleFeiertage.add(fronleichnam);
		Feiertag friedensfest = new Feiertag(8, 8, jahr,"Augsburger Hohes Fest", new ArrayList<String>(Arrays.asList("Bayern")));
		alleFeiertage.add(friedensfest);
		Feiertag mariaeHimmelfahrt = new Feiertag(15, 8, jahr,"Mariä Himmelfahrt", new ArrayList<String>(Arrays.asList("Bayern", "Saarland")));
		alleFeiertage.add(mariaeHimmelfahrt);
		Feiertag deutscheEinheit = new Feiertag(3, 10, jahr,"Tag der Deutschen Einheit", new ArrayList<String>(Arrays.asList("Alle Bundesländer")));
		alleFeiertage.add(deutscheEinheit);
		Feiertag reformation = new Feiertag(31, 10, jahr,"Reformationstag", new ArrayList<String>(Arrays.asList("Brandenburg","Bremen", "Hamburg", "Mecklenburg-Vorpommern", "Niedersachsen", "Sachsen", "Sachsen-Anhalt", "Schleswig-Holstein", "Thüringen")));
		alleFeiertage.add(reformation);
		Feiertag allerheiligen = new Feiertag(1, 11, jahr,"Allerheiligen", new ArrayList<String>(Arrays.asList("Baden-Württemberg", "Bayern", "Nordrhein-Westfalen", "Rheinland-Pfalz", "Saarland")));
		alleFeiertage.add(allerheiligen);
		Feiertag bussundbettag = new Feiertag(_bussUndBettag,"Buß- und Bettag", new ArrayList<String>(Arrays.asList("Sachsen")));
		alleFeiertage.add(bussundbettag);
		Feiertag ersterWeihnachtstag = new Feiertag(25, 12, jahr,"1. Weihnachtstag", new ArrayList<String>(Arrays.asList("Alle Bundesländer")));
		alleFeiertage.add(ersterWeihnachtstag);
		Feiertag zweiterWeihnachtstag = new Feiertag(26, 12, jahr,"2. Weihnachtstag", new ArrayList<String>(Arrays.asList("Alle Bundesländer")));
		alleFeiertage.add(zweiterWeihnachtstag);
	}
	
	private GregorianCalendar berechneOsterdatum(int jahr) {
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
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd.MM.yyyy");
		java.text.SimpleDateFormat dateFormatYear = new java.text.SimpleDateFormat("yyyy");
		java.text.SimpleDateFormat dateFormatDay = new java.text.SimpleDateFormat("EEEE");
		
		
		System.out.println(MessageFormat.format("\n--- Feiertage für das Jahr {0} ---", 
				dateFormatYear.format(alleFeiertage.get(0).getDatum().getTime())));
		
		
		for(int i = 0; i < alleFeiertage.size(); i++) {
			
			System.out.println(MessageFormat.format(
					"\n---------- Feiertag {0} ----------" +
					"\n\nName		: {1}" +  
					"\nDatum		: {2}" +
					"\nWochentag 	: {3}", 
					i + 1, alleFeiertage.get(i).getName(), dateFormat.format(alleFeiertage.get(i).getDatum().getTime()), dateFormatDay.format(alleFeiertage.get(i).getDatum().getTime()))
			);
			
			System.out.print("Bundesland	: ");
			
			for(int j = 0; j < alleFeiertage.get(i).getBundeslenader().size(); j++) {
				if(j+1 == alleFeiertage.get(i).getBundeslenader().size()) {
					System.out.print(alleFeiertage.get(i).getBundeslenader().get(j));
				} else {
					System.out.print(alleFeiertage.get(i).getBundeslenader().get(j) + ", ");
				}
				
			}
			
			System.out.println("\n");
		}
	}
}
