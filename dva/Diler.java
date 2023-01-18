package dva;

import java.util.List;

public class Diler extends Thread {

	private List<Igrac> igraci;
	private Spil spil;
	public Diler(List<Igrac> igraci) {
		
		this.igraci = igraci;
		this.spil = new Spil();
	}
	public void run() {
		for(Igrac igrac : igraci) {
			Karta karta = spil.uzmi();
			igrac.primiKartu(karta);
		}
	}
	
}
