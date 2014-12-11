package tdd;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class inputFilterTests {

	//input filtering tests
	
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

}
