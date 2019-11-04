package recognition_and_initialization_unit;

import java.util.ArrayList;

import beans_unit.*;

public class DeepRecognize {
/*
 * this class recognize patterns from object_Day
 * from facture, that contains object_Day
 * при этом источник фактуры может быть каким угодно, т.к.ё обращение происходит через интерфейс Facturable
 * класс претерпел существенные изменения(в худшую сторону) после создания отчетности для chief_excell
 * and initialize object_Sort_day
 */
	Facturable facture;
	SortDay sort_day; //..Sortable sort_day;
	ArrayList deal_list;
	
	public DeepRecognize(Facturable facture, SortDay sort_day) {
		this.facture = facture;
		this.sort_day = sort_day;
		deal_list = (ArrayList<String>) facture.getFacture();

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
			String s = (String)deal_list.get(i);//..add <String>
				
//initialize card_data
			if(s.contains("сбер") || s.contains("тинькофф")  || s.contains("почта-банк") || s.contains("сбербанк") || s.contains("тинькоф")) {
				if(sort_day.getListCardData() != null) {
					list_card_data = (ArrayList<String>) sort_day.getListCardData();
					list_card_data.add(s);
						sort_day.setListCardData(list_card_data);
					}
				else {
					list_card_data = new ArrayList<String>();
					list_card_data.add(s);
						sort_day.setListCardData(list_card_data);
					}
			}
				
//==========================================
				
			flag_other = true;
//===other===
			if(s.contains("фнд") || s.contains("копия")  || s.contains("печать") || s.contains("багет") || s.contains("фотолаб") || s.contains("сфера") || s.contains("ником") || s.contains("пульты")) {
				flag_other = false;
			}		
				
			if(flag_other == true) {
				if(sort_day.getListOther() != null) {
					list_other = (ArrayList<String>) sort_day.getListOther();
					list_other.add(s);
						sort_day.setListOther(list_other);
					}
				else {
					list_other = new ArrayList<String>();
					list_other.add(s);
						sort_day.setListOther(list_other);
				}		
			}
//=======================================================================================
			if(s.contains("фотолаб")) {
				if(sort_day.getListFotolab() != null) {
					list_fotolab = (ArrayList<String>) sort_day.getListFotolab();
					list_fotolab.add(s);
						sort_day.setListFotolab(list_fotolab);
				}
				else {
					list_fotolab = new ArrayList<String>();
					list_fotolab.add(s);
						sort_day.setListFotolab(list_fotolab);
				}
			}
			
			if(s.contains("багет")) {
				if(sort_day.getListBaget() != null) {
					list_baget = (ArrayList<String>) sort_day.getListBaget();
					list_baget.add(s);
						sort_day.setListBaget(list_baget);
				}
				else {
					list_baget = new ArrayList<String>();
					list_baget.add(s);
					sort_day.setListBaget(list_baget);
				}
			}
			
			if(s.contains("сфера")) {
				if(sort_day.getListSphera() != null) {
					list_sphera = (ArrayList<String>) sort_day.getListSphera();
					list_sphera.add(s);
						sort_day.setListSphera(list_sphera);
				}
				else {
					list_sphera = new ArrayList<String>();
					list_sphera.add(s);
						sort_day.setListSphera(list_sphera);
				}
			}
			
//technic
			if(s.contains("ником")) {
				if(sort_day.getListNicom() != null) {
					list_nicom = (ArrayList<String>) sort_day.getListNicom();
					list_nicom.add(s);
						sort_day.setListNicom(list_nicom);
				}
				else {
					list_nicom = new ArrayList<String>();
					list_nicom.add(s);
						sort_day.setListNicom(list_nicom);
				}
			}
			
			if(s.contains("пульты")) {
				if(sort_day.getListPults() != null) {
					list_pults = (ArrayList<String>) sort_day.getListPults();
					list_pults.add(s);
						sort_day.setListPults(list_pults);
				}
				else {
					list_pults = new ArrayList<String>();
					list_pults.add(s);
						sort_day.setListPults(list_pults);
				}
			}
					
//=======================================================================================
//здесь считаем, то есть выводим баланс			
			if(s.contains("минус")) {
				//payment += get_number((String)deal_list.get(i));
				sort_day.setPayment(sort_day.getPayment() + get_number((String)deal_list.get(i)));
				if(s.contains("ником")) sort_day.setNicomMinus(sort_day.getNicomMinus() + get_number((String)deal_list.get(i)));
				if(s.contains("пульты")) sort_day.setPultsMinus(sort_day.getPultsMinus() + get_number((String)deal_list.get(i)));
				if(s.contains("багет")) sort_day.setBagetMinus(sort_day.getBagetMinus() + get_number((String)deal_list.get(i)));
				if(s.contains("фотолаб")) sort_day.setFotolabMinus(sort_day.getFotolabMinus() + get_number((String)deal_list.get(i)));
			}			
			else {
				//income += get_number((String)deal_list.get(i));
				sort_day.setIncome(sort_day.getIncome() + get_number((String)deal_list.get(i)));
				if(s.contains("ником")) sort_day.setNicom(sort_day.getNicom() + get_number((String)deal_list.get(i)));
				if(s.contains("пульты")) sort_day.setPults(sort_day.getPults() + get_number((String)deal_list.get(i)));
				if(s.contains("сбер")) sort_day.setSber(sort_day.getSber() + get_number((String)deal_list.get(i)));

//..!
				if(s.contains("фнд")) {
					sort_day.setFoto(sort_day.getFoto() + get_number((String)deal_list.get(i)));
						if(sort_day.getListFoto() != null) {
							list_foto = (ArrayList<String>) sort_day.getListFoto();
							list_foto.add(s);				 
								sort_day.setListFoto(list_foto);
						}
						else {
							list_foto = new ArrayList<String>();
							list_foto.add(s);
								sort_day.setListFoto(list_foto);
						}
				}
							
				if(s.contains("копия")) {
					sort_day.setCopy(sort_day.getCopy() + get_number((String)deal_list.get(i)));
						if(sort_day.getListCopy() != null) {
							list_copy = (ArrayList<String>) sort_day.getListCopy();
							list_copy.add(s);
								sort_day.setListCopy(list_copy);
						}
						else {
							list_copy = new ArrayList<String>();
							list_copy.add(s);
								sort_day.setListCopy(list_copy);
						}
				}
							
				if(s.contains("печать")) {
					sort_day.setPrint(sort_day.getPrint() + get_number((String)deal_list.get(i)));
						if(sort_day.getListPrint() != null) {
							list_print = (ArrayList<String>) sort_day.getListPrint();
							list_print.add(s);
								sort_day.setListPrint(list_print);
								}
						else {
							list_print = new ArrayList<String>();
							list_print.add(s);
								sort_day.setListPrint(list_print);
						}
				}				
			}
		}
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
