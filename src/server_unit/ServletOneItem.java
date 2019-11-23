package server_unit;
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


@WebServlet("/ServletOneItem")
public class ServletOneItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
		public ServletOneItem() {
			super();
	    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("I am servlet_one_item ...method post");
		
		request.setCharacterEncoding("utf-8");

		//String web_text = request.getParameter("facture"); //change on facture!
		String date_x = request.getParameter("date_x");
		System.out.println("json in servlet: " + date_x);
		

	}

	private String concatJson(String json_one, String json_two) {
		String result = json_one.substring(0, json_one.length() - 1) + "," 
		+ json_two.substring(1, json_two.length());
		
	return result;
	}

}