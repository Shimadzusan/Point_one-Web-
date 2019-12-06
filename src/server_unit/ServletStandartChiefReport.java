package server_unit;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans_unit.*;
import recognition_and_initialization_unit.*;


@WebServlet("/ServletStandartChiefReport")
public class ServletStandartChiefReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
		public ServletStandartChiefReport() {
			super();
	    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("..servlet_standart_chief_report ...method post");		
		request.setCharacterEncoding("utf-8");
	
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		String json_from_js = request.getParameter("data_s");
		System.out.println("servlet_standart_chief_report: " + json_from_js);
		
//..deals analisis
		response.getWriter().write(getHtmlTable());
		System.out.println("..end servlet_standart_chief_report");
	}

	private String getHtmlTable() {
		ArrayList<Day> day_interval = Buffer.getFinal_list();
		
		String html = "<div style=\"overflow: auto; height: 350px\"><table style=\"width: 95%; font-size: 9pt\">";
//..general cycle
		for(int i = 0; i < day_interval.size(); i++) {
			SortDay sort_day = new SortDay();
			new DeepRecognize(day_interval.get(i), sort_day);//uses for extract "other"
			
			html += "<tr><td>дата</td><td>фнд</td><td>копия</td><td>печать</td><td>багет</td>"
					+ "<td>фотолаб</td><td>сфера</td><td>другое</td><td>на карту</td><td>за услугу</td>"
					+ "<td>расходы</td><td>категория</td><td>итого</td><td>ником</td><td>пульты</td>"
					+ "<td>всего</td><td>з\\п</td><td>касса утро</td><td>касса вечер</td></tr>";
//..end tables head			
			html += "<tr style=\"vertical-align: top\"><td>" + day_interval.get(i).getDate() + "</td>"
					+ "<td>\t" + getArray(i, "фнд") + "</td><td>\t" + getArray(i, "копия") + "</td>"
					+ "<td>" + getArray(i, "печать") + "</td><td>" + getArray(i, "багет") + "</td>"
					+ "<td>" + getArray(i, "фотолаб") + "</td><td>" + getArray(i, "сфера") + "</td>"
					+ "<td>" + getArray(sort_day.getListOther()) + "</td>"
					+ "<td>" + getCardData(day_interval.get(i)) + "</td>"
					+ "<td>" + getExpenseData(day_interval.get(i)) + "</td>"
					+ "<td>" + (sort_day.getIncome() - sort_day.getNicom() - sort_day.getPults()) + "</td>"
					+ "<td>" + getArray(i, "ником") + "</td><td>" + getArray(i, "пульты") + "</td>"
					+ "<td>" + sort_day.getIncome() + "</td><td>" + day_interval.get(i).getSalary() + "</td>"
					+ "<td>" + day_interval.get(i).getBeginCash() + "</td><td>" + day_interval.get(i).getEndCash() + "</td></tr>";
		}
		
		html += "</table></div>";
		return html;
	}

	private String getArray(int number, String type_deal) {
		ArrayList<Deal> deals = new ArrayList<Deal>();
		new DealsRecognize(Buffer.getFinal_list(), deals, type_deal);
		ArrayList<String> cash = deals.get(number).getCash_gain();
		ArrayList<String> online = deals.get(number).getOnline_income();
		String s = "";
		for(int i = 0; i < cash.size(); i++) {
			s += getNumber(cash.get(i)) + "<br>";
		}
		
		for(int i = 0; i < online.size(); i++) {
			s += getNumber(online.get(i)) + "<br>";
		}
		return s;
	}
	
	private String getArray(Object obj) {
		ArrayList<String> data = (ArrayList<String>) obj;
		if(data.get(0).equals("0") && data.size() > 1)data.remove(0);
		String s = "";
		for(int i = 0; i < data.size(); i++) {
			s += getNumber(data.get(i)) + "<br>";
		}
		return s;
	}
	
	private String getCardData(Day day) {
		List<String> facture = day.getFacture();
		String data = "";
//..for card
		for(int i = 0; i < facture.size(); i++) {
			String s = facture.get(i);
			if(s.contains("сбер") || s.contains("тинькофф")  || s.contains("почта-банк") || s.contains("сбербанк") || s.contains("тинькоф")) {	
				data += getNumber(s) + "<br>";
			}
		}
		data += "</td><td>";
//..for service
		for(int i = 0; i < facture.size(); i++) {
			String s = facture.get(i);
			if(s.contains("сбер") || s.contains("тинькофф")  || s.contains("почта-банк") || s.contains("сбербанк") || s.contains("тинькоф")) {
				String[] operational = s.split(" ");
				data += operational[0] + "<br>";
			}
		}
		return data;
	}
	
private String getExpenseData(Day day) {
		List<String> facture = day.getFacture();
		String data = "";
//..for expense
		for(int i = 0; i < facture.size(); i++) {
			String s = facture.get(i);
			if(s.contains("минус")) {	
				data += getNumber(s) + "<br>";
			}
		}
		data += "</td><td>";
//..for service
		for(int i = 0; i < facture.size(); i++) {
			String s = facture.get(i);
			if(s.contains("минус")) {
				String[] operational = s.split(" ");
				data += operational[0] + "<br>";
			}
		}
		return data;
	}
	
	
	private int getNumber(String text) {
		char[] ch = text.toCharArray();
		String number = "";
			for(int i = 0; i < ch.length; i++) {
				if(Character.isDigit(ch[i]))number += "" + ch[i];
			}	
	return Integer.parseInt(number);
	}
}