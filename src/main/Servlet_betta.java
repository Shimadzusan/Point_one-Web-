package main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




//import service.Buffer;
//import service.Hamma;
//import service.Sample;

@WebServlet("/Servlet_betta")
public class Servlet_betta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public Servlet_betta() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am servlet_one ...method post");
		
		request.setCharacterEncoding("utf-8");
//=========================================================================================	
		String web_text = request.getParameter("statement") + " ";//плюс пробел - временный костыль
		
		Frame_day day = new Day();
		Sortable sort_day = new Sort_day();   
		  
		Recognize recognize = new Recognize(web_text, day);		 
		Deep_Recognize deep = new Deep_Recognize(day, sort_day);
		
		System.out.println(web_text);
		Buffer.text = web_text;
		Buffer.date = day.get_date();
		Buffer.begin_cash = day.get_begin_cash();
		
		//!!!
		response.sendRedirect("index.jsp");
		System.out.println(day.get_date());
		
		new Json_history( day, sort_day);
		
//for consol desing
		System.out.println("======================================");
		System.out.println();
		
	}

}
