package com.empirie.aufgaben.basics.holidays;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Feiertag extends Tag {
	private String name;
	private ArrayList<String> bundeslaender = new ArrayList<String>();
	
	public Feiertag(GregorianCalendar datum, String name, ArrayList<String> bundeslaender) {
		super(datum);
		this.name = name;
		this.bundeslaender.addAll(bundeslaender);
	}
	
	public Feiertag(int tag, int monat, int jahr, String name, ArrayList<String> bundeslaender) {
		super(tag, monat, jahr);
		this.name = name;
		this.bundeslaender.addAll(bundeslaender);
	}
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<String> getBundeslaender() {
		return this.bundeslaender;
	}
	
	public void tagAusgeben(boolean alleFeiertage) {
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd.MM.yyyy");
		java.text.SimpleDateFormat dateFormatDay = new java.text.SimpleDateFormat("EEEE");

		System.out.println(MessageFormat.format("\n---------- {0} ----------", this.getName()));
		
		System.out.println(MessageFormat.format(
				
				"\n\nName		: {0}" +  
				"\nDatum		: {1}" +
				"\nWochentag 	: {2}", 
				this.getName(), dateFormat.format(this.getDatum().getTime()), dateFormatDay.format(this.getDatum().getTime()))
		);
		if(!alleFeiertage) {
			System.out.println(MessageFormat.format("Kalenderwoche	: {0}", this.getKalenderwoche()));
		}
		

		System.out.print("Bundesland	: ");
		
		for(int j = 0; j < this.getBundeslaender().size(); j++) {
			if(j+1 == this.getBundeslaender().size()) {
				System.out.print(this.getBundeslaender().get(j));
			} else {
				System.out.print(this.getBundeslaender().get(j) + ", ");
			}
			
		}
		
		System.out.println("\n");
	}
	
	public String getCSVEintrag(boolean alleFeiertage) {
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd.MM.yyyy");
		java.text.SimpleDateFormat dateFormatDay = new java.text.SimpleDateFormat("EEEE");
		
		StringBuilder textFuerCSVDatei = new StringBuilder();
		textFuerCSVDatei.append("\r\n\n---------- Feiertag ----------");
		textFuerCSVDatei.append(MessageFormat.format("\r\nName;{0}", this.getName()));
		textFuerCSVDatei.append(MessageFormat.format("\r\nDatum;{0}", dateFormat.format(this.getDatum().getTime())));
		textFuerCSVDatei.append(MessageFormat.format("\r\nWochentag;{0}", dateFormatDay.format(this.getDatum().getTime())));
		
		if(!alleFeiertage) {
			textFuerCSVDatei.append(MessageFormat.format("\r\nKalenderwoche;{0}", this.getKalenderwoche()));
		}
		
		textFuerCSVDatei.append("\r\nBundesland;");
		
		for(int j = 0; j < this.getBundeslaender().size(); j++) {
			if(j+1 == this.getBundeslaender().size()) {
				textFuerCSVDatei.append(this.getBundeslaender().get(j));
			} else {
				textFuerCSVDatei.append(this.getBundeslaender().get(j) + ";");			
			}
		}
		
		return textFuerCSVDatei.toString();
	}
}
