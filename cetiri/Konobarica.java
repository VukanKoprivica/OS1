package cetiri;

public class Konobarica extends Thread {
	
	 private final Kuhinja kuhinja;
	 
	public Konobarica(Kuhinja kuhinja) {
		
		this.kuhinja = kuhinja;
	}

	public void run() {
		try {
			while(!interrupted()) {
				sleep(1000);
				double porudzbina = Math.random();
				if(porudzbina < 0.4) {
					kuhinja.napraviSendvic();
				}else if(porudzbina <0.7)
					kuhinja.napraviPorcijuPotaza();
				else 
					kuhinja.napraviTofu();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
