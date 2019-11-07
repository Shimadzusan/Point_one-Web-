package beans_unit;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

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
	
	public boolean addToSaga(beans_unit.Day day) {
		ArrayList<beans_unit.Day> day_list = new ArrayList<beans_unit.Day>();
		for(int i = 0; i < getSaga().length; i++) {
			day_list.add(getSaga()[i]);
		}
		return true;
	}
	
	public boolean verifySaga() {
		return true;
	}

}
