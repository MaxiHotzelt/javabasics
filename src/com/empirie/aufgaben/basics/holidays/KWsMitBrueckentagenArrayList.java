package com.empirie.aufgaben.basics.holidays;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * 
 * @author hotzelm
 * Enthält eine Liste mit Kalenderwochen, genau genommen Kalenderwochen mit Brückentagen darin
 */
@SuppressWarnings("serial")
public class KWsMitBrueckentagenArrayList extends ArrayList<KalenderwocheMitBrueckentagen>{
	
	public KWsMitBrueckentagenArrayList(ArrayList<Brueckentag> alleBrueckentage) {
		brueckentagsKWListeAnlegen(alleBrueckentage);
	}
	
	private void brueckentagsKWListeAnlegen(ArrayList<Brueckentag> alleBrueckentage) {
		for(int i = 0; i < alleBrueckentage.size(); i++) {
			boolean kwExistiert = false;
			for(int j = 0; j < this.size(); j++) {
				if(alleBrueckentage.get(i).getKalenderwoche() == this.get(j).getKalenderwoche()) {
					kwExistiert = true;
					this.get(j).addBrueckentag(alleBrueckentage.get(i));
				} 
			}
			if(!kwExistiert) {
				KalenderwocheMitBrueckentagen brueckentagkalenderwoche = new KalenderwocheMitBrueckentagen(alleBrueckentage.get(i));
				this.add(brueckentagkalenderwoche);
			}
		}
	}
	
	public void listeAllerKalenderwochenMitBrueckentagenAusgeben() {
		
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd.MM.yyyy");
		java.text.SimpleDateFormat dateFormatDay = new java.text.SimpleDateFormat("EEEE");
	
		for(int i = 0; i < this.size(); i++) {
			System.out.println(MessageFormat.format("\n\n------- Kalenderwoche {0} -------\n"
					+ "\nArbeitstage		: {1}"
					+ "\nFreie Tage		: {2}"
					+ "\nUrlaubseffizienz 	: {3}%", 
					this.get(i).getKalenderwoche(),
					this.get(i).getArbeitstage(),
					this.get(i).getFreieTage(),
					this.get(i).urlaubseffizienzBerechnen()));
			
			
			System.out.println();
			for(int j = 0; j < this.get(i).getBrueckentageInKalenderwoche().size(); j++) {
				System.out.println(MessageFormat.format("\nFeiertag {0}"
						+ "\nName		: {1}"
						+ "\nDatum		: {2}"
						+ "\nWochentag	: {3}",
						j+1, this.get(i).getBrueckentageInKalenderwoche().get(j).getName(),
						dateFormat.format(this.get(i).getBrueckentageInKalenderwoche().get(j).getDatum().getTime()),
						dateFormatDay.format(this.get(i).getBrueckentageInKalenderwoche().get(j).getDatum().getTime())
						));
				
				System.out.print("Bundesländer	: ");
				for(int l = 0; l < this.get(i).getBrueckentageInKalenderwoche().get(j).getBundeslenader().size(); l++) {
					if(l+1 == this.get(i).getBrueckentageInKalenderwoche().get(j).getBundeslenader().size()) {
						System.out.print(this.get(i).getBrueckentageInKalenderwoche().get(j).getBundeslenader().get(l));
					} else {
						System.out.print(this.get(i).getBrueckentageInKalenderwoche().get(j).getBundeslenader().get(l) + ", ");
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
				dateFormatYear.format(this.get(0).getBrueckentageInKalenderwoche().get(0).getDatum().getTime())));
		
		for(int i = 0; i < this.size(); i++) {
			csvDatei.schreibeText(MessageFormat.format("\r\n\n------- Kalenderwoche {0} -------", this.get(i).getKalenderwoche()));
			csvDatei.schreibeText(MessageFormat.format("\r\nArbeitstage;{0}", this.get(i).getArbeitstage()));
			csvDatei.schreibeText(MessageFormat.format("\r\nFreie Tage;{0}", this.get(i).getFreieTage()));
			csvDatei.schreibeText(MessageFormat.format("\r\nUrlaubseffizienz;{0}%", this.get(i).urlaubseffizienzBerechnen()));
			

			for(int j = 0; j < this.get(i).getBrueckentageInKalenderwoche().size(); j++) {
				csvDatei.schreibeText(MessageFormat.format("\r\n\nFeiertag {0}:", j+1));
				csvDatei.schreibeText(MessageFormat.format("\r\nName;{0}", this.get(i).getBrueckentageInKalenderwoche().get(j).getName()));
				csvDatei.schreibeText(MessageFormat.format("\r\nDatum;{0}", dateFormat.format(this.get(i).getBrueckentageInKalenderwoche().get(j).getDatum().getTime())));
				csvDatei.schreibeText(MessageFormat.format("\r\nWochentag;{0}", dateFormatDay.format(this.get(i).getBrueckentageInKalenderwoche().get(j).getDatum().getTime())));
				
				csvDatei.schreibeText("\r\nBrueckentage;");
				for(int l = 0; l < this.get(i).getBrueckentageInKalenderwoche().get(j).getBundeslenader().size(); l++) {
					if(l+1 == this.get(i).getBrueckentageInKalenderwoche().get(j).getBundeslenader().size()) {
						csvDatei.schreibeText(this.get(i).getBrueckentageInKalenderwoche().get(j).getBundeslenader().get(l));
					} else {
						csvDatei.schreibeText(this.get(i).getBrueckentageInKalenderwoche().get(j).getBundeslenader().get(l) + ";");
					}
				
				}
			}	
		}	
		
		csvDatei.beendeCSV();
		csvDatei = null;
	}
	
}
