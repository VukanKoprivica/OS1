package cetiri;

public class Rostiljdzija  extends Thread {
	private final Kuhinja kuhinja;

	public Rostiljdzija(Kuhinja kuhinja) {
		this.kuhinja = kuhinja;
	}

	@Override
	public void run() {
		try {
			while (!interrupted()) {
				sleep(600);
				kuhinja.dodajTofu(1);
			}
		} catch (InterruptedException e) {
			// Izlazimo iz petlje i zavrsavamo rad
		}
	}
}
