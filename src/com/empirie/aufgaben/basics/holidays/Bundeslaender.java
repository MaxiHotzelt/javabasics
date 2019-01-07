package com.empirie.aufgaben.basics.holidays;

import java.util.ArrayList;
import java.util.Arrays;

public enum Bundeslaender {
		BadenWürttemberg(new ArrayList<String>(Arrays.asList("Neujahrstag", "Heilige drei Könige", "Gründonnerstag", "Karfreitag", "Ostermontag", "1. Mai / Tag der Arbeit", "Christi-Himmelfahrt", "Pfingstmontag", "Fronleichnam", "Tag der Deutschen Einheit", "Allerheiligen", "1. Weihnachtstag", "2. Weihnachtstag"))),
		Bayern(new ArrayList<String>(Arrays.asList("Neujahrstag", "Heilige Drei Könige", "Karfreitag", "Ostermontag", "1. Mai / Tag der Arbeit", "Christi-Himmelfahrt", "Pfingstmontag", "Fronleichnam", "Augsburger Hohes Fest", "Mariä Himmelfahrt", "Tag der Deutschen Einheit", "Allerheiligen", "Buß- und Bettag", "1. Weihnachtstag", "2. Weihnachtstag"))),
		Berlin(new ArrayList<String>(Arrays.asList("Neujahrstag", "Karfreitag", "Ostermontag", "1. Mai / Tag der Arbeit", "Christi-Himmelfahrt", "Pfingstmontag", "Tag der Deutschen Einheit", "1. Weihnachtstag", "2. Weihnachtstag"))),
		Brandenburg(new ArrayList<String>(Arrays.asList("Neujahrstag", "Karfreitag", "Ostersonntag", "Ostermontag", "1. Mai / Tag der Arbeit", "Christi-Himmelfahrt", "Pfingstsonntag", "Tag der Deutschen Einheit", "Reformationstag", "1. Weihnachtstag", "2. Weihnachtstag"))),
		Bremen(new ArrayList<String>(Arrays.asList("Neujahrstag", "Karfreitag", "Ostermontag", "1. Mai / Tag der Arbeit", "Christi-Himmelfahrt", "Pfingstmontag", "Tag der Deutschen Einheit", "Reformationstag", "1. Weihnachtstag", "2. Weihnachtstag"))),
		Hamburg(new ArrayList<String>(Arrays.asList("Neujahrstag", "Karfreitag", "Ostermontag", "1. Mai / Tag der Arbeit", "Christi-Himmelfahrt", "Pfingstmontag", "Tag der Deutschen Einheit", "Reformationstag", "1. Weihnachtstag", "2. Weihnachtstag"))),
		Hessen(new ArrayList<String>(Arrays.asList("Neujahrstag", "Karfreitag", "Ostermontag", "1. Mai", "Christi-Himmelfahrt", "Pfingstmontag", "Fronleichnam", "Tag der Deutschen Einheit", "1. Weihnachtstag", "2. Weihnachtstag"))),
		MecklenburgVorpommern(new ArrayList<String>(Arrays.asList("Neujahrstag", "Karfreitag", "Ostermontag", "1. Mai / Tag der Arbeit", "Christi-Himmelfahrt", "Pfingstmontag", "Tag der Deutschen Einheit", "Reformationstag", "1. Weihnachtstag", "2. Weihnachtstag"))),
		Niedersachsen(new ArrayList<String>(Arrays.asList("Neujahrstag", "Karfreitag", "Ostermontag", "1. Mai / Tag der Arbeit", "Christi-Himmelfahrt", "Pfingstmontag", "Tag der Deutschen Einheit", "Reformationstag", "1. Weihnachtstag", "2. Weihnachtstag"))),
		NordrheinWestfahlen(new ArrayList<String>(Arrays.asList("Neujahrstag", "Karfreitag", "Ostermontag", "1. Mai / Tag der Arbeit", "Christi-Himmelfahrt", "Pfingstmontag", "Fronleichnam", "Tag der Deutschen Einheit", "Allerheiligen", "1. Weihnachtstag", "2. Weihnachtstag"))),
		RheinlandPfalz(new ArrayList<String>(Arrays.asList("Neujahrstag", "Karfreitag", "Ostermontag", "1. Mai / Tag der Arbeit", "Christi-Himmelfahrt", "Pfingstmontag", "Fronleichnam", "Tag der Deutschen Einheit", "Allerheiligen", "1. Weihnachtstag", "2. Weihnachtstag"))),
		Saarland(new ArrayList<String>(Arrays.asList("Neujahrstag", "Karfreitag", "Ostermontag", "1. Mai / Tag der Arbeit", "Christi-Himmelfahrt", "Pfingstmontag", "Fronleichnam", "Mariä Himmelfahrt", "Tag der Deutschen Einheit", "Allerheiligen", "1. Weihnachtstag", "2. Weihnachtstag"))),
		Sachsen(new ArrayList<String>(Arrays.asList("Neujahrstag", "Karfreitag", "Ostermontag", "1. Mai / Tag der Arbeit", "Christi-Himmelfahrt", "Pfingstmontag", "Tag der Deutschen Einheit", "Reformationstag", "Buß- und Bettag", "1. Weihnachtstag", "2. Weihnachtstag"))),
		SachsenAnhalt(new ArrayList<String>(Arrays.asList("Neujahrstag", "Heilige Drei Könige", "Karfreitag", "Ostermontag", "1. Mai / Tag der Arbeit", "Christi-Himmelfahrt", "Pfingstmontag", "Tag der Deutschen Einheit", "Reformationstag", "1. Weihnachtstag", "2. Weihnachtstag"))),
		SchleswigHolstein(new ArrayList<String>(Arrays.asList("Neujahrstag", "Karfreitag", "Ostermontag", "1. Mai / Tag der Arbeit", "Christi-Himmelfahrt", "Pfingstmontag", "Tag der Deutschen Einheit", "Reformationstag", "1. Weihnachtstag", "2. Weihnachtstag"))),
		Thüringen(new ArrayList<String>(Arrays.asList("Neujahrstag", "Karfreitag", "Ostermontag", "1. Mai / Tag der Arbeit", "Christi-Himmelfahrt", "Pfingstmontag", "Tag der Deutschen Einheit", "Reformationstag", "1. Weihnachtstag", "2. Weihnachtstag")));

	private ArrayList<String> feiertage;
	
	private Bundeslaender(ArrayList<String> feiertage) {
		this.feiertage = feiertage;
	}
	
	public ArrayList<String> getBundeslaender(String name) {
		ArrayList<String> bundeslaender = new ArrayList<String>();
		
		
		for (Bundeslaender bundesland : Bundeslaender.values()) {
			if(bundesland.feiertage.contains(name)) {
				bundeslaender.add(bundesland.name());
			}
		}
		
		return bundeslaender;
	}
	
}



