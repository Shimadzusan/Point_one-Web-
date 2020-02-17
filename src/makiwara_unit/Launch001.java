package makiwara_unit;

import java.util.HashMap;
/**
 * 
 * @author user
 * thinking about <Spring> <Map> and <New Deals approach>
 * how all compound??
 * type of the deal we should define in detachment file, some_config.txt
 */
public class Launch001 {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("copy", 200);
		map.put("print", 500);
		
		System.out.println(map.get("copy"));
		System.out.println("check");
		
	}

}
