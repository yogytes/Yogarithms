import java.util.Vector;

class Consumer implements Runnable{
		int size;
		Vector<Integer> sharedQueue;
		Consumer(Vector sharedQueue, int size){
			this.sharedQueue = sharedQueue;
			this.size = size;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				try {
					System.out.println("Consumed "+consume());
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		private int consume() throws InterruptedException {
			// TODO Auto-generated method stub
			synchronized (sharedQueue) {
				if(sharedQueue.isEmpty()){
					System.out.println("queue empty waiting");
					sharedQueue.wait();
				}
			}
			
			synchronized (sharedQueue) {
				sharedQueue.notifyAll();
				return sharedQueue.remove(0);
			}
		}
		
	}