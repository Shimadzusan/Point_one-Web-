package makiwara_unit;

import java.io.IOException;
import java.util.ArrayList;

import beans_unit.*;
import recognition_and_initialization_unit.DeepRecognize;
import recognition_and_initialization_unit.Recognize;

public class Launch {

	public static void main(String[] args) {
		Day day = new Day();
		SortDay sort_day = new SortDay();
//..and yet one object, such called Saga!!!
//..so we have: Day-obj, SortDay-obj and Saga-obj
//..only for exemple
/*
		FrameDay exemple = new Day();
		ArrayList<FrameDay> list = new ArrayList();
*/
		
//..stage of recognition and initialisation main objects: Day and SortDay
		try {
			new Recognize("test\\test1.txt", day);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(day.getBeginCash());
		System.out.println(day.getSalary());
		
		new DeepRecognize(day, sort_day);
		System.out.println(sort_day.getFoto());
		 
	}

}
