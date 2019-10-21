package main;

import java.util.ArrayList;

public class Deep_Recognize {
/*
 * this class recognize patterns from object_Day
 * from facture, that contains object_Day
 * при этом источник фактуры может быть каким угодно, т.к.ё обращение происходит через интерфейс Facturable
 * класс претерпел существенные изменения(в худшую сторону) после создания отчетности для chief_excell
 * and initialize object_Sort_day
 */
	Facturable facture;
	Sortable sort_day;
	ArrayList deal_list;
	
	Deep_Recognize(Facturable facture, Sortable sort_day) {
		this.facture = facture;
		this.sort_day = sort_day;
		deal_list = (ArrayList<String>) facture.get_facture();

		init_sort_day_data();
	}
	
	public int init_sort_day_data() {

		ArrayList<String> list_foto;
		ArrayList<String> list_copy;
		ArrayList<String> list_print;
		
		ArrayList<String> list_fotolab;
		ArrayList<String> list_baget;
		ArrayList<String> list_sphera;
		
		ArrayList<String> list_nicom;
		ArrayList<String> list_pults;
		
		ArrayList<String> list_other;
		boolean flag_other = false;
		
		ArrayList<String> list_card_data;
		
		
			for(int i = 0; i < deal_list.size(); i++) {
				String s = (String)deal_list.get(i);
				
//initialize card_data
				if(s.contains("сбер") || s.contains("тинькофф")  || s.contains("почта-банк") || s.contains("сбербанк") || s.contains("тинькоф")) {
					if(sort_day.get_list_card_data() != null) {
						list_card_data = (ArrayList<String>) sort_day.get_list_card_data();
						list_card_data.add(s);
					 
						sort_day.set_list_card_data(list_card_data);

					}
					else {
						list_card_data = new ArrayList<String>();
						list_card_data.add(s);
						sort_day.set_list_card_data(list_card_data);
					}
				}
				
//==========================================
				
				flag_other = true;
//===other===
				if(s.contains("фнд") || s.contains("копия")  || s.contains("печать") || s.contains("багет") || s.contains("фотолаб") || s.contains("сфера") || s.contains("ником") || s.contains("пульты")) {
					flag_other = false;
				}		
				
				if(flag_other == true) {
					
					if(sort_day.get_list_other() != null) {
						list_other = (ArrayList<String>) sort_day.get_list_other();
						list_other.add(s);
					 
						sort_day.set_list_other(list_other);

					}
					else {
						list_other = new ArrayList<String>();
						list_other.add(s);
						sort_day.set_list_other(list_other);
					}
					
				}
//=======================================================================================
		if(s.contains("фотолаб")) {
			if(sort_day.get_list_fotolab() != null) {
				list_fotolab = (ArrayList<String>) sort_day.get_list_fotolab();
				list_fotolab.add(s);
			 
				sort_day.set_list_fotolab(list_fotolab);

			}
			else {
				list_fotolab = new ArrayList<String>();
				list_fotolab.add(s);
				sort_day.set_list_fotolab(list_fotolab);
			}
		}
		
		if(s.contains("багет")) {
			if(sort_day.get_list_baget() != null) {
				list_baget = (ArrayList<String>) sort_day.get_list_baget();
				list_baget.add(s);
			 
				sort_day.set_list_baget(list_baget);

			}
			else {
				list_baget = new ArrayList<String>();
				list_baget.add(s);
				sort_day.set_list_baget(list_baget);
			}
		}
		
		if(s.contains("сфера")) {
			if(sort_day.get_list_sphera() != null) {
				list_sphera = (ArrayList<String>) sort_day.get_list_sphera();
				list_sphera.add(s);
			 
				sort_day.set_list_sphera(list_sphera);

			}
			else {
				list_sphera = new ArrayList<String>();
				list_sphera.add(s);
				sort_day.set_list_sphera(list_sphera);
			}
		}
		
//technic
		if(s.contains("ником")) {
			if(sort_day.get_list_nicom() != null) {
				list_nicom = (ArrayList<String>) sort_day.get_list_nicom();
				list_nicom.add(s);
			 
				sort_day.set_list_nicom(list_nicom);

			}
			else {
				list_nicom = new ArrayList<String>();
				list_nicom.add(s);
				sort_day.set_list_nicom(list_nicom);
			}
		}
		
		if(s.contains("пульты")) {
			if(sort_day.get_list_pults() != null) {
				list_pults = (ArrayList<String>) sort_day.get_list_pults();
				list_pults.add(s);
			 
				sort_day.set_list_pults(list_pults);

			}
			else {
				list_pults = new ArrayList<String>();
				list_pults.add(s);
				sort_day.set_list_pults(list_pults);
			}
		}
					
//=======================================================================================
//здесь считаем, то есть выводим баланс			
					if(s.contains("минус")) {
						//payment += get_number((String)deal_list.get(i));
						sort_day.set_payment(sort_day.get_payment() + get_number((String)deal_list.get(i)));
						if(s.contains("ником")) sort_day.set_nicom_minus(sort_day.get_nicom_minus() + get_number((String)deal_list.get(i)));
						if(s.contains("пульты")) sort_day.set_pults_minus(sort_day.get_pults_minus() + get_number((String)deal_list.get(i)));
						if(s.contains("багет")) sort_day.set_baget_minus(sort_day.get_baget_minus() + get_number((String)deal_list.get(i)));
						if(s.contains("фотолаб")) sort_day.set_fotolab_minus(sort_day.get_fotolab_minus() + get_number((String)deal_list.get(i)));
					}
				
					else {
						//income += get_number((String)deal_list.get(i));
						sort_day.set_income(sort_day.get_income() + get_number((String)deal_list.get(i)));

						if(s.contains("ником")) sort_day.set_nicom(sort_day.get_nicom() + get_number((String)deal_list.get(i)));
						if(s.contains("пульты")) sort_day.set_pults(sort_day.get_pults() + get_number((String)deal_list.get(i)));
						if(s.contains("сбер")) sort_day.set_sber(sort_day.get_sber() + get_number((String)deal_list.get(i)));
						
						if(s.contains("фнд")) {
							sort_day.set_foto(sort_day.get_foto() + get_number((String)deal_list.get(i)));
							
								if(sort_day.get_list_foto() != null) {
									list_foto = (ArrayList<String>) sort_day.get_list_foto();
									list_foto.add(s);
								 
									sort_day.set_list_foto(list_foto);
		
								}
								else {
									list_foto = new ArrayList<String>();
									list_foto.add(s);
									sort_day.set_list_foto(list_foto);
								}
						}
						
						
						
						
						if(s.contains("копия")) {
							sort_day.set_copy(sort_day.get_copy() + get_number((String)deal_list.get(i)));
							if(sort_day.get_list_copy() != null) {
								list_copy = (ArrayList<String>) sort_day.get_list_copy();
								list_copy.add(s);
								sort_day.set_list_copy(list_copy);
							}
							else {
								list_copy = new ArrayList<String>();
								list_copy.add(s);
								sort_day.set_list_copy(list_copy);
							}
						}
						
						if(s.contains("печать")) {
							sort_day.set_print(sort_day.get_print() + get_number((String)deal_list.get(i)));
							if(sort_day.get_list_print() != null) {
								list_print = (ArrayList<String>) sort_day.get_list_print();
								list_print.add(s);
								sort_day.set_list_print(list_print);
							}
							else {
								list_print = new ArrayList<String>();
								list_print.add(s);
								sort_day.set_list_print(list_print);
							}
						}
						
					}
			}
		
		return 0;
	}
	
	public int payment() {
//платежи: ником, пульты и тд
		return 0;
	}
	
	private int get_number(String text) {
		char[] ch = text.toCharArray();
		String number = "";
			for(int i = 0; i < ch.length; i++) {
				if(Character.isDigit(ch[i]))number += "" + ch[i];
			}
			
	return Integer.parseInt(number);
	}
}
