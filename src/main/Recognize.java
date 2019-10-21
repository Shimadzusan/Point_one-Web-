package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Recognize extends Head {
/*
 * this class recognize patterns from statement_data(statement.txt)
 * and initialize object_Day 
 */
	
	String address = "";
	String text = "";
	Frame_day day;
	List<String> day_facture;
	
	String[] day_list;
	
	Recognize(Day day) {
		this.day = day;
	}
	
	Recognize(String text, Frame_day day) throws IOException {
		//this.address = address;
		this.day = day;
		day_facture = new ArrayList();
		this.text = text;
		day_init();
		
		day_facture = day.get_facture();
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
		 day_list = text.split("\\r\\n"); //total notes for day (code 13 10 is new line)
		 								  // ..from statement.txt
		  for(int i = 0; i < day_list.length; i++) {
	        	sort_kind(day_list[i]);
	        }
	}

	public void sort_kind(String element) {
		
//cash
		if(element.contains("касса")) {
			if(element.contains("утро")) day.set_begin_cash(get_number(element));
			if(element.contains("вечер")) day.set_end_cash(get_number(element));
				return;
		}
//date
		if(element.contains(".")) {
			day.set_date(element); 
				return;
		}
//salary
		if(element.contains("зп")) {
			day.set_salary(get_number(element));
				return;
		}			
//facture_surface
		day.set_facture(element);
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
