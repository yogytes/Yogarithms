import java.util.Vector;

public class Producer implements Runnable{
		int size;
		Vector<Integer> sharedQueue;
		Producer(Vector sharedQueue, int size){
			this.sharedQueue = sharedQueue;
			this.size = size;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				try {
					System.out.println("Produced" +produce());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		int produce() throws InterruptedException{
			int i = 1 + (int)(Math.random()*10);
			
			while(this.size == sharedQueue.size()){
				synchronized (sharedQueue) {
					System.out.println("Queue full waiting");
					sharedQueue.wait();
				}
			}
			synchronized (sharedQueue) {
				sharedQueue.add(i);
				sharedQueue.notifyAll();
			}
			return i;
			
			
			
		}
		
	}