package com.empirie.aufgaben.basics.parser.v2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Taschenrechner {

	private boolean negativeNumber = false;
	int currentStartPos = 0;
	int currentEndPos = 0;
	int operatorIdx = 0;
	String operator = null;
	

	
	
	
	public String getErgebnis(String rechnung) {
		Pattern pattern = Pattern.compile("\\s", Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(rechnung);
		if(matcher.find()) {
			rechnung = rechnung.replaceAll("\\s", "");
		}
		return doTeilrechnungAndGetResult(rechnung);
	}
	
	
	private String doTeilrechnungAndGetResult(String rechnung) {
		
		//this part checks if there are operators like --, +-, ++ etc. and replaces them -> +- replaced with - ...
		rechnung = adjustOperators(rechnung);

		//check if there are parentheses
		if(rechnung.contains("(")) {
			rechnung = getParenthesesCalculation(rechnung);
		}		
		//check if there are point calculations
		else if(rechnung.contains("*") || rechnung.contains("/")) {
			rechnung = doPointCalculation(rechnung);
			
		}	
		//check if there is a addition or subtraction
		else if((rechnung.contains("+") ||rechnung.contains("-")) &&
					//check if only a minus is at first position and no other operators are left
					!(rechnung.lastIndexOf("-") == 0 && !rechnung.contains("+"))
			) {
			rechnung = doAdditionAndSubstractionCalculation(rechnung);
		} 
		
		//if there are no valid operators left to do a operation, the result gets returned(if-case), elsewise the 
		//method calls itself again with, while the call awaits a return to replace it (else case)
		if( (!rechnung.contains("+") &&
			!rechnung.contains("*")  &&
			!rechnung.contains("/")  &&
			!rechnung.contains("(")  &&
			!rechnung.contains(")")) && 
			(!rechnung.contains("-") || rechnung.lastIndexOf("-") == 0 )) {
			return rechnung;
		} 
		//if there are still existing operations, doTeilrechnungAndGetResult is called, to replace the substring with the result
		else {
			rechnung = rechnung.replace(rechnung.substring(0, rechnung.length()), doTeilrechnungAndGetResult(rechnung));
		}
		
		return rechnung;
	}

/**
 * Calculates the result of two numbers. There has to be a plus or minus operator. The method will only 
 * calculate two numbers and replace them with the result
 * @param rechnung - the string has to have a plus or minus and at least two numbers
 * @return returns the string, where the two numbers are replaced with the result of those
 */
	private String doAdditionAndSubstractionCalculation(String rechnung) {
		operatorIdx = 0;
		operator = null;
		
		if(rechnung.contains("+")) {
			operatorIdx = rechnung.indexOf("+");
			operator = "+";
		} 
		else if(rechnung.contains("-")) {
			operatorIdx = rechnung.indexOf("-");
			if(operatorIdx == 0) {
				operatorIdx = rechnung.indexOf("-",	operatorIdx+1);
			}
			operator = "-";
		}
		
		//calls findNumbersAndCalculate, which returns the result of the numbers next to the operator
		rechnung = findNumbersAndCalculate(rechnung, operatorIdx, operator);
		return rechnung;
	}


	private String doPointCalculation(String rechnung) {
		int[] operatorsArray = new int[2];
		operatorIdx = 0;
		operator = null;
		
		if(rechnung.contains("*")) {
			operatorsArray[0] = rechnung.indexOf("*");
		} else {
			operatorsArray[0] = 9999999;
		}
		if(rechnung.contains("/")) {
			operatorsArray[1] = rechnung.indexOf("/");
		} else {
			operatorsArray[1] = 9999999;
		}
		
		if(operatorsArray[0] < operatorsArray[1]) {
			operatorIdx = rechnung.indexOf("*");
			operator = "*";
		} 
		else if(operatorsArray[0] > operatorsArray[1]) {
			operatorIdx = rechnung.indexOf("/");	
			operator = "/";
		}
		
		//calls findNumbersAndCalculate, which returns the result of the numbers next to the operator
		rechnung = findNumbersAndCalculate(rechnung, operatorIdx, operator);
		
		return rechnung;
	}


	private String getParenthesesCalculation(String rechnung) {
		
		currentStartPos = rechnung.lastIndexOf('(');
		currentEndPos = rechnung.indexOf(')', currentStartPos);
		String rechnungBefore = rechnung.substring(currentStartPos, currentEndPos+1);
		String rechnungAfter = rechnung.substring(currentStartPos+1, currentEndPos);
		
		
		//check if there is a operator before the parentheses
		if(currentStartPos != 0) {
			if( rechnung.charAt(currentStartPos-1) == '*' || 
			rechnung.charAt(currentStartPos-1) == '/' ||
			rechnung.charAt(currentStartPos-1) == '+' ||
			rechnung.charAt(currentStartPos-1) == '-' ||
			rechnung.charAt(currentStartPos-1) == '(' 
			) {
				rechnung = rechnung.replace(rechnungBefore, doTeilrechnungAndGetResult(rechnungAfter));
			} else {
				rechnung = rechnung.replace(rechnungBefore, "*" + doTeilrechnungAndGetResult(rechnungAfter));
			}
		} else if(currentStartPos == 0) {
			rechnung = rechnung.replace(rechnungBefore, doTeilrechnungAndGetResult(rechnungAfter));
		}
		 else {
			rechnung = rechnung.replace(rechnungBefore, "*" + doTeilrechnungAndGetResult(rechnungAfter));
		}
		
		
		return rechnung;
	}


	private String adjustOperators(String rechnung) {
		rechnung = rechnung.replaceAll("\\-\\-", "+");
		rechnung = rechnung.replaceAll("\\+\\+", "+");
		rechnung = rechnung.replaceAll("\\+\\-", "-");
		rechnung = rechnung.replaceAll("\\-\\+", "-");
		
		//deletes the +, if it is at index 0 -> +2+2 replaced with 2+2
		if(rechnung.charAt(0) == '+') {
			rechnung = rechnung.substring(1, rechnung.length());
		}
		return rechnung;
	}
	
	
	//here I get myself two numbers, which the result is calculated of and then replaced with the original calculation
	//the method return the new calculation
	private String findNumbersAndCalculate(String rechnung, int operatorIdx, String operator) {
		boolean numOneNegativ = false;
		
		//finds out the start position of the of number one
		currentStartPos = getSurroundingOperatorIdx(rechnung, operatorIdx, true);
		if(currentStartPos == operatorIdx) {
			currentStartPos = 0;
		}
		double zahl1 = 0;
		
		//get number one
		if(negativeNumber) {
			zahl1 = Double.parseDouble(rechnung.substring(--currentStartPos, operatorIdx));
			numOneNegativ = true;
		} else {
			zahl1 = Double.parseDouble(rechnung.substring(currentStartPos, operatorIdx));
		}
		
		//find out the end index of number two (start position is after the operator index)
		currentEndPos = getSurroundingOperatorIdx(rechnung, operatorIdx, false);
		double zahl2 = Double.parseDouble(rechnung.substring(operatorIdx+1, currentEndPos));
		
		double result = getErgebnis(zahl1, zahl2, operator);
		
		String resultPlaceholder =  rechnung.replace(rechnung.substring(currentStartPos, currentEndPos), String.valueOf(result));
		//get the result
		//if number one is negative and the result of the calculation is not negative i add a "+" before the calculation
		//e.g. if I calculate -25+30 the result is 5 --> I always cut out -25+30, so I need to add that "+" before the calculation
		//otherwise if there was another calculation to do after there would be no operator -> 3-25+30)-> 35 --> 3 + 5
		if(numOneNegativ) {
			if(String.valueOf(result).charAt(0) != '-') {
				rechnung = rechnung.replace(rechnung.substring(currentStartPos, currentEndPos), "+" + String.valueOf(result));
			} else {
				rechnung = resultPlaceholder;
			}
		} else {
			rechnung = resultPlaceholder;
		}	
		
		return rechnung;
	}
	
	
	//here I find out, where the surrounding operators of my current calculation are positioned, 
	//e.g. 2*3-5 --> left side is index 0, right side is index 3
	private int getSurroundingOperatorIdx(String rechnung, int midOperatorIdx, Boolean leftSide) {
		midOperatorIdx++;
		negativeNumber = false;
		int idx = -1;
		int[] operatorIndexes = new int[4];
		
		if(leftSide) {
			int plusIdx = rechnung.substring(0, midOperatorIdx-1).lastIndexOf("+");
			int minusIdx = rechnung.substring(0, midOperatorIdx-1).lastIndexOf("-");
			int multiplyIdx = rechnung.substring(0, midOperatorIdx-1).lastIndexOf("*");
			int divisionIdx = rechnung.substring(0, midOperatorIdx-1).lastIndexOf("/");
			
			
			//here the indexes of each operator are added to the array
			operatorIndexes[0] = plusIdx;
			operatorIndexes[1] = minusIdx;
			operatorIndexes[2] = multiplyIdx;
			operatorIndexes[3] = divisionIdx;
			
			for(int i = 0; i < operatorIndexes.length; i++) {
				if(operatorIndexes[i] > idx) {
					if(midOperatorIdx-1 != operatorIndexes[i]) {	
						if(i == 1) {
							negativeNumber = true;
						} else {	
							negativeNumber = false;
						}
						idx = operatorIndexes[i];
					} 
				}
			}
 			if(idx == -1) {
 				idx = -1;
 			} 
 			
 			idx++;
		} 
		
		else {
			idx = rechnung.length();
			
			int plusIdx = rechnung.indexOf("+", midOperatorIdx);
			int minusIdx = rechnung.indexOf("-", midOperatorIdx);
			int multiplyIdx = rechnung.indexOf("*", midOperatorIdx);
			int divisionIdx = rechnung.indexOf("/", midOperatorIdx);
			
			
			operatorIndexes[0] = plusIdx;
			operatorIndexes[1] = minusIdx;
			operatorIndexes[2] = multiplyIdx;
			operatorIndexes[3] = divisionIdx;
			
			for(int i = 0; i < operatorIndexes.length; i++) {
				if(operatorIndexes[i] < idx && operatorIndexes[i] != -1) {
					if(midOperatorIdx-1 != operatorIndexes[i]) {
						if(i == 1 && operatorIndexes[i] == midOperatorIdx) {
							
						} else {
							idx = operatorIndexes[i];
						}
					}
				}
			}
 			if(idx == -1) {
 				idx = rechnung.length();
 			} 
 		}
			
		return idx;
		
	}
	
	
	
	//needs two doubles(the numbers) and an operator - then calculates a result and returns it
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
