package learn.ds.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1, 2 };

		// O(n)
		System.out.println(isContainsDuplicate(nums));
		
		// O(n)
		printDuplicates(nums);
		
		int[] nums2 = { 1, 2, 3, 1, 2 };
		
		// O(n)
		printDuplicates2(nums2);
	}

	private static void printDuplicates2(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int n: nums) {
			Integer count = map.get(n);
			if(count ==  null) {
				map.put(n, 1);
			} else {
				map.put(n, ++count);
			}
		}
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			if(entry.getValue() > 1) {
				System.out.printf("duplicate values are: %s \n", entry.getKey());
			}
		}
	}

	private static void printDuplicates(int[] nums) {
		Set<Integer> set = new HashSet<>();
		Set<Integer> duplicates = new HashSet<>();
		
		for(int n: nums) {
			if(set.add(n) == false) {
				duplicates.add(n);
			}
		}
		
		System.out.printf("duplicate values are %s \n", duplicates);
	}

	private static boolean isContainsDuplicate(int[] nums) {
		Set<Integer> distinctSet = new HashSet<>();

		for (int value : nums) {
			distinctSet.add(value);
		}

		return distinctSet.size() != nums.length;
	}

}
