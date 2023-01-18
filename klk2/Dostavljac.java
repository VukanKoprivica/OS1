package klkVetnic;

public class Dostavljac extends Thread{

	Picerija picerija ;
	int baksis;
	int ukupno;
	
	public Dostavljac(String name,Picerija picerija) {
		this.baksis = 0;
		this.ukupno=0;
		this.picerija = picerija;
		setName(name);
	}


	public void run() {
		
		try {
			for(int i = 0;i<2;i++) {
				if(interrupted());
				Porudzbina p;
			
				p = picerija.preuzmi();
			
				int primio = p.dostavi();
				int cena = p.cena;
				int baksiss = primio - cena;
				this.ukupno += primio;
				this.baksis+= baksiss;
			
				
				System.out.println(getName() + " je dostavio picu ");
			} 
		}catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		System.out.println( getName() + " je zaradio ukupno " + ukupno + " od toga baksisa " + baksis);
		
	}
}
