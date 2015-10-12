import java.util.Vector;


public class ProducerConsumer {
	
	public static void main(String[] args) {
		Vector<Integer> sharedQueue = new Vector<Integer>();
		int size = 10;
		Thread prod = new Thread(new Producer(sharedQueue, size), "Producer");
		Thread cons = new Thread(new Consumer(sharedQueue, size), "Consumer");
		prod.start();cons.start();
		
		
	}
	
	

}
