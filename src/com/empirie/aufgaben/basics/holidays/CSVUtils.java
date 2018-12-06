package com.empirie.aufgaben.basics.holidays;

import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;

public class CSVUtils {
	private String csvFile;
	private FileWriter writer;
	
	
	public CSVUtils(String pfad) throws IOException {
		this.csvFile = pfad;
		this.writer = new FileWriter(this.csvFile);
	}
	
	public static void main(String[] args) throws IOException {
		String csvFile = System.getProperty("user.home") + "/Desktop/test.csv";
		FileWriter writer = new FileWriter(csvFile);
		
		writer.append(MessageFormat.format("--- Feiertage für das Jahr {0} ---\n", 
				1));
		writer.append("Test");
		writer.append("\r\n");
		writer.append("Test");
		writer.flush();
		writer.close();
		
		writer = null;
		
	}
	
	public void schreibeText(String text) throws IOException {
		writer.append(text);
	}
	
	public void neueZeile() throws IOException {
		writer.append("\r\n");
	}
	
	public void beendeCSV() throws IOException {
		writer.flush();
		writer.close();
	}
	
}
