package com.empirie.aufgaben.basics.holidays;


import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Tag {
	
	protected int kalenderwoche;
	protected GregorianCalendar datum = new GregorianCalendar();
	
	public Tag(GregorianCalendar datum) {
		this.datum = datum;
		this.kalenderwoche = datum.get(Calendar.WEEK_OF_YEAR);
	}
	
	public Tag(int tag, int monat, int jahr) {
		this.datum.set(jahr, monat - 1, tag);
		this.kalenderwoche = datum.get(Calendar.WEEK_OF_YEAR);
	}
	
	public GregorianCalendar getDatum() {
		return this.datum;
	}
	
	public int getKalenderwoche() {
		return this.kalenderwoche;
	}
	
}
