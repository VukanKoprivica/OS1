package DodatnaVezba;

public class IzvidjacPecurki extends Thread {
	private Kamp kamp;
	private Suma suma;

	public IzvidjacPecurki(Kamp kamp, Suma suma) {

		this.kamp = kamp;
		this.suma = suma;
		setDaemon(true);
	}

	public void run() {
		

			int ukupno =0;
				
				
				for (int i = 0; i < 20 && !interrupted(); i++) {
					int pecurke = suma.traziPecurke();
					
					kamp.donesiPecurke(pecurke);
					
					System.out.println(Thread.currentThread().getName() + "je doneo pecuraka " + pecurke);
					ukupno +=pecurke;
				}

				System.out.println(Thread.currentThread().getName() + "je doneo ukupno pecuraka " + ukupno);
	
	}
}
