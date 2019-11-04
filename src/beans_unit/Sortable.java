package beans_unit;

public interface Sortable <Ge> extends Facturable{
	
/*HERE MUST BE SUPER_METHOD_SPRING!!!
*..this superMethodSpring() must recognize input_data
* and indepandently generate methods for extracting data
*/
//	void set_list_foto(Ge id);
//	public Ge get_list_foto();
//	
//	void set_list_copy(Ge id);
//	public Ge get_list_copy();
//	
//	void set_list_print(Ge id);
//	public Ge get_list_print();
//	
//	void set_list_baget(Ge id);
//	public Ge get_list_baget();
//	
//	void set_list_fotolab(Ge id);
//	public Ge get_list_fotolab();
//	
//	void set_list_sphera(Ge id);
//	public Ge get_list_sphera();
//	
//// technic
//	void set_list_nicom(Ge id);
//	public Ge get_list_nicom();
//	
//	void set_list_pults(Ge id);
//	public Ge get_list_pults();
//// last
//	
//	void set_list_other(Ge id);
//	public Ge get_list_other();
	
//card data
	
	void setListCardData(Ge id);
	public Ge getListCardData();
	
//..simple Integer block------------------
	
	public void setIncome(int income);
	public int getIncome();
	    
	public void setPayment(int payment);
	public int getPayment();
	 
//	 public void set_sber(int sber);
//	 public int get_sber();
//	    
//	 public void set_nicom(int nicom);
//	 public int get_nicom();
//	 
//	 public void set_pults(int pults);
//	 public int get_pults();
////..simple set_foto
//	 public void set_foto(int foto);
//	 public int get_foto();
//	    
//	 public void set_copy(int copy);
//	 public int get_copy();
//	 
//	 public void set_print(int print);
//	 public int get_print();
	 
//===minus===
	 
//	 public void set_nicom_minus(int nicom_minus);
//	 public int get_nicom_minus();
//	 
//	 public void set_pults_minus(int pults_minus);
//	 public int get_pults_minus();
//	 
//	 public void set_baget_minus(int baget_minus);
//	 public int get_baget_minus();
//	 
//	 public void set_fotolab_minus(int fotolab_minus);
//	 public int get_fotolab_minus();
	
}
