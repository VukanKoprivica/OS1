package cetiri;

public class Restoran {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.currentThread().setName("Laza");
		Kuhinja kuhinja = new Kuhinja();

		Konobarica k1 = new Konobarica(kuhinja);
		k1.setName("Rada");
		Konobarica k2 = new Konobarica(kuhinja);
		k2.setName("Dara");
		Thread s = new Secko(kuhinja);
		s.setName("Miki");
		Thread p = new PotazMajstor(kuhinja);
		p.setName("Mica");
		Thread h = new Hlebadzija(kuhinja);
		h.setName("Joki");

		Thread r1 = new Rostiljdzija(kuhinja);
		r1.setName("Vule");
		Thread r2 = new Rostiljdzija(kuhinja);
		r2.setName("Gule");
		
		k1.start();
		k2.start();
		s.start();
		p.start();
		h.start();
		r1.start();
		r2.start();
		
		Thread.sleep(30000);
		
		k1.interrupt();
		k2.interrupt();
		s.interrupt();
		p.interrupt();
		h.interrupt();
		r1.interrupt();
		r2.interrupt();
		
		k1.join();
		k2.join();
		s.join();
		p.join();
		h.join();
		r1.join();
		r2.join();
		

		System.out.println("Pazar :" + kuhinja.uzmiPazar());
	}

}
