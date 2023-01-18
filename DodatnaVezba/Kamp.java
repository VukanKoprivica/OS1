package DodatnaVezba;

public class Kamp {
	private int pecurke = 0;
	private int drva = 0;

	public synchronized void donesiPecurke(int koliko) {
		try {
			while(pecurke+koliko > drva ) {wait();}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		pecurke += koliko;
	
	}

	public synchronized void donesiDrva(int koliko) {
		drva += koliko;
		notifyAll();
	}

	
}
