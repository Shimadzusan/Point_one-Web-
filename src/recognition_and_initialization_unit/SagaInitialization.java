package recognition_and_initialization_unit;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import beans_unit.Day;
import beans_unit.Saga;

public class SagaInitialization {
	Saga saga;
	Day day;
	String sourse;
	
	public SagaInitialization(String sourse, Day day, Saga saga) {
		this.saga = saga;
		this.day = day;
		this.sourse = sourse;
		initSaga(sourse);
	}
	
	public boolean initSaga(String address) {
		Gson gson = new Gson();
		try {
			this.saga.setSaga(gson.fromJson(new FileReader(sourse), Saga.class).getSaga());
//..здесь предположительно создается новый объект, с новой ссылкой, поэтому такая сложная конструкция
			
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e1) {
			e1.printStackTrace();
		}		
		return true;
	}
	
	public boolean addToSaga(Day day) {
		ArrayList<beans_unit.Day> day_list = new ArrayList<beans_unit.Day>();
		for(int i = 0; i < saga.getSaga().length; i++) {
			day_list.add(saga.getSaga()[i]);
		}
//..our any manipulation
//	for(int i = 0; i < day_list.size(); i++ ) {
//		System.out.println(day_list.get(i).getDate() + " salary: " +  
//	day_list.get(i).getSalary() + " begin_cash: " + day_list.get(i).getBeginCash());
//		//plus SortDay_data
//		new DeepRecognize(day_list.get(i), sort_day);
//	}
//	System.out.println("total foto: " + sort_day.getFoto());
//..only for exemple
/*
	FrameDay exemple = new Day();
	ArrayList<FrameDay> list = new ArrayList();
*/
	

	
//16-00
	
	if(!saga.getSaga()[saga.getSaga().length - 1].getDate().equals(day.getDate())) {
		System.out.println("yes do add");
		day_list.add(day); //if date1 == date2 attention don't add!!
	}
	else {
		//..replacement
	}
System.out.println("date1: " + saga.getSaga()[saga.getSaga().length - 1].getDate());
System.out.println("date2: " + day.getDate());
		return true;
	}

}
