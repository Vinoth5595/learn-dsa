package learn.coding;

public class StringPermutations {

	public static void main(String[] args) {
		String str = "ABCD";
		findPermurations(str);
	}

	private static void findPermurations(String str) {
		if(str == null || str.trim().length() == 0) {
			return;
		}
		
		permutation(str.toCharArray(), 0);
	}

	private static void permutation(char[] charArray, int currentIndex) {
		if(currentIndex == charArray.length - 1) {
			System.out.println(String.valueOf(charArray));
		}
		
		for(int i = currentIndex; i < charArray.length; i++) {
			swap(charArray, currentIndex, i);
			permutation(charArray, currentIndex + 1);
			swap(charArray, currentIndex, i);
		}
	}

	private static void swap(char[] charArray, int i, int j) {
		char temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
	}
}
