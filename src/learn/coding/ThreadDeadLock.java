package learn.coding;

class SyncThread implements Runnable {
	private Object obj1;
	private Object obj2;
	
	SyncThread(Object obj1, Object obj2){
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	@Override
	public void run() {
		synchronized(obj1){
			work();
			synchronized(obj2) {
				work();
			}
		}
	}
	
	private void work() {
		System.out.println("I am working!!!");
	}
	
}

public class ThreadDeadLock {

	public static void main(String[] args) throws InterruptedException {
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
		
		Thread t1 = new Thread(new SyncThread(obj1, obj2), "t1");
		Thread t2 = new Thread(new SyncThread(obj2, obj3), "t2");
		Thread t3 = new Thread(new SyncThread(obj3, obj1), "t3");
		
		t1.start();
		t2.start();
		t3.start();
	}

}
