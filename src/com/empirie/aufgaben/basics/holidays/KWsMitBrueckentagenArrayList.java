package com.empirie.aufgaben.basics.holidays;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Scanner;


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
	
public void listeAllerKalenderwochenMitBrueckentagenExportieren()  {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String dateiName = System.getProperty("user.home") + "/Desktop/csv/";
	
		System.out.print("Gib den Dateinamen an: ");
		dateiName = dateiName.concat(sc.nextLine() + "kalenderwochenMitBrueckentag.csv");
		
		
		CSVUtils csvDatei = new CSVUtils(dateiName);
		
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd.MM.yyyy");
		java.text.SimpleDateFormat dateFormatYear = new java.text.SimpleDateFormat("yyyy");
		java.text.SimpleDateFormat dateFormatDay = new java.text.SimpleDateFormat("EEEE");
		
		csvDatei.schreibeText(MessageFormat.format("--- Kalenderwochen mit Brückentagen für das Jahr {0} ---", 
				dateFormatYear.format(alleKWsMitBrueckentagen.get(0).getBrueckentageInKalenderwoche().get(0).getDatum().getTime())));
		
		for(int i = 0; i < alleKWsMitBrueckentagen.size(); i++) {
			csvDatei.schreibeText(MessageFormat.format("\r\n\n------- Kalenderwoche {0} -------", alleKWsMitBrueckentagen.get(i).getKalenderwoche()));
			csvDatei.schreibeText(MessageFormat.format("\r\nArbeitstage;{0}", alleKWsMitBrueckentagen.get(i).getArbeitstage()));
			csvDatei.schreibeText(MessageFormat.format("\r\nFreie Tage;{0}", alleKWsMitBrueckentagen.get(i).getFreieTage()));
			csvDatei.schreibeText(MessageFormat.format("\r\nUrlaubseffizienz;{0}%", alleKWsMitBrueckentagen.get(i).urlaubseffizienzBerechnen()));
			

			for(int j = 0; j < alleKWsMitBrueckentagen.get(i).getBrueckentageInKalenderwoche().size(); j++) {
				csvDatei.schreibeText(MessageFormat.format("\r\n\nFeiertag {0}:", j+1));
				csvDatei.schreibeText(MessageFormat.format("\r\nName;{0}", alleKWsMitBrueckentagen.get(i).getBrueckentageInKalenderwoche().get(j).getName()));
				csvDatei.schreibeText(MessageFormat.format("\r\nDatum;{0}", dateFormat.format(alleKWsMitBrueckentagen.get(i).getBrueckentageInKalenderwoche().get(j).getDatum().getTime())));
				csvDatei.schreibeText(MessageFormat.format("\r\nWochentag;{0}", dateFormatDay.format(alleKWsMitBrueckentagen.get(i).getBrueckentageInKalenderwoche().get(j).getDatum().getTime())));
				
				csvDatei.schreibeText("\r\nBrueckentage;");
				for(int l = 0; l < alleKWsMitBrueckentagen.get(i).getBrueckentageInKalenderwoche().get(j).getBundeslenader().size(); l++) {
					if(l+1 == alleKWsMitBrueckentagen.get(i).getBrueckentageInKalenderwoche().get(j).getBundeslenader().size()) {
						csvDatei.schreibeText(alleKWsMitBrueckentagen.get(i).getBrueckentageInKalenderwoche().get(j).getBundeslenader().get(l));
					} else {
						csvDatei.schreibeText(alleKWsMitBrueckentagen.get(i).getBrueckentageInKalenderwoche().get(j).getBundeslenader().get(l) + ";");
					}
				
				}
			}	
		}	
		
		csvDatei.beendeCSV();
		csvDatei = null;
	}
	
}
