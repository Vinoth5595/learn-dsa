package learn.ds.array;

public class BinarySearch {

	public static void main(String[] args) {
		int[] intArr = { 1, 2, 5, 6, 8, 9, 10 };
		int searchValue = 8;

		int binarySearch = binarySearch(intArr, 0, intArr.length - 1, searchValue);

		if (binarySearch == -1) {
			System.out.println("Value not found!!!");
		} else {
			System.out.println(binarySearch + " - Found!!!");
		}
	}

	private static int binarySearch(int[] intArr, int left, int right, int searchValue) {
		if(right >= left) {
			int mid = (left + right) / 2;
			
			if(intArr[mid] == searchValue) {
				return intArr[mid];
			}
			
			if(intArr[mid] > searchValue) return binarySearch(intArr, 0, mid, searchValue);
			
			return binarySearch(intArr, mid + 1, right, searchValue);
		}
		
		return -1;
	}

}
