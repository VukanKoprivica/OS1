package JaSam;

public class Pecurkar extends Thread{
	
	private SumaJa suma;
	private KampJa kamp;
	
	private  int ukupno = 0;
	
	
	public Pecurkar(String name ,SumaJa suma, KampJa kamp) {
		setName(name);
		setDaemon(true);
		this.suma = suma;
		this.kamp = kamp;
	}
	public void run() {
	
		for(int i = 0 ;i<5 && !interrupted() ; i++) {
			 int brP = suma.traziPecurke();
			
			//System.out.println(getName() +  " je doneo :" + brP + " pecuraka");
			 kamp.donesiPecurke(brP);
			 
			ukupno +=brP;
		}
			try {
				kamp.sacekajOstale();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		System.out.println(getName() +  " je doneo :" + ukupno + "  ukupno pecuraka");
		
	}

}
