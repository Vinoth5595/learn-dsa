package learn.ds.array;

public class FindPeakIndex {

	public static void main(String[] args) {
		/*
		 * LOGIC:
		 * 
		 * 1. IF SIZE OF ARRAY IS ONE, RETURN FIRST INDEX
		 * 2. IF FIRST INDEX IS GREATER THAN SECOND ONE, RETURN THE FIRST INDEX
		 * 3. IF LAST INDEX GREATER THAN SECOND LAST INDEX THEN RETURN LAST INDEX
		 * 4. IF A[I] > A[I + 1] AND A[I] > A[I - 1] THEN RETURN I (LOOP STARTS FROM 1 TO N-1)
		 * 
		 */
		
		int[] intArr = new int[] {10, 11, 15, 16, 23, 90, 67};
		
		System.out.println(findPeakIndex(intArr, intArr.length));
	}

	private static int findPeakIndex(int[] intArr, int n) {
		if(n == 1) {
			return 0;
		}
		
		if(intArr[0] >= intArr[1]) {
			return 0;
		}
		
		if(intArr[n-1] >= intArr[n -2]) {
			return n-1;
		}
		
		for(int i = 1; i < n-1; i++) {
			if(intArr[i] > intArr[i - 1]
					&& intArr[i] > intArr[i + 1]) {
				return i;
			}
		}
		
		return 0;
	}

}
