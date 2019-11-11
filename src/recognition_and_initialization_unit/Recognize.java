package recognition_and_initialization_unit;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import beans_unit.*;

public class Recognize extends Head {
/*
 * this class recognize patterns from statement_data(statement.txt)
 * and initialize object_Day 
 */
	
	String address = "";
	String text = "";
	Day day;		//..or FrameDay day;
	List<String> day_facture;
	String[] day_list;
	
	public Recognize(Day day) {
		this.day = day;
	}
//..how to realize two same constructor? with text and address
	public Recognize(String text, FrameDay day) throws IOException {
		//this.address = address;
		this.day = (Day) day;
		day_facture = new ArrayList();
		this.text = text;
		day_init();
		
		day_facture = day.getFacture();
	}
	
	String get_text() throws IOException {
		FileInputStream fin = new FileInputStream(address);  
	        byte[] buffer = new byte[fin.available()];
	        fin.read(buffer, 0, buffer.length);
	        String s = new String(buffer, charset);
	        		//System.out.println(s);
	return s;
	}

//begin day_init complex, this complex contains 3 methods
	private void day_init() {
//***to parse the text
		day_list = text.split("\\n"); //total notes for day (code 13 10 is new line(\\r\\n))
			for(int i = 0; i < day_list.length; i++) {
	        	sort_kind(day_list[i]);
	        }
	}

	public void sort_kind(String element) {
//cash
		if(element.contains("касса")) {
			if(element.contains("утро")) day.setBeginCash(get_number(element));
			if(element.contains("вечер")) day.setEndCash(get_number(element));
				return;
		}
//date
		if(element.contains(".")) {
			day.setDate(element); 
				return;
		}
//salary
		if(element.contains("зп")) {
			day.setSalary(get_number(element));
				return;
		}			
//facture_surface
		day.setFacture(element);
	}
	
	public int get_number(String text) {
		char[] ch = text.toCharArray();
		String number = "";
			for(int i = 0; i < ch.length; i++) {
				if(Character.isDigit(ch[i]))number += "" + ch[i];
			}
			
			if(number.length() == 0)number = "0";
			
	return Integer.parseInt(number);
	}
}
