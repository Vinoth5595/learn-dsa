package learn.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

class ThreadRunner {
	public static void runThread(final int delay) {
		try {
			Thread.sleep(delay);
			System.out.println("Thread -> " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class PlayWithStreams {

	public static void main(String[] args) {
		// playWithThread();

		// Create Streams

		// Fixed integers
		Stream<String> stream = Stream.of("Hello", "World", "Buddies");
		stream.forEach(System.out::println);

		// Arrays
		Stream<String> stream2 = Stream.of(new String[] { "Hello", "World", "Buddies" });
		stream2.forEach(System.out::println);

		// Lists
		Stream<Integer> stream3 = Arrays.asList(1, 2, 3).stream();
		stream3.forEach(System.out::println);

		// Stream Generate
		Stream<Integer> generateRandom = Stream.generate(() -> (new Random()).nextInt(100));
		generateRandom.limit(5).forEach(System.out::println);

		// Stream.iterate
		Stream.iterate(1, n -> n + 1).limit(20).forEach(System.out::println);

		// Stream.iterate fibonacci series
		Stream.iterate(new int[] { 0, 1 }, n -> new int[] { n[1], n[0] + n[1] }).limit(20).map(n -> n[0])
				.forEach(System.out::println);

		System.out.println("*************************");

		IntStream intStream = "12345_abcdefg".chars();
		intStream.forEach(System.out::println);

		Stream<String> streamStr = Stream.of("A$B$C".split("\\$"));
		streamStr.forEach(p -> System.out.println(p));

		Builder<String> stringBuilder = Stream.builder();
		Stream<String> build = stringBuilder.add("This").add("is").add("stream").add("builder").build();
		build.forEach(System.out::println);

		List<Integer> collect = Stream.iterate(0, n -> ++n).limit(10).collect(Collectors.toList());

		System.out.println(collect);

		Stream.of("India", "Australia", "Newzealand", "", "South Africa", "England").takeWhile(o -> !o.startsWith("N"))
				.forEach(System.out::println);

		Stream.of("", "Australia", "", "England", "Srilanka", "abc").dropWhile(o -> !o.startsWith("S"))
				.forEach(System.out::println);

		List<String> memberNames = new ArrayList<>();
		memberNames.add("Amitabh");
		memberNames.add("Shekhar");
		memberNames.add("Aman");
		memberNames.add("Rahul");
		memberNames.add("Shahrukh");
		memberNames.add("Salman");
		memberNames.add("Yana");
		memberNames.add("Lokesh");

		memberNames.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

		Map<String, Integer> map = new HashMap<>();
		map.put("B", 2);
		map.put("A", 1);
		map.put("A", 3);
		Map<String, Integer> collect2 = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
		System.out.println(collect2);

		Random random = new Random();
		long count = random.longs(5, 0, 10).count();
		System.out.println(count);

		Stream<Integer> stream4 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 23423).stream();

		Integer lastElement = stream4.reduce((first, second) -> second).orElse(-1);

		System.out.println(lastElement);

		ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));

		Map<Integer, Long> elementCountMap = numbersList.stream()
				.collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));

		System.out.println(elementCountMap);

	}

	private static void playWithThread() {
		ExecutorService es = Executors.newFixedThreadPool(5);

		int d1 = 1000;
		int d2 = 1000;
		int d3 = 1000;
		int d4 = 1000;
		int d5 = 1000;

		long t1 = System.currentTimeMillis();

		Stream.of(d1, d2, d3, d4, d5).parallel().forEach(val -> {
			es.execute(() -> ThreadRunner.runThread(val));
		});

		long t2 = System.currentTimeMillis();

		System.out.println("Time Taken :" + (t2 - t1) + "ms");

		es.shutdown();
	}

}

class TestThread extends Thread {
	@Override
	public void run() {
		System.out.println("Test");
	}
}
