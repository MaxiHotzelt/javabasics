package com.empirie.aufgaben.basics.holidays;

import java.util.ArrayList;

public class Feiertagskalenderwoche extends Kalenderwoche{
	
	public ArrayList<Brueckentag> brueckentageInKalenderwoche = new ArrayList<Brueckentag>();
	
	public Feiertagskalenderwoche(int kalenderwoche) {
		super(kalenderwoche);
		
	}
	
}
