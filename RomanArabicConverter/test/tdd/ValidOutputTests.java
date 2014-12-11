package tdd;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ValidOutputTests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

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

}
