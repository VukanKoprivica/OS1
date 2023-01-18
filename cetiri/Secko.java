package cetiri;

public class Secko extends Thread {
	
	private final Kuhinja kuhinja;
	
	public Secko(Kuhinja kuhinja) {
		
		this.kuhinja = kuhinja;
	}

	public void run() {
		try {
			while(!interrupted()) {
				sleep(900);
				kuhinja.dodajPovrce(1000);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
