package beans_unit;

import java.util.ArrayList;
import java.util.List;

/*
 *..description 
 */

public class Day implements FrameDay {
	String date; 
	List<String> facture;
	int begin_cash;
	int end_cash;
	int salary;
		
	Day() {
		facture = new ArrayList();
	}
	    
	public void setDate(String date) {
		this.date = date;
	}
	    
	public String getDate() {
		return this.date;
	}
	    
	public void setBeginCash(int begin_cash) {
		this.begin_cash = begin_cash;
	}
	    
	public int getBeginCash() {
		return this.begin_cash;
	}
	    
	public void setEndCash(int end_cash) {
		this.end_cash = end_cash;
	}
	    
	public int getEndCash() {
		return this.end_cash;
	}
	    
	public void setFacture(String list) {
		facture.add(list);
	        //this.facture = list;
	}
	    
	public List<String> getFacture() {
		return this.facture;
	}
	    
	public void setSalary(int salary) {
		this.salary = salary;
	}
	    
	public int getSalary() {
		return this.salary;
	}	
}
