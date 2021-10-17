package learn.ds.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		
		// O(n)
		System.out.println(isContainsDuplicate(nums));
	}

	private static boolean isContainsDuplicate(int[] nums) {
		Set<Integer> distinctSet = new HashSet<>();
		
		for(int value : nums) {
			distinctSet.add(value);
		}
		
		return distinctSet.size() != nums.length;
	}

}
