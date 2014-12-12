/*******************************************************************************
 * Copyright (c) 2012 Gary F. Pollice
 * 
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  * Contributors:
 *    gpollice
 *    rpdabrowski
 *******************************************************************************/

package tdd;

/**
 * <p>
 * This class implements a converter that takes a string that represents a
 * number in either Arabic or Roman numeral form and offers methods that will
 * return either the integer value or a string representing the value in Roman
 * numeral form.
 * </p>
 * <p>
 * Roman numerals are specified and presented as strings according to the <a
 * href="http://en.wikipedia.org/wiki/Roman_numerals#Reading_Roman_numerals">
 * Reading Roman Numerals</a> section of the Wikipedia Roman Numerals Page.
 * </p>
 * <p>
 * <strong>NOTE</strong>:<br/>
 * You will not need to handle alternate forms like "IIII" etc. Also, the
 * acceptable range of values for numbers is 1..3999.
 * 
 * @author rpdabrowski, gpollice
 * @version 2.0.1
 */
public class RomanArabicConverter {
	/**
	 * Constructor that takes in a string. The string should contain either a
	 * valid Roman numeral or a valid Arabic numeral. The string can have
	 * leading and/or trailing spaces. There are no spaces within the actual
	 * number characters. If the string represents an Arabic number, it may be
	 * positive or negative. It will never be larger than a value that can fit
	 * into an int.
	 * 
	 * @param value
	 *            the string representing the Roman or Arabic number.
	 * @throws MalformedNumberException
	 *             if the string (less leading and trailing spaces) does not
	 *             represent a valid Roman or Arabic number.
	 *             <strong>NOTE</strong>: an Arabic number may be out of the
	 *             acceptable range and will still be accepted by this
	 *             constructor.
	 */

	String value;
	Boolean isArabic;

	public RomanArabicConverter(String value) throws MalformedNumberException {
		if(value == null){
			throw new MalformedNumberException("input must not be null");
		}
		
		// trim all the whitespace
		value = removeWhitespace(value);
		
		// check to see if the result is valid and what type it is.
		switch(checkValid(value)){
			case 1:
				this.isArabic = true;
				break;
			case 2:
				this.isArabic = false;
		}	
		this.value = value;
	}

	/**
	 * @return the integer value of the number given
	 */
	public int toArabic() {
		int sum = 0;
		int i = 0;		

		if(!isArabic){
			//iterate through the roman numerals
			while(i < this.value.length()){
				char ch = this.value.toCharArray()[i];
				int num = romanLookupValues(ch);

				i++;

				if (i == value.length()) {
					//last number in sequence, never have to worry about subtracting
					sum += num;
				}
				else {
					//if the next number is greater, need to subtract the first num from the second
					int num2 = romanLookupValues(this.value.charAt(i));

					if (num2 > num) {
						sum += (num2 - num);
						i++;
					}
					else {
						//simple addition if the above case is not true in this instance
						sum += num;
					}
				}
			}
		}
		else{
			sum = Integer.parseInt(value);
		}
		return sum;
	}

	/**
	 * @return the string that represents the value of the number as a Roman
	 *         numeral.
	 * @throws ValueOutOfBoundsException
	 *             if the number is too small or too large to be represented
	 *             using Roman numerals as specified in <a href=
	 *             "http://en.wikipedia.org/wiki/Roman_numerals#Reading_Roman_numerals"
	 *             > Reading Roman Numerals</a>
	 */
	public String toRoman() throws ValueOutOfBoundsException {
		String output = new String();
		int num = 0;
		
		if(isArabic){
			num = Integer.parseInt(value);
			if(num < 1){
				throw new ValueOutOfBoundsException("Input must be non-negitive.");
			}
			else if(num > 3999){
				throw new ValueOutOfBoundsException("Input must be less than 3999");
			}
			
			int div = num/5;
			
			int Mnum = div / 200;
			div -= 200*Mnum;
			
			int Cnum = div / 100;
			div -= 100*Cnum;
			
			int Xnum = div / 2;
			div -= 2*Xnum;
			
			//div is now the number of I's
			//roman sequence construction
			String romSeq = new String();
			int i;
			
			for(i = 0; i <= Mnum; i++){
				romSeq += "M";
			}
			
			//check for any weird stuff with C
			if(Cnum >= 5){
				//romSeq += "D";
				Cnum -= 5;
				
				if(Cnum == 4){ //meaning 
					romSeq += "CM";
				}else{
					romSeq += "D";
					for(i=0; i <= Cnum; i++){
						romSeq += "C";
					}
				}
			}else{
				if(Cnum == 4){ //meaning 
					romSeq += "CD";
				}else{
					for(i=0; i <= Cnum; i++){
						romSeq += "C";
					}
				}
			}
			
			//now check for weird stuff with X	
			if(Cnum >= 5){
				Cnum -= 5;
				
				if(Cnum == 4){ //meaning 
					romSeq += "XC";
				}else{
					romSeq += "L";
					for(i=0; i <= Cnum; i++){
						romSeq += "X";
					}
				}
			}else{
				if(Cnum == 4){ //meaning 
					romSeq += "XL";
				}else{
					for(i=0; i <= Cnum; i++){
						romSeq += "X";
					}
				}
			}
			
			//now to check for weird stuff with I
			if(Cnum >= 5){
				//romSeq += "D";
				Cnum -= 5;
				
				if(Cnum == 4){ //meaning 
					romSeq += "IX";
				}else{
					romSeq += "V";
					for(i=0; i <= Cnum; i++){
						romSeq += "I";
					}
				}
			}else{
				if(Cnum == 4){ //meaning 
					romSeq += "IV";
				}else{
					for(i=0; i <= Cnum; i++){
						romSeq += "I";
					}
				}
			}
			
			output = romSeq;
			
		}else{
			output = value;
		}
		return output;
	}

	private String removeWhitespace(String input) throws MalformedNumberException {
		
		String output = new String();

		// walk the string to look for whitespace and remove
		for (int i = 0; i < input.length(); i++) {
			String c = input.substring(i, i + 1);
			if (!c.equals(" ") && !c.equals("\t"))
				output += c;
		}
		return output;
	}

	private int checkValid(String input) throws MalformedNumberException {

		// check to see if the string is a number
		if(input.matches("[-0-9]+")){
			return 1;
		}
		
		// check to see if the string is a Roman numeral
		else if (input.matches("[IVXLCDM]+")) {
			if(input.matches("/(.)\1{4,}/")){
				throw new MalformedNumberException("Contains illegal repetition");
			}
			return 2;
		} else {
			throw new MalformedNumberException("Contains illegal characters");
		}
	}

	private int romanLookupValues(char input){
		switch(input){
			case 'I':  
				return 1;
            case 'V':  
				return 5;
            case 'X':  
				return 10;
            case 'L':  
				return 50;
            case 'C':  
				return 100;
            case 'D':  
				return 500;
            case 'M':  
				return 1000;
		}
		return 0;
	}
}
