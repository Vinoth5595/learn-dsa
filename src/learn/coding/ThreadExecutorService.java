package learn.coding;

import java.util.List;
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
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		List<Future<String>> invokeAll = executorService.invokeAll(List.of(new CallableTask("A"), new CallableTask("B"), new CallableTask("C")));
		
		for(Future<String> val: invokeAll) {
			System.out.println(val.get());
		}
		

		executorService.shutdown();
	}

}
