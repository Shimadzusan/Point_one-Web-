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


@WebServlet("/ServletDelta")
public class ServletDelta extends HttpServlet {
	private static final long serialVersionUID = 1L;
		public ServletDelta() {
			super();
	    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("I am servlet_delta ...method post");
		
		request.setCharacterEncoding("utf-8");

		//String web_text = request.getParameter("facture"); //change on facture!
		String date_x = request.getParameter("date_x");
		System.out.println("do: " + date_x);
		
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
//..deals analisis		
		ArrayList<Day> day_interval = Buffer.getFinal_list();
		ArrayList<Deal> deals = new ArrayList<Deal>();
		new DealsRecognize(day_interval, deals, "фнд");
		System.out.println("deals size: " + deals.size());
//..adaptize
//		AdapterDeals adapter = new AdapterDeals(deals.get(2));
//		System.out.println("adapter: " + adapter.getCash_gain());
//		System.out.println("adapter: " + adapter.getOnlineIncome());
		ArrayList<AdapterDeals> adapter = new ArrayList<AdapterDeals>();
			for(int i = 0; i < deals.size(); i++) {
				AdapterDeals adpt = new AdapterDeals(deals.get(i));
				adapter.add(adpt);
			}
			System.out.println("a-r " + adapter.size());
//.....
		Gson json = new Gson();
		String json_deals = json.toJson(deals);
		response.getWriter().write(json_deals);
//..end

//for consol desing
		System.out.println("++++++++++++++++++++++++++++++++++");
		System.out.println();
	}

	private String concatJson(String json_one, String json_two) {
		String result = json_one.substring(0, json_one.length() - 1) + "," 
		+ json_two.substring(1, json_two.length());
		
	return result;
	}

}