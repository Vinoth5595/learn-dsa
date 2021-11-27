package learn.coding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThread extends Thread {

	private int number;

	MyThread(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		System.out.println("inside MyThread " + number);
		try {
			Thread.sleep(1000 + number * 100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class ThreadExecutorService {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.execute(new MyThread(1));
		executorService.execute(new MyThread(2));
		executorService.execute(new MyThread(3));
		executorService.execute(new MyThread(4));
		executorService.execute(new MyThread(5));
		executorService.execute(new MyThread(6));

		executorService.shutdown();
	}

}
