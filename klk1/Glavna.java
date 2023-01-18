package klk1;

public class Glavna {

	public static void main(String[]args) throws InterruptedException {
		
		Kvadrati k = new Kvadrati();
		Ispis i = new Ispis(k);
		
		k.start();
		i.start();
		
		Thread.sleep(5009);
		k.interrupt();
		Thread.interrupted();
		i.interrupt();
	}
}
