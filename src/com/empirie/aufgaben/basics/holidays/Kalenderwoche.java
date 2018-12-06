package com.empirie.aufgaben.basics.holidays;


/**
 * 
 * @author hotzelm
 * Ist die Superklasse einer Kalenderwoche mit Brückentagen darin
 */
public abstract class Kalenderwoche {
	protected int arbeitstage;
	protected int freieTage;
	
	protected Kalenderwoche() {
		this.arbeitstage = 5;
		this.freieTage = 2;
	}

	public int getArbeitstage() {
		return this.arbeitstage;
	}

	public int getFreieTage() {
		return this.freieTage;
	}
	
	
	public int urlaubseffizienzBerechnen() {
		return (int)Math.round((100/(this.arbeitstage + this.freieTage))*this.freieTage);
	}
	
}
