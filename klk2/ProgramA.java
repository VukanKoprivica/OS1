package klkVetnic;

public class ProgramA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Picerija p = new Picerija();
		
		for(int i =0;i<10;i++) {
			Dostavljac d = new Dostavljac("Dostavljac " +i,p );
			d.start();
			d.interrupt();
		}
		
		PicaMajstor pm1 = new PicaMajstor(p);
		Thread t1 = new Thread(pm1);
		t1.setName("Mica");
		t1.setDaemon(true);
		t1.start();
		t1.interrupt();
		
		PicaMajstor pm2 = new PicaMajstor(p);
		Thread t2 = new Thread(pm2);
		t2.setName("Zika");
		t2.setDaemon(true);
		t2.start();
		t2.interrupt();
		
	}

}
