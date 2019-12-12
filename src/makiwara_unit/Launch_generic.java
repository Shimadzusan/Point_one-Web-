package makiwara_unit;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class Launch_generic {

	public static void main(String[] args) {
		
//..version_one
		int type = 0;
		D<Integer> d = new D<Integer>(type);
		d.setFoto(250);
		
//..version_two
		ArrayList<String> list = new ArrayList<String>();
		D<ArrayList<String>> e = new D<ArrayList<String>>(list);
		list.add("250");
		list.add("250");
		e.setFoto(list);
//..recognition
		new Reco(d);
		
//..reflection
		Class abc = Nicom.class;
		Class c = beans_unit.SortDay.class;
		System.out.println(c);
		Field[] s = c.getDeclaredFields();
		System.out.println();
		for(int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
		
		

	}

}


class D <Essence> {
	String date = "";
	Essence foto;
	
	D(Essence type){
		System.out.println(type.getClass());
		this.foto = type;
	}
	
	public Essence getFoto() {
		return foto;
	}

	public void setFoto(Essence foto) {
		this.foto = foto;
	}

}

class Reco {
	Reco(D d) {
		System.out.println("reco: " + d.foto.getClass());
	}
	
	public void setFoto(int i) {
		
	}
	
	public void setFoto(ArrayList<String> list) {
			
		}
}