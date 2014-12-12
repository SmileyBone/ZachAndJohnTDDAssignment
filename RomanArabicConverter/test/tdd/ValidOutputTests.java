package tdd;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ValidOutputTests {


	//valid output tests

	//make sure that the input for I and 1 works.
	@Test
	public void input_1_() throws Exception
	{
		assertEquals(1,   new RomanArabicConverter(" 1 ").toArabic());
		assertEquals("I", new RomanArabicConverter(" 1 ").toRoman());
	}
	@Test
	public void input_5_() throws Exception
	{
		assertEquals(5,   new RomanArabicConverter(" 5 ").toArabic());
		assertEquals("V", new RomanArabicConverter(" 5 ").toRoman());
	}
	@Test
	public void input_10_() throws Exception
	{
		assertEquals(10,   new RomanArabicConverter(" 10 ").toArabic());
		assertEquals("X", new RomanArabicConverter(" 10 ").toRoman());
	}
	@Test
	public void input_50_() throws Exception
	{
		assertEquals(50,   new RomanArabicConverter(" 50 ").toArabic());
		assertEquals("L", new RomanArabicConverter(" 50 ").toRoman());
	}
	@Test
	public void input_100_() throws Exception
	{
		assertEquals(100,   new RomanArabicConverter(" 100 ").toArabic());
		assertEquals("C", new RomanArabicConverter(" 100 ").toRoman());
	}
	@Test
	public void input_500_() throws Exception
	{
		assertEquals(500,   new RomanArabicConverter(" 500 ").toArabic());
		assertEquals("D", new RomanArabicConverter(" 500 ").toRoman());
	}
	@Test
	public void input_1000_() throws Exception
	{
		assertEquals(1000,   new RomanArabicConverter(" 1000 ").toArabic());
		assertEquals("M", new RomanArabicConverter(" 1000 ").toRoman());
	}

	@Test
	public void input_withSpacesBetween() throws Exception
	{
		assertEquals(13,   new RomanArabicConverter(" 1 3 ").toArabic());
		assertEquals("XIII", new RomanArabicConverter(" 1 3 ").toRoman());
	}
	
	@Test
	public void input_Test29Input() throws Exception
	{
		assertEquals(29,   new RomanArabicConverter(" XXIX ").toArabic());
		assertEquals("XXIX", new RomanArabicConverter(" XXIX ").toRoman());
		assertEquals("XXIX", new RomanArabicConverter(" X X I  	X 	 ").toRoman());
	}
	
	@Test
	public void input_Test8Input() throws Exception
	{
		assertEquals(8,   new RomanArabicConverter(" VIII").toArabic());
		assertEquals("VIII", new RomanArabicConverter(" VIII ").toRoman());
	}
	
	@Test
	public void input_Test9Input() throws Exception
	{
		assertEquals(9,   new RomanArabicConverter(" IX").toArabic());
		assertEquals("IX", new RomanArabicConverter(" IX ").toRoman());
	}
	
	@Test //this was made because brute was failing on the number 6.
	public void input_Test6Input() throws Exception
	{
		assertEquals(6,   new RomanArabicConverter("6").toArabic());
		assertEquals("VI", new RomanArabicConverter(" 6 ").toRoman());
		assertEquals(6,   new RomanArabicConverter("VI").toArabic());
		assertEquals("VI", new RomanArabicConverter(" VI ").toRoman());
	}
	
	@Test
	public void input_BruteInput() throws Exception
	{
		for(int i=1;i<4000;i++){
			RomanArabicConverter fixture = new RomanArabicConverter(Integer.toString(i));
			String outputString = fixture.toRoman();
			int outputNum = fixture.toArabic();
			
			assertEquals(i, outputNum);
			assertEquals(i, new RomanArabicConverter(outputString).toArabic());
		}
	}
	
}
