package beans_unit;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class Saga {
	Day[] saga;
	
	public Saga() {
	//..Saga должна сама себя инициализировать?? аргументы
	//..если да, то получаем запутанный код(что-то бины, что-то не бины),
	//..но все в одном месте(классе)
	}
	
	public Saga(String address) {
		initSaga(address);
	}
	
	public Day[] getSaga() {
		return saga;
	}

	public void setSaga(Day[] saga) {
		this.saga = saga;
	}

	public class Day extends beans_unit.Day {
		
	}

	public Day convertDay(beans_unit.Day day) {
		Day d = new Day();
		d.setDate(day.getDate());
		d.setBeginCash(day.getBeginCash());
		d.setEndCash(day.getEndCash());
		d.setSalary(day.getSalary());
		d.setFacture(day.getFacture());
		return d;
	}
	
	public boolean initSaga(String address) {
		Gson gson = new Gson();
		
		try {
			setSaga(gson.fromJson(new FileReader(address), Saga.class).getSaga());
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e1) {
			e1.printStackTrace();
		}
		return true;
	}
	
	public boolean addToSaga(beans_unit.Day day) throws IOException {
		ArrayList<beans_unit.Day> day_list = new ArrayList<beans_unit.Day>();
			for(int i = 0; i < getSaga().length; i++) {
				day_list.add(getSaga()[i]);
			}
		
		if(!day_list.get(day_list.size() - 1).getDate().equals(day.getDate())) {
			day_list.add(day); //if date1 == date2 attention don't add!!
		}
		else {
			//..replacement
			day_list.remove(day_list.size() - 1);
			day_list.add(day);
		}

		Day[] new_day_array = new Day[day_list.size()];
			for(int i = 0; i < day_list.size(); i++) {
				new_day_array[i] = convertDay(day_list.get(i));
			}
		
		setSaga(new_day_array);
		Gson gson = new Gson();
		String json = "{\"saga\":" + gson.toJson(this.saga) + "}";
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\user\\eclipse-workspace\\Point_one(Web)\\saga.txt");   
		byte[] buffer2 = json.getBytes();
	        	fos.write(buffer2, 0, buffer2.length);
	        	fos.close();

		return true;
	}
	
	public boolean verifySaga() {
		return true;
	}

}
