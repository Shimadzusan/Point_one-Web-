package makiwara_unit;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import beans_unit.*;
import recognition_and_initialization_unit.DeepRecognize;
import recognition_and_initialization_unit.Recognize;
import recognition_and_initialization_unit.SagaInitialization;

public class Launch {

	public static void main(String[] args) throws IOException {
//---creating necessary objects for work--------------
		beans_unit.Day day = new beans_unit.Day();
		SortDay sort_day = new SortDay();
		Saga saga = new Saga("saga.txt");
		
//..and yet one object, such called Saga!!!
//..so we have: Day-obj, SortDay-obj and Saga-obj
//..stage of recognition and initialisation main objects: Day and SortDay
		
		try {
			new Recognize("test\\test3.txt", day);
			new DeepRecognize(day, sort_day);
			//new SagaInitialization("saga.txt", day, saga);
//			System.out.println(si.getSaga().getSaga().length);
//			saga.setSaga(si.getSaga().getSaga());
		}
		catch (IOException e) {
			e.printStackTrace();
			//..add yet youself catch
		}
		  
		System.out.println(saga.getSaga().length);
//get List with Day-object
//		ArrayList<beans_unit.Day> day_list = new ArrayList<beans_unit.Day>();
//			for(int i = 0; i < saga.getSaga().length; i++) {
//				day_list.add(saga.getSaga()[i]);
//			}
//..our any manipulation
//		for(int i = 0; i < day_list.size(); i++ ) {
//			System.out.println(day_list.get(i).getDate() + " salary: " +  
//		day_list.get(i).getSalary() + " begin_cash: " + day_list.get(i).getBeginCash());
//			//plus SortDay_data
//			new DeepRecognize(day_list.get(i), sort_day);
//		}
//		System.out.println("total foto: " + sort_day.getFoto());
//..only for exemple
/*
		FrameDay exemple = new Day();
		ArrayList<FrameDay> list = new ArrayList();
*/
		

		
//16-00
/*			
		if(!saga.getSaga()[saga.getSaga().length - 1].getDate().equals(day.getDate())) {
			System.out.println("yes do add");
			day_list.add(day); //if date1 == date2 attention don't add!!
		}
		else {
			//..replacement
		}
System.out.println("date1: " + saga.getSaga()[saga.getSaga().length - 1].getDate());
System.out.println("date2: " + day.getDate());
		
		Saga.Day[] d = new Saga.Day[day_list.size()];
		
		for(int i = 0; i < day_list.size(); i++) {
			d[i] = saga.convertDay(day_list.get(i));
		}
		
		saga.setSaga(d);
		
		
//		String json = gson.toJson(saga);
//		//System.out.println(json);
//		
//		FileOutputStream fos = new FileOutputStream("saga.txt");
//	    
//		byte[] buffer2 = json.getBytes();
//	        	fos.write(buffer2, 0, buffer2.length);
//	
//	        	fos.close();
*/	
	}

}
