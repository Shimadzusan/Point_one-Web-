package main;

import java.util.ArrayList;
import java.util.List;

public class Day implements Frame_day, Facturable{
	 String date;
	 
	 	List<String> facture;
		int begin_cash;
		int end_cash;
		int salary;
		
		Day() {
			facture = new ArrayList();
		}
	    
	    public void set_date(String date) {
	        this.date = date;
	    }
	    
	    public String get_date() {
	        return this.date;
	    }
	    
	    public void set_begin_cash(int begin_cash) {
	        this.begin_cash = begin_cash;
	    }
	    
	    public int get_begin_cash() {
	        return this.begin_cash;
	    }
	    
	    public void set_end_cash(int end_cash) {
	        this.end_cash = end_cash;
	    }
	    
	    public int get_end_cash() {
	        return this.end_cash;
	    }
	    
	    public void set_facture(String list) {
	    	facture.add(list);
	        //this.facture = list;
	    }
	    
	    public List<String> get_facture() {
	        return this.facture;
	    }
	    
	    public void set_salary(int salary) {
	        this.salary = salary;
	    }
	    
	    public int get_salary() {
	        return this.salary;
	    }
}
