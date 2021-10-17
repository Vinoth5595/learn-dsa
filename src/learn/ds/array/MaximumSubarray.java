package learn.ds.array;

public class MaximumSubarray {

	public static void main(String[] args) {
		int[] intArray = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

		// Brute force method - O(n)
		findMaximumSubarray(intArray);
	}

	/**
	 * To find the maximum sub array
	 * 
	 * @param intArray
	 */
	private static void findMaximumSubarray(int[] intArray) {
		int arrayLength = intArray.length;
		int maximumSubArraySum = 0;
		int start = 0;
		int end = 0;

		for (int i = 0; i < arrayLength; i++) {
			int runningWindowSum = 0;
			for (int j = i; j < arrayLength; j++) {
				runningWindowSum += intArray[j];

				if (runningWindowSum > maximumSubArraySum) {
					maximumSubArraySum = runningWindowSum;
					start = i;
					end = j;
				}

			}
		}

		System.out.println("Start=" + start + ", end=" + end + ", Sum=" + maximumSubArraySum);
	}

}
