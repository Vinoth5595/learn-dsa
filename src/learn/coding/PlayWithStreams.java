package learn.coding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

class ThreadRunner {
	public static void runThread(final int delay) {
		try {
			Thread.sleep(delay);
			System.out.println("Thread -> "+ Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class PlayWithStreams {

	public static void main(String[] args) {
		playWithThread();
	}

	private static void playWithThread() {
		ExecutorService es = Executors.newFixedThreadPool(5);
		
		int d1 = 1000;
		int d2 = 1000;
		int d3 = 1000;
		int d4 = 1000;
		int d5 = 1000;
		
		long t1 = System.currentTimeMillis();
		
		Stream.of(d1, d2, d3, d4, d5)
		.forEach(val -> {
			es.execute(() -> ThreadRunner.runThread(val));
		});
		
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time Taken :" + (t2-t1) +"ms");
		
		es.shutdown();
	}

}
