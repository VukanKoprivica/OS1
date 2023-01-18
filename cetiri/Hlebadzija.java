package cetiri;

public class Hlebadzija extends Thread {

	private final Kuhinja kuhinja;

	public Hlebadzija(Kuhinja kuhinja) {
		
		this.kuhinja = kuhinja;
	}
	
	public void run() {
		try {
			while (!interrupted()) {
				sleep(600);
				kuhinja.dodajHleb(6);
			}
		} catch (InterruptedException e) {
			// Izlazimo iz petlje i zavrsavamo rad
		}
	}
}
