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
	
	public void ausgeben() {
		System.out.println("Datum");
	}
	
	public String getCsvEintrag(int stelleAnListe) {
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd.MM.yyyy");
		java.text.SimpleDateFormat dateFormatDay = new java.text.SimpleDateFormat("EEEE");
		
		StringBuilder textFuerCSVDatei = new StringBuilder();
		textFuerCSVDatei.append(MessageFormat.format("\r\n\n---------- Tag {0} ----------", stelleAnListe));
		textFuerCSVDatei.append(MessageFormat.format("\r\nName;{0}", this.getName()));
		textFuerCSVDatei.append(MessageFormat.format("\r\nDatum;{0}", dateFormat.format(this.getDatum().getTime())));
		textFuerCSVDatei.append(MessageFormat.format("\r\nWochentag;{0}", dateFormatDay.format(this.getDatum().getTime())));
		
		return textFuerCSVDatei.toString();
	}
	
		
}
