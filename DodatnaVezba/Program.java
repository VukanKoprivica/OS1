package DodatnaVezba;



public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Suma suma = new Suma();
		Kamp kamp = new Kamp();
		
		for(int i = 0;i<12;i++) {
			IzvidjacPecurki  k = new IzvidjacPecurki(kamp, suma);
			k.setName("Pecurka " +i);
			k.start();
			
			IzvidjacDrva k1 = new IzvidjacDrva(kamp, suma);
			Thread t = new Thread(k1);
			t.setName("Drvar "+i);
			t.start();
		
			t.interrupt();
		}
		
		
		
		
	}

}
