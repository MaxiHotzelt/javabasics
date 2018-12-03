package com.empirie.aufgaben.basics.holidays;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Feiertag {
	private Calendar datum = new GregorianCalendar();
	private String name;
	private ArrayList <String> bundeslaender = new ArrayList<String>();
	
	public Feiertag(int tag, int monat, int jahr, String name, ArrayList<String> bundeslaender) {
		this.datum.set(jahr, monat - 1, tag);
		this.name = name;
		this.bundeslaender.addAll(bundeslaender);
	}
	public Feiertag(Calendar date, String name, ArrayList<String> bundeslaender) {
		this.datum = date;
		this.name = name;
		this.bundeslaender.addAll(bundeslaender);
	}
	
	
	public Calendar getDatum() {
		return this.datum;
	}
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<String> getBundeslenader() {
		return this.bundeslaender;
	}
	
	
}
