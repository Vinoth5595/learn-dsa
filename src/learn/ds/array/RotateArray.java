package learn.ds.array;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;

		// Rotate array to left
		rotateArrayToLeft(nums, k);

		int[] nums2 = { 1, 2, 3, 4, 5, 6, 7 };
		
		// Rotate array to Right
		rotateArrayToRight(nums2, k);
	}

	private static void rotateArrayToRight(int[] nums, int k) {
		if(k > nums.length) {
			k = k - nums.length;
		}
		
		int remaining = Math.abs(nums.length - k);
		int[] remArr = new int[remaining];
		int count = 0;
		
		System.arraycopy(nums, 0, remArr, 0, remaining);
		
		for(int i = remaining; i < nums.length; i++) {
			nums[count++] = nums[i];
		}
		
		for(int i : remArr) {
			nums[count++] = i;
		}
		
		System.out.println(Arrays.toString(nums)); 
	}

	private static void rotateArrayToLeft(int[] nums, int k) {
		if(k > nums.length) {
			k = k - nums.length;
		}
		
		int[] remArr = new int[k];
		System.arraycopy(nums, 0, remArr, 0, k);

		for (int i = k; i < nums.length; i++) {
			nums[i - k] = nums[i];
		}

		for (int i = 0; i < k; i++) {
			nums[i + nums.length - k] = remArr[i];
		}

		System.out.println(Arrays.toString(nums));
	}

}
