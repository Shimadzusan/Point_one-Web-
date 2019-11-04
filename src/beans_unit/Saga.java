package beans_unit;

public class Saga {
	Day[] saga;
	
	Saga() {
	//..Saga должна сама себя инициализировать??	
	}
	
	public Day[] getSaga() {
		return saga;
	}

	public void setSaga(Day[] saga) {
		this.saga = saga;
	}

	public class Day extends beans_unit.Day {
		
	}

}
