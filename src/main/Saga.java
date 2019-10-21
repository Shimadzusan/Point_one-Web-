package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class Saga extends Head {
	String address = "C:\\1.txt";
	//String address = "[{123},{456}]";
	
	Saga() throws IOException {
		//System.out.println("I am Saga");
		
		FileInputStream fin = new FileInputStream(address);
		
		byte[] buffer = new byte[fin.available()];
	        fin.read(buffer, 0, buffer.length);
	        	String s = new String(buffer, charset);
	        			fin.close();
	 //reset "[]"  
//		String s = address;
	        s =	s.substring(1, s.length() - 1);
	        		
	    char[] char_array = s.toCharArray();
	    boolean open = false;
	    boolean close = true;
	    String obj = "";
	    ArrayList<String> json_history = new ArrayList();
	    	for(int i = 0; i < char_array.length; i++) {
	    		
	    		if(char_array[i] == '{') {
	    			open = true;
	    			close = false;
	    		}
	    		
	    		if(char_array[i] != '{' && char_array[i] != '}' && open == true) {
	    		obj = obj + char_array[i];
	    	}
	    	
	    	if(char_array[i] == '}') {
	    		json_history.add(obj);
	    		obj = "";
	    		open = false;
	    	}
	    	
	    	}
	        			
	       //System.out.println(s);
	      // System.out.println(json_history.get(1));
	       for(int i = 0; i < json_history.size(); i++) {
	    	  // System.out.println(json_history.get(i));
	    	   
	       }
	       
	       String first = (json_history.get(json_history.size() - 1)).substring(0, 19);
	       String second = (json_history.get(json_history.size() - 2)).substring(0, 19);
	       
//	       System.out.println("+++");
//	       System.out.println(first);
//	       System.out.println(first.substring(0, 19));
//	       System.out.println(second.substring(0, 19));
	       
	       if(first.equals(second)) {
	    	  // System.out.println("true");
	    	   json_history.remove(json_history.size() - 2);
	       }
	       else {
	    	   //System.out.println("false");
	       }
	       
	       //System.out.println("-----------------");
	       obj = "";
	       for(int i = 0; i < json_history.size(); i++) {
	    	  // System.out.println(json_history.get(i));
	    	   
	    	   
	    	   if(i == 0)obj += "{" + json_history.get(i) + "}";
	    	   
	    	   else obj += "," + "{" + json_history.get(i) + "}";
	    	   
	    	   
	       }
	       obj = "[" + obj + "]";
	       
	       FileOutputStream fos = new FileOutputStream(address);
	       
	       byte[] buffer2 = obj.getBytes();
       	fos.write(buffer2, 0, buffer2.length);

       	fos.close();
	}
	private void delete_last() {
		
	}
}
