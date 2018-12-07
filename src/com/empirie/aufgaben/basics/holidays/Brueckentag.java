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
		public void ausgeben() {
			// TODO Auto-generated method stub
			super.ausgeben();
			System.out.println("brueckentag");
			
			
		}

	@Override
	public String getCsvEintrag(int stelleAnListe) {
		
		String currentText = super.getCsvEintrag(stelleAnListe);
		
		StringBuilder textFuerCSVDatei = new StringBuilder(currentText);
		textFuerCSVDatei.append(MessageFormat.format("\r\nKalenderwoche;{0}", this.getKalenderwoche()));
		
		return textFuerCSVDatei.toString();
	}
	
}
