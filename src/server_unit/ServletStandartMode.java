package server_unit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import beans_unit.*;
import recognition_and_initialization_unit.*;

/**
 * ServletStandartMode предназначен для:
 * ...
 * @author user
 */
@WebServlet("/ServletStandartMode")
public class ServletStandartMode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String addressSaga = "C:\\Users\\user\\eclipse-workspace\\Point_one(Web)\\saga.txt";
	FrameDay day;
	
	public ServletStandartMode() {
		super();
    }
	
	/**
	 * doPost содержит 2 локических процесса
	 * first: распознавание пользовательского текста с html-страницы
	 * и формирование отчета за день (DayReport), с выводом его на html-страницу
	 * second: формирование истории в json-формате
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("..servlet_standart_mode ...method post");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");	
		initDay(request.getParameter("facture"));	//..first logical process
		response.getWriter().write(getDayReport());

		//engageSaga();	//..second logical process
		Saga saga = new Saga(addressSaga);
		System.out.println(saga.getSaga().length);
		for(int i = 0; i < saga.getSaga().length; i++) {
			initDay(getText(saga.getSaga()[i]));
			Saga_x sg_x = new Saga_x("C:\\Users\\user\\eclipse-workspace\\Point_one(Web)\\sg.txt");
			sg_x.addToSaga(day);
			
		}
		System.out.println(getText(saga.getSaga()[3]));
		
		Saga_x sg_x = new Saga_x("C:\\Users\\user\\eclipse-workspace\\Point_one(Web)\\sg.txt");
		System.out.println(sg_x.getSaga()[3].getDate());
		sg_x.addToSaga(day);
		
		
		System.out.println("..modul PrintCashCheck <off>");	//..modul PrintCashCheck
		System.out.println("..end servlet_standart_mode");	//..for consol desing
		System.out.println();
	}
	
	private String getText(beans_unit.Saga.Day day_x) {
		String s = "";
		s += day_x.getDate() + "\n";
		s += "касса утро " + day_x.getBeginCash() + "\n";
		for(int i = 0; i < day_x.getFacture().size(); i++) {
			s += day_x.getFacture().get(i) + "\n";
		}
		s += "зп " + day_x.getSalary() + "\n";
		s += "касса вечер " + day_x.getEndCash();
		
		return s;
	}

	private void initDay(String webText) throws IOException {
		this.day = new Day();
		new Recognize(webText, day);
	}

	private String getDayReport() throws IOException {
		SortDay sort_day = new SortDay();		 
		new DeepRecognize(day, sort_day);
		
//..new approach by Yong: object of sort_day --convert--> to json
		Gson json = new Gson();
		String json_day = "";
		String json_sort_day = "";
		json_day = json.toJson(day);
		json_sort_day = json.toJson(sort_day);	
//..end
		String result = concatJson(json_day, json_sort_day);
	return result;
	}
	
	private void engageSaga() throws IOException {
		Saga saga = new Saga(addressSaga);
		saga.addToSaga(day);
		System.out.println("lenght of array<Day>: " + saga.getSaga().length);
	}
	
	private String concatJson(String json_one, String json_two) {
		String result = json_one.substring(0, json_one.length() - 1) + "," 
		+ json_two.substring(1, json_two.length());	
	return result;
	}
}
