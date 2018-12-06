package com.empirie.aufgaben.basics.holidays;

import java.util.ArrayList;

/**
 * 
 * @author hotzelm
 * Ein Subklasse von Kalenderwoche, diese Kalenderwoche ist eine Woche mit Brückentagen darin
 * 
 */
public class KalenderwocheMitBrueckentagen extends Kalenderwoche{
	
	private ArrayList<Brueckentag> brueckentageInKalenderwoche = new ArrayList<Brueckentag>();
	private int kalenderwoche;
	
	public KalenderwocheMitBrueckentagen(Brueckentag brueckentag) {
		brueckentageInKalenderwoche.add(brueckentag);
		this.kalenderwoche = brueckentag.getKalenderwoche();
		
		erneuereTageverteilung();
	}
	
	public ArrayList<Brueckentag> getBrueckentageInKalenderwoche() {
		return brueckentageInKalenderwoche;
	}
	
	public int getKalenderwoche() {
		return kalenderwoche;
	}
	
	public void addBrueckentag(Brueckentag brueckentag) {
		brueckentageInKalenderwoche.add(brueckentag);
		
		erneuereTageverteilung();
	}
	
	private void erneuereTageverteilung() {
		this.arbeitstage--;
		this.freieTage++;
	}
}
