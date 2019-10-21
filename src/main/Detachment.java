package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Detachment {
	static String address = "history.txt";

	public static void main(String[] args) throws IOException {
		System.out.println("!");
		FileInputStream fin = new FileInputStream(address);
		
		byte[] buffer = new byte[fin.available()];
	        fin.read(buffer, 0, buffer.length);
	        	String s = (new String(buffer, "utf-8"));
	        		System.out.println(s.length());
	        			fin.close();
	        			
//	FileOutputStream fos = new FileOutputStream(address);
//	      //String s2 = "дата" + "\t" + "фнд" + "\t" + "печать" + "\t" + "копия" + "\t" + "другое" + "\t" + "итого" + "\r\n";  			
//		String s2 = s + ",{\"date\":\"" + day.get_date() + "\",\"begin_cash\":" + day.get_begin_cash() + 
//				",\"end_cash\":" + day.get_end_cash() + ",\"salary\":" + day.get_salary();
//		 
//		ArrayList<String> deals = (ArrayList<String>) day.get_facture();
//		for(int i = 0; i < deals.size(); i++) {
//			s2 = s2 + ",\"d" + (i + 1) +"\":\"" + deals.get(i) + "\"";
//		}
//		s2 = s2 + "}]";
//		byte[] buffer2 = s2.getBytes();
//	        	fos.write(buffer2, 0, buffer2.length);
//	
//	        	fos.close();

	}

}
