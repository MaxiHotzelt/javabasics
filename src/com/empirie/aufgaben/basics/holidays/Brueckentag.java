package com.empirie.aufgaben.basics.holidays;

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
	
}
