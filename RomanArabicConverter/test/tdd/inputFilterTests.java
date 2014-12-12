/*******************************************************************************
 * Copyright (c) 2012 Gary F. Pollice
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package tdd;

import org.junit.Test;

/**
 * input filtering test cases for the RomanArabicConverter class.
 *
 */
public class inputFilterTests {

	
	
		//tests that through malformed number exceptions
		@Test (expected=MalformedNumberException.class)
		public void inputNull() throws Exception
		{
			new RomanArabicConverter(null).toArabic();
			new RomanArabicConverter(null).toRoman();
		}
		@Test (expected=MalformedNumberException.class)
		public void inputEmptyString() throws Exception
		{
			new RomanArabicConverter("");
		}
		@Test (expected=MalformedNumberException.class)
		public void inputIIII() throws Exception
		{
			new RomanArabicConverter("IIII");
		}
		@Test (expected=MalformedNumberException.class)
		public void inputVVVV() throws Exception
		{
			new RomanArabicConverter("VVVV");
		}
		@Test (expected=MalformedNumberException.class)
		public void inputXXXX() throws Exception
		{
			new RomanArabicConverter("XXXX");
		}
		@Test (expected=MalformedNumberException.class)
		public void inputLLLL() throws Exception
		{
			new RomanArabicConverter("LLLL");
		}
		@Test (expected=MalformedNumberException.class)
		public void inputCCCC() throws Exception
		{
			new RomanArabicConverter("CCCC");
		}
		@Test (expected=MalformedNumberException.class)
		public void inputDDDD() throws Exception
		{
			new RomanArabicConverter("DDDD");
		}
		@Test (expected=MalformedNumberException.class)
		public void inputMMMM() throws Exception
		{
			new RomanArabicConverter("MMMM");
		}	
		@Test (expected=MalformedNumberException.class)
		public void inputBadRoman8() throws Exception
		{
			new RomanArabicConverter("IIX");
		}		
		
		@Test (expected=MalformedNumberException.class)
		public void inputDoubleV() throws Exception
		{
			new RomanArabicConverter("VV");
		}
		@Test (expected=MalformedNumberException.class)
		public void inputDoubleD() throws Exception
		{
			new RomanArabicConverter("DD");
		}
		@Test (expected=MalformedNumberException.class)
		public void inputDoubleL() throws Exception
		{
			new RomanArabicConverter("LL");
		}
}
