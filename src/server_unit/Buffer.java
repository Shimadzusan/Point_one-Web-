package server_unit;

import java.util.ArrayList;
import beans_unit.Day;

public class Buffer {
	private static ArrayList<Day> final_list;

	public static ArrayList<Day> getFinal_list() {
		return final_list;
	}

	public static void setFinal_list(ArrayList<Day> final_list) {
		Buffer.final_list = final_list;
	}

}
