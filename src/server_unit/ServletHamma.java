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


@WebServlet("/ServletHamma")
public class ServletHamma extends HttpServlet {
	private static final long serialVersionUID = 1L;
		public ServletHamma() {
			super();
	    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am servlet_betta ...method post");
		
		request.setCharacterEncoding("utf-8");

		String web_text = request.getParameter("facture"); //change on facture!
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		Day day = new Day();
		SortDay sort_day = new SortDay();    
		new Recognize(web_text, day);		 
		new DeepRecognize(day, sort_day);
		
//..new approach by Yong: object of sort_day --convert--> to json
		Gson json = new Gson();
		String json_day = json.toJson(day);
		String json_sort_day = json.toJson(sort_day);	
//..end
		String to_jscript = concatJson(json_day, json_sort_day);
		response.getWriter().write(to_jscript);

		//new Json_history( day, sort_day);
		
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
