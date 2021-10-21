package learn.ds.array;

import java.util.Comparator;
import java.util.stream.Stream;

public class LongestWord {

	public static void main(String[] args) {
		String[] words = { "one", "two", "three" };

		// O(n)
		findLongestString(words);

		findLongestStringUsingStreams(words);
	}

	private static void findLongestStringUsingStreams(String[] words) {
		String longestWord = Stream.of(words).max(Comparator.comparingInt(String::length)).get();
		System.out.println("longest word is:" + longestWord);
	}

	private static void findLongestString(String[] words) {
		String longestWord = null;
		int currentMaxLength = 0;

		for (String word : words) {
			if (word.length() > currentMaxLength) {
				currentMaxLength = word.length();
				longestWord = word;
			}
		}

		System.out.println("longest word is:" + longestWord);
	}

}
