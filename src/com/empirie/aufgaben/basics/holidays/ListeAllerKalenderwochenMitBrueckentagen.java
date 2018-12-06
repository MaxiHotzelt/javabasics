package com.empirie.aufgaben.basics.holidays;

import java.text.MessageFormat;
import java.util.ArrayList;


/**
 * 
 * @author hotzelm
 * Enthält eine Liste mit Kalenderwochen, genau genommen Kalenderwochen mit Brückentagen darin
 */
public class ListeAllerKalenderwochenMitBrueckentagen {

	private ArrayList<KalenderwocheMitBrueckentagen> alleKWsMitBrueckentagen = new ArrayList<KalenderwocheMitBrueckentagen>();
	
	public ListeAllerKalenderwochenMitBrueckentagen(ArrayList<Brueckentag> alleBrueckentage) {
		brueckentagsKWListeAnlegen(alleBrueckentage);
	}
	
	private void brueckentagsKWListeAnlegen(ArrayList<Brueckentag> alleBrueckentage) {
		for(int i = 0; i < alleBrueckentage.size(); i++) {
			boolean kwExistiert = false;
			for(int j = 0; j < alleKWsMitBrueckentagen.size(); j++) {
				if(alleBrueckentage.get(i).getKalenderwoche() == alleKWsMitBrueckentagen.get(j).getKalenderwoche()) {
					kwExistiert = true;
					alleKWsMitBrueckentagen.get(j).addBrueckentag(alleBrueckentage.get(i));
				} 
			}
			if(!kwExistiert) {
				KalenderwocheMitBrueckentagen brueckentagkalenderwoche = new KalenderwocheMitBrueckentagen(alleBrueckentage.get(i));
				alleKWsMitBrueckentagen.add(brueckentagkalenderwoche);
			}
			
		}
	}
	
	public void listeAllerKalenderwochenMitBrueckentagenAusgeben() {
		
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd.MM.yyyy");
		java.text.SimpleDateFormat dateFormatDay = new java.text.SimpleDateFormat("EEEE");
	
		for(int i = 0; i < alleKWsMitBrueckentagen.size(); i++) {
			System.out.println(MessageFormat.format("\n\n------- Kalenderwoche {0} -------\n"
					+ "\nArbeitstage		: {1}"
					+ "\nFreie Tage		: {2}"
					+ "\nUrlaubseffizienz 	: {3}%", 
					alleKWsMitBrueckentagen.get(i).getKalenderwoche(),
					alleKWsMitBrueckentagen.get(i).getArbeitstage(),
					alleKWsMitBrueckentagen.get(i).getFreieTage(),
					alleKWsMitBrueckentagen.get(i).urlaubseffizienzBerechnen()));
			
			
			System.out.println();
			for(int j = 0; j < alleKWsMitBrueckentagen.get(i).getBrueckentageInKalenderwoche().size(); j++) {
				System.out.println(MessageFormat.format("\nFeiertag {0}"
						+ "\nName		: {1}"
						+ "\nDatum		: {2}"
						+ "\nWochentag	: {3}",
						j+1, alleKWsMitBrueckentagen.get(i).getBrueckentageInKalenderwoche().get(j).getName(),
						dateFormat.format(alleKWsMitBrueckentagen.get(i).getBrueckentageInKalenderwoche().get(j).getDatum().getTime()),
						dateFormatDay.format(alleKWsMitBrueckentagen.get(i).getBrueckentageInKalenderwoche().get(j).getDatum().getTime())
						));
				
				System.out.print("Bundesländer	: ");
				for(int l = 0; l < alleKWsMitBrueckentagen.get(i).getBrueckentageInKalenderwoche().get(j).getBundeslenader().size(); l++) {
					if(l+1 == alleKWsMitBrueckentagen.get(i).getBrueckentageInKalenderwoche().get(j).getBundeslenader().size()) {
						System.out.print(alleKWsMitBrueckentagen.get(i).getBrueckentageInKalenderwoche().get(j).getBundeslenader().get(l));
					} else {
						System.out.print(alleKWsMitBrueckentagen.get(i).getBrueckentageInKalenderwoche().get(j).getBundeslenader().get(l) + ", ");
					}
				
				}
				
				System.out.println("\n");
			}
			
			
			
			
		}
		
		
		
		
	}
	
}
