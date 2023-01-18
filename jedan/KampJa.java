package JaSam;

public class KampJa {

	private int pecurke = 0;
	private int drva = 0;
	private volatile int brojac = 0; 

	public synchronized  void donesiPecurke(int koliko) {
		while(pecurke + koliko > drva)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		pecurke += koliko;
	}

	public synchronized void donesiDrva(int koliko) {
		drva += koliko;
		System.out.println("D:"+drva+"    P:" +pecurke );
		notifyAll();
	}
	
	public synchronized void sacekajOstale() throws InterruptedException {
		brojac++;
		while(brojac < 24 )wait();
		
		notifyAll();
	}
}
