package com.empirie.aufgaben.basics.tests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Tests {
		
	public static void main(String[] args) {
		final String regex = "\\+\\+";
		final String string = "--7+++1+--1-2++";
	
		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(string);
	
		System.out.println(string.matches(regex));
		System.out.println(matcher.find());
		
		while (matcher.find()) {
		    System.out.println("Kompletter Match: " + matcher.group(0));
		    for (int i = 1; i <= matcher.groupCount(); i++) {
		        System.out.println("Gruppe " + i + ": " + matcher.group(i));
		    }
		}
	}
	
}
