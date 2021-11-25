package learn.ds.array;

import java.util.HashSet;
import java.util.Set;

public class ConsecutiveNumbers {

	public static void main(String[] args) {
		int[] arr = { 6, 1, 9, 3, 10, 4, 20, 2, 5 };
		System.out.println(findMaximumConsecutiveNumber(arr));
		System.out.println(findMaximumConsecutiveNumber2(arr));
	}

	private static int findMaximumConsecutiveNumber2(int[] arr) {
		Set<Integer> set = new HashSet<>();
		
		for(int value: arr) {
			set.add(value);
		}
		
		int longestStreak = 0;
		
		for(int num: set) {
			if(!set.contains(num-1)) {
				int currentNum = num;
				int currentStreak = 1;
				
				while(set.contains(currentNum + 1)) {
					currentNum += 1;
					currentStreak += 1;
				}
				
				longestStreak = Math.max(currentStreak, longestStreak);
			}
		}
		
		return longestStreak;
	}

	private static int findMaximumConsecutiveNumber(int[] arr) {
		int finalCount = 0;

		for (int num : arr) {
			int currentNum = num;
			int currentSequence = 1;

			while (containsArray(arr, currentNum + 1)) {
				currentNum += 1;
				currentSequence += 1;
			}

			finalCount = Math.max(finalCount, currentSequence);
		}

		return finalCount;
	}

	private static boolean containsArray(int[] arr, int num) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				return true;
			}
		}
		return false;
	}

}
