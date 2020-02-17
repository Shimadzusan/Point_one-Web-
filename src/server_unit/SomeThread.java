package server_unit;

public class SomeThread extends Thread {
	
	@Override
	public void run() {
		for(int i = 0; i < 21; i++) {
			try {
				System.out.println("SomeThread: " + i);
				this.currentThread().sleep(2500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
