package com.empirie.aufgaben.basics.parser.v1;


public class Taschenrechner {

	private String rechnung;
	
	public Taschenrechner(String rechnung) {
		this.rechnung = rechnung;
	}
	
	public String getErgebnis() {
		return doTeilrechnungAndGetResult(rechnung);
	}
	
	
	private String doTeilrechnungAndGetResult(String rechnung) {
		String teilstring = rechnung;
		String teilstringOhneKlammern;
		double zahl1 = 0;
		double zahl2 = 0;
		String operator = "";
		
		int operatorIdx = -1;
		int leftSideIdx;
		int rightSideIdx;
		
		//check if there are parentheses
		if(rechnung.lastIndexOf('(') != -1) {
			int startpos = rechnung.indexOf('(');
			int endpos = rechnung.indexOf(')', startpos );
			// with parentheses
			teilstring = rechnung.substring(startpos , endpos + 1);
			// w/o parentheses
			teilstringOhneKlammern = rechnung.substring(startpos + 1, endpos);
			
			//replace then parentheses part with the result of it
			this.rechnung = this.rechnung.replace(teilstring, doTeilrechnungAndGetResult(teilstringOhneKlammern));
		}
		
		//check if there are point calculations
		else if(	rechnung.lastIndexOf("*") != -1 ||
					rechnung.lastIndexOf("/") != -1
				) {

			if(rechnung.lastIndexOf("*") != -1) {
				operatorIdx = rechnung.indexOf("*");
				operator = "*";
			} 
			else if(rechnung.lastIndexOf("/") != -1) {
				operatorIdx = rechnung.indexOf("/");	
				operator = "/";
			}
		} 
		
		//check if there is a addition or subtraction
		else if(	rechnung.lastIndexOf("+") != -1 ||
					rechnung.lastIndexOf("-") != -1
			) {
			
			if(rechnung.lastIndexOf("+") != -1) {
				operatorIdx = rechnung.indexOf("+");
				operator = "+";
			} 
			else if(rechnung.lastIndexOf("-") != -1) {
				operatorIdx = rechnung.indexOf("-");
				operator = "-";
			}
		} 
		
		//get the indexes left and right from your operator to find the two numbers
		//e.g. 2+5*3-6 --> our operator is *, then leftSide idx should be 1(+) and right side idx 5(-)
		leftSideIdx = getSurroundingOperatorIdx(rechnung.substring(0, operatorIdx), true);
		rightSideIdx = getSurroundingOperatorIdx(rechnung.substring(operatorIdx+1, rechnung.length()-1), false);
		if(rightSideIdx == 0) rightSideIdx++;
		
		//offset the two numbers
		zahl1 = Integer.parseInt(rechnung.substring(leftSideIdx+1, operatorIdx));
		//zahl2 = Integer.parseInt(rechnung.substring(operatorIdx+1, rechnung.length()+1));
		//String test = rechnung.substring(operatorIdx+1, rightSideIdx);
		
		rechnung.replace(rechnung.substring(leftSideIdx, rightSideIdx+1), String.valueOf(getErgebnis(zahl1, zahl2, operator)));
		
		return this.rechnung;
	}
	
	private int getSurroundingOperatorIdx(String rechnung, Boolean leftSide) {
		int index = -1;
		
		if(leftSide) {
			for(int i = rechnung.length()-1; i > 0; i--) {
				if(rechnung.charAt(i) == '*' || rechnung.charAt(i) == '/' || rechnung.charAt(i) == '+' || rechnung.charAt(i) == '-') {
					index = i;
					break;
				} else if(i == 0) {
					index = 0;
				}
			}
		} else {
			for(int i = 0; i < rechnung.length(); i++) {
				if(rechnung.charAt(i) == '*' || rechnung.charAt(i) == '/' || rechnung.charAt(i) == '+' || rechnung.charAt(i) == '-') {
					index = i;
					break;
				} else if(i == rechnung.length()-1) {
					index = rechnung.length()-1;
				}
			}
		}
		
		return index;
	}
	
	private double getErgebnis(double zahl1, double zahl2, String operator) {
		switch(operator) {
			case "+" :
				return zahl1 + zahl2;
			case "-" :
				return zahl1 - zahl2;
			case "*" :
				return zahl1 * zahl2;
			case "/" :
				return zahl1 / zahl2;
			default:
				return 0;
		}
	}
	
	
	
}
