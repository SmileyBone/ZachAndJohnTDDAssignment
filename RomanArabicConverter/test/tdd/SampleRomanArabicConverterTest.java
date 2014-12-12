/*******************************************************************************
 * Copyright (c) 2012 Gary F. Pollice
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    gpollice
 *    rpdabrowski
 *******************************************************************************/

package tdd;

import org.junit.Test;

/**
 * Sample test cases for the RomanArabicConverter class.
 *
 * @author rpdabrowski
 * @version Nov 30, 2014
 */
public class SampleRomanArabicConverterTest {

	//lower case input
	@Test (expected=MalformedNumberException.class)
	public void inputLowercase() throws Exception
	{
		new RomanArabicConverter("mmmm");
	}
	@Test (expected=MalformedNumberException.class)
	public void inputiM() throws Exception
	{
		new RomanArabicConverter("iM");
	}

	//not roman numbers
	@Test (expected=MalformedNumberException.class)
	public void inputNotRoman() throws Exception
	{
		new RomanArabicConverter("Hello friend");
	}
	@Test (expected=MalformedNumberException.class)
	public void inputNotRomanSingleLetter() throws Exception
	{
		new RomanArabicConverter("B");
	}

	//Tests that will through the value out of bounds
	@Test (expected=ValueOutOfBoundsException.class)
	public void negativeInput() throws Exception
	{
		new RomanArabicConverter("-5").toRoman();
	}

	@Test (expected=ValueOutOfBoundsException.class)
	public void over3999() throws Exception
	{
		new RomanArabicConverter("4000").toRoman();
	}

}
