package klkVetnic;

public class PicaMajstor implements Runnable{

	Picerija p ;
	
	public PicaMajstor(Picerija p) {
	
		this.p = p;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true) {
			if(Thread.interrupted());
			Porudzbina t = new Porudzbina();
			p.spremno(t);
			System.out.println(Thread.currentThread().getName() + " je spremio picu ");
			try {
				Thread.sleep((long) (Math.random() * 2000) );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
