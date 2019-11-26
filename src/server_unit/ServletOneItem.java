package server_unit;
import java.io.FileReader;
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
		System.out.println("..servlet_one_item ...method post");		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		String json_from_js = request.getParameter("date_x");
		System.out.println("json in servlet: " + json_from_js);
//..
		Gson gson = new Gson();
		OneItem oi = gson.fromJson(json_from_js, OneItem.class);
		//System.out.println("exp: " + oi.isExp());//--
		String type_deal = oi.getItm();//..get item, type of deal from html-page
					if(type_deal.endsWith("ником сервис"))type_deal = "ником";//..cstl
		
//..deals analisis		
			ArrayList<Day> day_interval = Buffer.getFinal_list();
			ArrayList<Deal> deals = new ArrayList<Deal>();
				
			new DealsRecognize(day_interval, deals, type_deal);
			System.out.println("deals size: " + deals.size());
				
//..how match colum?
//			String s = getHtmlTable(deals);
//..end
		
		response.getWriter().write(getHtmlTable(deals, oi));
		System.out.println("..end servlet_one_item");

	}

	private String concatJson(String json_one, String json_two) {
		String result = json_one.substring(0, json_one.length() - 1) + "," 
		+ json_two.substring(1, json_two.length());
		
	return result;
	}

	private String getHtmlTable(ArrayList<Deal> deals, OneItem oi) {
		
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
		
		String s = "<table style=\"width: 80%\">";
		for(int i = 0; i < deals.size(); i++) {
			s = s + "<tr><td style=\"vertical-align: top\">" + deals.get(i).getDate() + "</td><td>";
				for(int k = 0; k < adapter.get(i).getCash_gain().size(); k++) {
					s = s + adapter.get(i).getCash_gain().get(k) + "&nbsp&nbsp&nbsp<br>";
				}
			
			s = s + "</tr>";
			
		}
		s = s + "</table>";
		
		
		return s;
	}
}