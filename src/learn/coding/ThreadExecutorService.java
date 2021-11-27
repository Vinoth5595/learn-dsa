package learn.coding;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

class CallableTask implements Callable<String> {
	private String name;
	
	CallableTask(String name) {
		this.name = name;
	}
	
	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return this.name;
	}
}

public class ThreadExecutorService {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Future<String> submitA = executorService.submit(new CallableTask("A"));
		System.out.println(submitA.get());
		Future<String> submitB = executorService.submit(new CallableTask("B"));
		System.out.println(submitB.get());
		Future<String> submitC = executorService.submit(new CallableTask("C"));
		System.out.println(submitC.get());

		executorService.shutdown();
	}

}
