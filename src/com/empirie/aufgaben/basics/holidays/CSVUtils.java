package com.empirie.aufgaben.basics.holidays;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class CSVUtils {
	private String csvFile;
	private PrintWriter writer;
	
	public CSVUtils(String pfad) {
		this.csvFile = pfad;
		try {
			OutputStream os = new FileOutputStream(csvFile);
			os.write(239);
		    os.write(187);
		    os.write(191);
		    
		    try {
		    	this.writer = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
		    } catch (UnsupportedEncodingException e) {
				System.out.println("Das gewünschte Encoding konnte nicht gefunden werden.");
				this.writer = new PrintWriter(new OutputStreamWriter(os));
				
			} 
		} catch (FileNotFoundException e) {
			System.out.println("Datei konnte nicht erstellt werden.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void schreibeText(String text) {
		writer.print(text);
	}
	
	public void beendeCSV() {
		writer.flush();
		writer.close();
	}
	
}
