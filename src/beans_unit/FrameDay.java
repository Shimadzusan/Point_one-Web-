package beans_unit;

public interface FrameDay extends Facturable{
	 
    public void setDate(String date);
    public String getDate();
    
    public void setBeginCash(int begin_cash);
    public int getBeginCash();
    
    public void setEndCash(int end_cash);
    public int getEndCash();
    
    public void setFacture(String list);
    //public List<String> getFacture();
    
    public void setSalary(int salary);
    public int getSalary();
}