package database_unit;

import beans_unit.SortDay;

public class DatabaseOne {
	public DatabaseOne() {
		System.out.println("..execute dataBase module");
	}
	
	public DatabaseOne(SortDay entity) {
		System.out.println("..execute dataBase module " + entity.getEndCash());
	}

}
