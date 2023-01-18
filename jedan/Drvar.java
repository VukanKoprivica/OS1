package JaSam;

public class Drvar implements Runnable {

	private SumaJa suma;
	private KampJa kamp;
	
	private int ukupno=0;
	
	
	public Drvar(SumaJa suma, KampJa kamp) {
		this.suma = suma;
		this.kamp = kamp;
		this.ukupno = 0;
	}


	@Override
	public void run() {
		for(int i = 0;i<5;i++) {
			int brDr = suma.traziDrva();
			//System.out.println(Thread.currentThread().getName() + " je doneo : " + brDr + " drva");
			kamp.donesiDrva(brDr);
			ukupno += brDr;
		}
			try {
				kamp.sacekajOstale();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		System.out.println(Thread.currentThread().getName() + " je doneo : " + ukupno + " ukupno drva");
		
	}

}
