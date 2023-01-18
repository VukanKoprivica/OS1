package cetiri;

public class PotazMajstor extends Thread {
	private final Kuhinja kuhinja;
	
	
	public PotazMajstor(Kuhinja kuhinja) {
		this.kuhinja = kuhinja;
	}


	public void run() {
		try {
			while(!interrupted()) {
			sleep(2400);
			kuhinja.dodajPotaz(10000);
				}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
