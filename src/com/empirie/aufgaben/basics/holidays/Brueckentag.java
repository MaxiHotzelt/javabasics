package com.empirie.aufgaben.basics.holidays;

import java.text.MessageFormat;
import java.util.GregorianCalendar;

/**
 * 
 * @author hotzelm
 * Eine besondere Form eines Feiertags - der Brückentag
 */
public class Brueckentag extends Feiertag  {
	
	private int kalenderwoche;
	
	public Brueckentag(Feiertag feiertag) {
		super(feiertag);
		this.kalenderwoche = feiertag.getDatum().get(GregorianCalendar.WEEK_OF_YEAR);
	}

	public int getKalenderwoche() {
		return kalenderwoche;
	}	
	
	@Override
	public void tagAusgeben() {
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd.MM.yyyy");
		java.text.SimpleDateFormat dateFormatDay = new java.text.SimpleDateFormat("EEEE");
		
					
		System.out.println(MessageFormat.format(
				"\n---------- Brückentag ----------" +
				"\n\nName		: {0}" +  
				"\nDatum		: {1}" +
				"\nKalenderwoche	: {2}" +
				"\nWochentag 	: {3}", 
				this.getName(), dateFormat.format(this.getDatum().getTime()),
				this.getKalenderwoche(), dateFormatDay.format(this.getDatum().getTime()))
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

	@Override
	public String getCsvEintrag() {
		
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd.MM.yyyy");
		java.text.SimpleDateFormat dateFormatDay = new java.text.SimpleDateFormat("EEEE");
		
		StringBuilder textFuerCSVDatei = new StringBuilder();
		textFuerCSVDatei.append("\r\n\n---------- Feiertag ----------");
		textFuerCSVDatei.append(MessageFormat.format("\r\nName;{0}", this.getName()));
		textFuerCSVDatei.append(MessageFormat.format("\r\nDatum;{0}", dateFormat.format(this.getDatum().getTime())));
		textFuerCSVDatei.append(MessageFormat.format("\r\nKalenderwoche;{0}", this.getKalenderwoche()));
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
