package test;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;

import beans_unit.Day;
import recognition_and_initialization_unit.Head;
import recognition_and_initialization_unit.Recognize;

public class RecognizeTest extends Head {

	@Test
	public void testFactureOne() throws IOException {
		Day day = new Day();
		new Recognize("test\\test1.txt", day);
		int check_number = day.getFacture().size();
		int expected = 7;
		assertEquals(expected, check_number);
	}
	
	@Test
	public void testFactureTwo() throws IOException {
		Day day = new Day();
		new Recognize("test\\test2.txt", day);
		int check_number = day.getFacture().size();
		int expected = 10;
		assertEquals(expected, check_number);
	}
	
	@Test
	public void testDate() throws IOException {
		Day day = new Day();
		new Recognize("test\\test1.txt", day);
		String check_date = day.getDate();
		String expected = "16.05.2019";
		check_date = check_date.substring(1, 11);//..attention Day.date contains two excess bytes
		assertTrue(check_date.equals(expected));
	}
}
