package com.empirie.aufgaben.basics.holidays;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;

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
	
	public static void main(String[] args) throws IOException {
		String csvFile = System.getProperty("user.home") + "/Desktop/csv/test.csv";
		OutputStream os = new FileOutputStream(csvFile);
	    os.write(239);
	    os.write(187);
	    os.write(191);
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
		
		writer.print(MessageFormat.format("--- Feiertage für das Jahr {0} ---\n", 
				1));
		writer.print("Test");
		writer.print("\r\n");
		writer.print("Test");
		writer.flush();
		writer.close();
		
		writer = null;
	}

	public void schreibeText(String text) {
		writer.print(text);
	}
	
	public void schreibeFeiertag(Feiertag tag) {
		
	}
	
	public void neueZeile()  {
		writer.print("\r\n");
	}
	
	public void beendeCSV() {
		writer.flush();
		writer.close();
	}
	
}
