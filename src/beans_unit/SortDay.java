package beans_unit;

import java.util.ArrayList;
import java.util.List;

public class SortDay <Ge> implements Sortable {

	int income, payment, sber, nicom, pults, copy, print,
	nicom_minus, pults_minus, baget_minus, fotolab_minus, foto;
	
	ArrayList<String> list;
//===========================================================	
	Ge list_foto, list_copy, list_print, list_baget, list_fotolab, list_sphera,
	list_nicom, list_pults, list_other, list_card_data;
	
//	public void set_generic(G generic) {
//        this.generic =  generic;
//    }
//	
//	public <G> G get_generic() {
//		//if(value instanceof Integer)System.out.println("true");;
//		return (G) this.generic;
//		
//	}
//==========================================================
	public SortDay() {
		ArrayList<String> foto = new ArrayList<String>();
		foto.add("0");
		this.list_foto = (Ge) foto;
		
		ArrayList<String> copy = new ArrayList<String>();
		copy.add("0");
		this.list_copy = (Ge) copy;
		
		ArrayList<String> print = new ArrayList<String>();
		print.add("0");
		this.list_print = (Ge) print;
		
		ArrayList<String> baget = new ArrayList<String>();
		baget.add("0");
		this.list_baget = (Ge) baget;
		
		ArrayList<String> fotolab = new ArrayList<String>();
		fotolab.add("0");
		this.list_fotolab = (Ge) fotolab;
		
		ArrayList<String> sphera = new ArrayList<String>();
		sphera.add("0");
		this.list_sphera = (Ge) sphera;
		
		ArrayList<String> nicom = new ArrayList<String>();
		nicom.add("0");
		this.list_nicom = (Ge) nicom;
		
		ArrayList<String> pults = new ArrayList<String>();
		pults.add("0");
		this.list_pults = (Ge) pults;
		
		ArrayList<String> other = new ArrayList<String>();
		other.add("0");
		this.list_other = (Ge) other;
		
		ArrayList<String> card_data = new ArrayList<String>();
		card_data.add("0");
		this.list_card_data = (Ge) card_data;
	}
	
	public List<String> getFacture() {
		return null;
	}
	
	public void setIncome(int income) {
		this.income = income;
	}
	    
	public int getIncome() {
		return this.income;
	}
	    
	public void setPayment(int payment) {
		this.payment = payment;
	}
	    
	public int getPayment() {
		return this.payment;
	}
		
	public void setSber(int sber) {
		this.sber = sber;
	}

	public int getSber() {
		return this.sber;
	}
		
	public void setNicom(int nicom) {
		this.nicom = nicom;	
	}
	
	public int getNicom() {
		return this.nicom;
	}
		
	public void setPults(int pults) {
		this.pults = pults;
	}
		
	public int getPults() {
		return this.pults;
	}

	public  void setFoto(int foto) {
		this.foto = foto;	
	}
		
	public  int getFoto() {
		return this.foto;
	}
	
	public void setCopy(int copy) {
		this.copy = copy;
	}
	
	public int getCopy() {
		return this.copy;
	}
		
	public void setPrint(int print) {
		this.print = print;
	}
		
	public int getPrint() {
		return this.print;
	}
		
//minus	
	public void setNicomMinus(int nicom_minus) {
		this.nicom_minus = nicom_minus;	
	}
		
	public int getNicomMinus() {
		return this.nicom_minus;
	}
		
	public void setPultsMinus(int pults_minus) {
		this.pults_minus = pults_minus;
	}
		
	public int getPultsMinus() {
		return this.pults_minus;
	}
		
	public void setBagetMinus(int baget_minus) {
		this.baget_minus = baget_minus;
	}
		
	public int getBagetMinus() {
		return this.baget_minus;
	}
		
	public void setFotolabMinus(int fotolab_minus) {
		this.fotolab_minus = fotolab_minus;
	}

	public int getFotolabMinus() {
		return this.fotolab_minus;
	}

//generic stage	
	public Ge getListFoto() {
		return this.list_foto;
	}

	public void setListFoto(Object list_foto) {
		this.list_foto = (Ge) list_foto;		
	}
		
	public void setListCopy(Object list_copy) {
		this.list_copy = (Ge) list_copy;
	}
		
	public Ge getListCopy() {
		return this.list_copy;
	}
		
	public void setListPrint(Object list_print) {
		this.list_print = (Ge) list_print;
	}
		
	public Ge getListPrint() {
		return this.list_print;
	}
			
	public void setListBaget(Object list_baget) {
		this.list_baget = (Ge) list_baget;	
	}
		
	public Object getListBaget() {
		return this.list_baget;
	}
		
	public void setListFotolab(Object list_fotolab) {
		this.list_fotolab = (Ge) list_fotolab;
	}
		
	public Object getListFotolab() {
		return this.list_fotolab;
	}
		
	public void setListSphera(Object list_sphera) {
		this.list_sphera = (Ge) list_sphera;
	}
		
	public Object getListSphera() {
		return this.list_sphera;
	}
		
//====technic
	public void setListNicom(Object list_nicom) {
		this.list_nicom = (Ge) list_nicom;
	}
		
	public Object getListNicom() {
		return this.list_nicom;
	}
		
	public void setListPults(Object list_pults) {
		this.list_pults = (Ge) list_pults;
	}
		
	public Object getListPults() {
		return this.list_pults;
	}
		
	public void setListOther(Object list_other) {
		this.list_other = (Ge) list_other;
	}
		
	public Object getListOther() {
		return this.list_other;
	}
		
	public void setListCardData(Object list_card_data) {
		this.list_card_data = (Ge) list_card_data;
	}
		
	public Object getListCardData() {
		return this.list_card_data;
	}
}
