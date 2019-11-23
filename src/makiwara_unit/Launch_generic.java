package makiwara_unit;
import java.util.ArrayList;

public class Launch_generic {

	public static void main(String[] args) {
		int type = 10;
		D d = new D(type);
		ArrayList<Integer> acc = new ArrayList<Integer>();
		acc.add(200);
		d.setCash_gain(acc);
		System.out.println(d.getCash_gain());
		
		D<String> d2 = new D<String>("hundert");
		ArrayList<String> acc2 = new ArrayList<String>();
		acc2.add("hund");
		d2.setCash_gain(acc2);
		System.out.println(d2.getCash_gain());

	}

}


class D <Essence> {
	String date;
	String type_of_deal;
	//ArrayList<String> cash_gain;
	Essence type;
	ArrayList<Essence> cash_gain;
	
	D(Essence type){
		
	}

	public String getType_of_deal() {
		return type_of_deal;
	}

	public void setType_of_deal(String type_of_deal) {
		this.type_of_deal = type_of_deal;
	}

	public ArrayList<Essence> getCash_gain() {
		return cash_gain;
	}

	public void setCash_gain(ArrayList<Essence> cash_gain) {
		this.cash_gain = cash_gain;
	}

}

