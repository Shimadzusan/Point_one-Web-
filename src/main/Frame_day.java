package main;

import java.util.List;

public interface Frame_day extends Facturable{
	 
    public void set_date(String date);
    public String get_date();
    
    public void set_begin_cash(int begin_cash);
    public int get_begin_cash();
    
    public void set_end_cash(int end_cash);
    public int get_end_cash();
    
    public void set_facture(String list);
    //public List<String> get_facture();
    
    public void set_salary(int salary);
    public int get_salary();
}
