package server_unit;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans_unit.*;
import recognition_and_initialization_unit.*;

@WebServlet("/ServletHamma")
public class ServletHamma extends HttpServlet {
	private static final long serialVersionUID = 1L;
		public ServletHamma() {
			super();
	    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am servlet_hamma ...method post");
		
		request.setCharacterEncoding("utf-8");

		String web_text = request.getParameter("facture"); //change on facture!
		String date_one = request.getParameter("date_one");
		String date_two = request.getParameter("date_two");
		String flag = request.getParameter("flag_today_data");
		/*flag_today_data*/
		System.out.println("one: " + date_one);
		System.out.println("two: " + date_two);
		System.out.println("flag: " + flag);
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
/*block of the creating necessary objects for work,
  now it is three objects: Day, SortDay and Saga */
		Day day = new Day();
		SortDay sort_day = new SortDay();
		Saga saga = new Saga("C:\\Users\\user\\eclipse-workspace\\Point_one(Web)\\saga.txt");
		
		new Recognize(web_text, day);		 
		new DeepRecognize(day, sort_day);
		
		System.out.println("lenght of array<Day>: " + saga.getSaga().length);
//..creating necessary object for analizis
		ArrayList<beans_unit.Day> day_list = new ArrayList<beans_unit.Day>();
			for(int i = 0; i < saga.getSaga().length; i++) {
				day_list.add(saga.getSaga()[i]);
			}
//..analisis
		TimeManagment tm = new TimeManagment();
		ArrayList<Day> final_list = (ArrayList<Day>) tm.getInterval(date_one, date_two, day_list);
		System.out.println(final_list.size());
		
		SortDay sort_day_two = new SortDay();
		Day day_two = new Day();
			for(Day item : final_list){
				System.out.print(item.getDate() + " ");
				new Recognize(item);//where facture??
				new DeepRecognize(item, sort_day_two);
//..analisis 15-11-19
				SortDay for_intermediate_analisis = new SortDay();
				new DeepRecognize(item, for_intermediate_analisis);
				System.out.println(for_intermediate_analisis.getListNicom() + " total: " + for_intermediate_analisis.getNicom());
			}
//..here we must get interval_array<Day>
	
//..new approach by Yong: object of sort_day --convert--> to json
		Gson json = new Gson();
		
		String json_day = "";
		String json_sort_day = "";
//..the code for toggle checkbox at html, "use only today data" 
			if(flag.equals("true")) {
				json_day = json.toJson(day);
				json_sort_day = json.toJson(sort_day);
			}
			else {
				json_day = json.toJson(day_two);
				json_sort_day = json.toJson(sort_day_two);
			}
//..end
		String to_jscript = concatJson(json_day, json_sort_day);
		response.getWriter().write(to_jscript);
//..add to our history
		saga.addToSaga(day);
		
//for consol desing
		System.out.println("======================================");
		System.out.println();
	}

	private String concatJson(String json_one, String json_two) {
		String result = json_one.substring(0, json_one.length() - 1) + "," 
		+ json_two.substring(1, json_two.length());
		
	return result;
	}

}
