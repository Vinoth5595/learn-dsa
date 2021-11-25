package learn.ds.array;

public class ConsecutiveNumbers {

	public static void main(String[] args) {
		int[] arr = { 6, 1, 9, 3, 10, 4, 20, 2, 5 };
		System.out.println(findMaximumConsecutiveNumber(arr));
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
