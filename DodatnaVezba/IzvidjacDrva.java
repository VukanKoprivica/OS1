package DodatnaVezba;

public class IzvidjacDrva  implements Runnable {

	private Kamp kamp;
	private Suma suma;
	
	public IzvidjacDrva(Kamp kamp, Suma suma) {
		this.kamp = kamp;
		this.suma = suma;
	}

	@Override
	public void run() {
			
		int ukupno = 0;
		
				for (int i = 0; i < 25; i++) {
					int drva = suma.traziDrva();
					
					kamp.donesiDrva(drva);
				
					System.out.println(Thread.currentThread().getName() + " je doneo " + drva);
					ukupno+= drva;
				}

				System.out.println(Thread.currentThread().getName() + " je doneo ukuopno " + ukupno);
			
		
	}

}
