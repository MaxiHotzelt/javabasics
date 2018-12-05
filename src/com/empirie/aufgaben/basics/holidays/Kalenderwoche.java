package com.empirie.aufgaben.basics.holidays;

public abstract class Kalenderwoche {
	protected int arbeitstage;
	protected int freieTage;
	protected int urlaubseffizienz;
	protected int kalenderwoche;
	
	protected Kalenderwoche(int kalenderwoche) {
		this.arbeitstage = 5;
		this.freieTage = 2;
		this.kalenderwoche = kalenderwoche;
	}

	public int getArbeitstage() {
		return this.arbeitstage;
	}

	public int getFreieTage() {
		return this.freieTage;
	}
	
	public int getUrlaubseffizienz() {
		return this.urlaubseffizienz;
	}
	
	public void urlaubseffizienzBerechnen() {
		this.urlaubseffizienz = (int)Math.floor((100/(this.arbeitstage + this.freieTage))*this.freieTage);
	}


	
}
