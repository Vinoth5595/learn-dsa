package learn.ds.hashtable;

import java.util.Map;

public class FirstRecurringCharacter {

	public static void main(String[] args) {
		int[] intArr = { 2 };
		
		System.out.println(getFirstRecurringCharacter(intArr));
	}

	private static Integer getFirstRecurringCharacter(int[] intArr) {
		Map<Integer, Integer> map = new java.util.HashMap<>();
		
		for(Integer val: intArr) {
			if(map.get(val) == null) {
				map.put(val, val);
			} else {
				return map.get(val);
			}
		}
		
		return null;
	}

}
