package makiwara_unit;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import beans_unit.*;
import recognition_and_initialization_unit.*;

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
		}
		catch (IOException e) {
			e.printStackTrace();
			//..add yet youself catch
		}
		  
		System.out.println("lenght of array<Day>: " + saga.getSaga().length);
		//saga.addToSaga(day);
		
//-----work with Day array--------------------
		ArrayList<beans_unit.Day> day_list = new ArrayList<beans_unit.Day>();
		for(int i = 0; i < saga.getSaga().length; i++) {
			day_list.add(saga.getSaga()[i]);
		}
		
		for(int i = 0; i < day_list.size(); i++) {
			//System.out.println(day_list.get(i).getDate());
		}
//..date
/*..main variable: date_one, date_two, general_array_list<Day>, final_array_list<Day> 
* 01.07.2019 ~~~ 23.07.2019 
*/
		System.out.println();
		String date_one = "18.07.2019";
		String date_two = "22.07.2019";
//		String date_check = "";//..general_array
//		
//		String date_output_array = "";//..operational_array
//		
		TimeManagment tm = new TimeManagment();//..create necessary object for work
		ArrayList<Day> final_list = (ArrayList<Day>) tm.getInterval(date_one, date_two, day_list);
		System.out.println(final_list.size());
		SortDay sort_day_two = new SortDay();
		
		for(Day item : final_list){
			System.out.println(item.getDate());
			new DeepRecognize(item, sort_day_two);
			System.out.println(item.getDate() + " total " + sort_day_two.getNicom());
		}
		System.out.println("total foto: " + sort_day_two.getNicom());
		System.out.println();
//..here we must get interval_array<Day>
//................................
		
		LocalDate myObj = LocalDate.now(); // Create a date object
	    System.out.println(myObj); // Display the current date
	    LocalDate date2 = LocalDate.of(2019, 10, 30);
	    Date dd = new Date(20191029);
	    //System.out.println(dd.getDay());
	    LocalDate date3 = null;
	    date3 = date3.parse("2018-11-07");
	    System.out.println("compare: " + myObj.compareTo(date3));
//-------end----------------------------------

	}
}
