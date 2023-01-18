package tri;

public class Igrac  extends Thread {
	
	private Karta karta;
	private Spil spil;
	private Talon talon;
	private boolean najjacaa = true;
	
	
	public Igrac(Spil spil,Talon talon, String ime) {
	
		this.spil= spil;
		this.talon=talon;
		setName(ime);
	}


	


	public void run() {
		while(najjacaa) {
			karta = spil.uzmi();
			talon.staviKartu(karta);
			try {
				talon.cakajOstale();
				najjacaa=talon.jeNajjaca(karta);
				if(najjacaa)
					poruka(" pobedio");
				else
					poruka(" izgubio");
			
			}catch (Exception e) {
				// TODO: handle exception
				poruka(" prekinut");
			}
		}
	}
	
	
	public void poruka(String poruka) {
		System.out.println(getName() + poruka + " sa "+ karta );
	}
	public void uzmi(Karta karta) {
		this.karta = karta;
	}

}
