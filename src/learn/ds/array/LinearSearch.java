package learn.ds.array;

public class LinearSearch {

	public static void main(String[] args) {
		int[] intArr = { 1, 5, 6, 7, 8, 9, 10 };
		System.out.println(findValueInArray(intArr, 5) ? "FOUND" : "NOT FOUND");
	}

	private static boolean findValueInArray(int[] intArr, int num) {
		for (int intVal : intArr) {
			if (intVal == num) {
				return true;
			}
		}

		return false;
	}

}
