package learn.ds.array;

public class MaximumSubarray {

	public static void main(String[] args) {
		int[] intArray = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

		// Brute force method - O(n^2)
		findMaximumSubarray(intArray);
		// Kadane's algorithm - O(n)
		findMaxSubArrayUsingKadane(intArray);
		
	}
	
	/**
	 * Find maximum sub array using Kadane's Algorithm
	 * 
	 * @param intArray
	 */
	private static void findMaxSubArrayUsingKadane(int[] intArray) {
		int max_so_far = Integer.MIN_VALUE;
		int max_ending_here = 0;
		int start = 0;
		int end = 0;
		int s = 0;
		
		for(int i = 0; i < intArray.length; i++) {
			max_ending_here += intArray[i];
			
			if(max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
				start = s;
				end = i;
			}
			
			if(max_ending_here < 0) {
				max_ending_here = 0;
				s = i + 1;
			}
			
		}
		
		System.out.println("Start=" + start + ", end=" + end + ", Sum=" + max_so_far);
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
