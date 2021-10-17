package learn.ds.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// Input array
		int[] inputIntegerArray = {1,  3, 4, 5, 6, 2, 5};
		int target = 6;
		findSumTwoUsingHashMap(inputIntegerArray, target);
		
		findTwoSum(inputIntegerArray, target);
	}

	private static void findSumTwoUsingHashMap(int[] inputIntegerArray, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < inputIntegerArray.length; i++) {
			int complement =  target - inputIntegerArray[i];
			
			if(map.containsKey(complement)) {
				System.out.println(map.get(complement) + " :" + i);
			}
			
			map.put(inputIntegerArray[i], i);
		}
	}

	private static void findTwoSum(int[] inputIntegerArray, int target) {
		for(int i = 0; i < inputIntegerArray.length; i++) {
			for(int j = i + 1; j < inputIntegerArray.length; j++) {
				int complement = target - inputIntegerArray[i];
				
				if(inputIntegerArray[j] == complement) {
					System.out.println("i:" + i + ", j:" + j);
					break;
				}
			}
		}
	}

}
