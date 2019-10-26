package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Json_history extends Head {
//.. input: sort_day and day --> output: json history(history.txt)
	Sortable sort_day;
	Frame_day day;
	String address = "C:\\1.txt";
		
	public Json_history(Frame_day day,Sortable sort_day) throws IOException {
		this.day = day;
		this.sort_day = sort_day;	
			commit_report();
			System.out.println("json(for history) article added");
			delete_last_note();
	}

	private void commit_report() throws IOException {
		FileInputStream fin = new FileInputStream(address);
			
			byte[] buffer = new byte[fin.available()];
		        fin.read(buffer, 0, buffer.length);
		        	String s = removeLastChar(new String(buffer, charset));
		        		fin.close();
		        			
		FileOutputStream fos = new FileOutputStream(address);
		      //String s2 = "дата" + "\t" + "фнд" + "\t" + "печать" + "\t" + "копия" + "\t" + "другое" + "\t" + "итого" + "\r\n";  			
			String s2 = s + ",{\"date\":\"" + day.get_date() + "\",\"begin_cash\":" + day.get_begin_cash() + 
					",\"end_cash\":" + day.get_end_cash() + ",\"salary\":" + day.get_salary();
			 
			ArrayList<String> deals = (ArrayList<String>) day.get_facture();
			for(int i = 0; i < deals.size(); i++) {
				s2 = s2 + ",\"d" + (i + 1) +"\":\"" + deals.get(i) + "\"";
			}
			s2 = s2 + "}]";
			byte[] buffer2 = s2.getBytes();
		        	fos.write(buffer2, 0, buffer2.length);
		
		        	fos.close();
	}
	private String removeLastChar(String str) {
		   return str.substring(0, str.length() - 1);
	}
		
	public void delete_last_note() throws IOException {
		new Saga();
	}
}
