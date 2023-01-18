package JaSam;

public class SumaJa {
	
	
	public int traziPecurke() {
		//System.out.println(Thread.currentThread().getName() + " trazi pecurke.");
		try {
			Thread.sleep((long) (1000 + 500 * Math.random()));
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		return (int) (Math.random() *10 );
	}

	public int traziDrva() {
		//System.out.println(Thread.currentThread().getName() + " trazi drva.");
		try {
			Thread.sleep((long) (1000 + 500 * Math.random()));
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		return (int) (Math.random() * 10);
	}
}
