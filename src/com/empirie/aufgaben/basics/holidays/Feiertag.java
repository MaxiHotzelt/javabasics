package com.empirie.aufgaben.basics.holidays;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;


/**
 * 
 * @author hotzelm
 * Ist zur Erzeugung von Feiertagen
 */
public class Feiertag {
	protected GregorianCalendar datum = new GregorianCalendar();
	protected String name;
	protected ArrayList <String> bundeslaender = new ArrayList<String>();
	
	public Feiertag(int tag, int monat, int jahr, String name, ArrayList<String> bundeslaender) {
		this.datum.set(jahr, monat - 1, tag);
		this.name = name;
		this.bundeslaender.addAll(bundeslaender);
	}
	
	public Feiertag(GregorianCalendar date, String name, ArrayList<String> bundeslaender) {
		this.datum = date;
		this.name = name;
		this.bundeslaender.addAll(bundeslaender);
	}
	
	protected Feiertag(Feiertag feiertag) {
		this.datum = feiertag.getDatum();
		this.name = feiertag.getName();
		this.bundeslaender = feiertag.getBundeslenader();
	}
	
	public GregorianCalendar getDatum() {
		return this.datum;
	}
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<String> getBundeslenader() {
		return this.bundeslaender;
	}
	
	public void tagAusgeben() {
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd.MM.yyyy");
		java.text.SimpleDateFormat dateFormatDay = new java.text.SimpleDateFormat("EEEE");
		
		System.out.println("\n---------- Feiertag ----------");
		System.out.println(MessageFormat.format(
				
				"\n\nName		: {0}" +  
				"\nDatum		: {1}" +
				"\nWochentag 	: {2}", 
				this.getName(), dateFormat.format(this.getDatum().getTime()), dateFormatDay.format(this.getDatum().getTime()))
		);
		

		System.out.print("Bundesland	: ");
		
		for(int j = 0; j < this.getBundeslenader().size(); j++) {
			if(j+1 == this.getBundeslenader().size()) {
				System.out.print(this.getBundeslenader().get(j));
			} else {
				System.out.print(this.getBundeslenader().get(j) + ", ");
			}
			
		}
		
		System.out.println("\n");
	}
	
	public String getCsvEintrag() {
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd.MM.yyyy");
		java.text.SimpleDateFormat dateFormatDay = new java.text.SimpleDateFormat("EEEE");
		
		StringBuilder textFuerCSVDatei = new StringBuilder();
		textFuerCSVDatei.append("\r\n\n---------- Feiertag ----------");
		textFuerCSVDatei.append(MessageFormat.format("\r\nName;{0}", this.getName()));
		textFuerCSVDatei.append(MessageFormat.format("\r\nDatum;{0}", dateFormat.format(this.getDatum().getTime())));
		textFuerCSVDatei.append(MessageFormat.format("\r\nWochentag;{0}", dateFormatDay.format(this.getDatum().getTime())));
		
		textFuerCSVDatei.append("\r\nBundesland;");
		
		for(int j = 0; j < this.getBundeslenader().size(); j++) {
			if(j+1 == this.getBundeslenader().size()) {
				textFuerCSVDatei.append(this.getBundeslenader().get(j));
			} else {
				textFuerCSVDatei.append(this.getBundeslenader().get(j) + ";");			
			}
		}
		
		return textFuerCSVDatei.toString();
	
	}
	
		
}
