package klk1;

public class Kvadrati extends Thread  {
	
	private int osnova ;
	public int kvadrat ;
	
	public volatile boolean kraj;
	
	
	
	public Kvadrati() {
		
		this.osnova = 1;
		this.kvadrat = 0;
		this.kraj = false;
	}



	public void run() {
		while(!isInterrupted()) {
			try {
				sleep(500);
				kvadrat = osnova * osnova;
				kraj = true;
				osnova++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				
			}
		
	
		}
	
		}

}
