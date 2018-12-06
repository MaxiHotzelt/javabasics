package com.empirie.aufgaben.basics.holidays;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * 
 * @author hotzelm
 * Entählt alle Brückentage
 */
public class ListeAllerBrueckentage {
	
	private  ArrayList<Brueckentag> alleBrueckentage = new ArrayList<Brueckentag>();
	
	public ListeAllerBrueckentage(ListeAllerFeiertage alleFeiertage) {
		brueckentagslisteAnlegen(alleFeiertage);
	}
	
	public ArrayList<Brueckentag> getAlleBrueckentage() {
		return alleBrueckentage;
	}
	
	private void brueckentagslisteAnlegen(ListeAllerFeiertage alleFeiertage) {
		for (Feiertag feiertag : alleFeiertage.getFeiertage()) {
			if(feiertag.getDatum().get(Calendar.DAY_OF_WEEK) > 1 && feiertag.getDatum().get(Calendar.DAY_OF_WEEK) < 7) {
				Brueckentag brueckentag = new Brueckentag(feiertag);
				alleBrueckentage.add(brueckentag);
			}
		}
	}
	
	public void brueckentageAusgeben() {
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd.MM.yyyy");
		java.text.SimpleDateFormat dateFormatYear = new java.text.SimpleDateFormat("yyyy");
		java.text.SimpleDateFormat dateFormatDay = new java.text.SimpleDateFormat("EEEE");
		
		
		System.out.println(MessageFormat.format("\n--- Brückentage für das Jahr {0} ---", 
				dateFormatYear.format(alleBrueckentage.get(0).getDatum().getTime())));
		
		
		for(int i = 0; i < alleBrueckentage.size(); i++) {
			
			System.out.println(MessageFormat.format(
					"\n---------- Brückentag {0} ----------" +
					"\n\nName		: {1}" +  
					"\nDatum		: {2}" +
					"\nKalenderwoche	: {3}" +
					"\nWochentag 	: {4}", 
					i + 1, alleBrueckentage.get(i).getName(), dateFormat.format(alleBrueckentage.get(i).getDatum().getTime()),
					alleBrueckentage.get(i).getKalenderwoche(), dateFormatDay.format(alleBrueckentage.get(i).getDatum().getTime()))
			);
			
			System.out.print("Bundesland	: ");
			
			for(int j = 0; j < alleBrueckentage.get(i).getBundeslenader().size(); j++) {
				if(j+1 == alleBrueckentage.get(i).getBundeslenader().size()) {
					System.out.print(alleBrueckentage.get(i).getBundeslenader().get(j));
				} else {
					System.out.print(alleBrueckentage.get(i).getBundeslenader().get(j) + ", ");
				}
				
			}
			
			System.out.println("\n");
		}
	}

}