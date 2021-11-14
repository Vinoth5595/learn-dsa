package learn.coding;

class Code {

	/**
	 * To reverse a String
	 * 
	 * @param value - input value
	 */
	public void reverseAString(String value) {
		if (value == null || value.trim().equals("")) {
			throw new IllegalArgumentException("Invalid Argument");
		}

		char[] charArr = value.toCharArray();
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = charArr.length - 1; i >= 0; i--) {
			stringBuilder.append(charArr[i]);
		}

		System.out.println(stringBuilder); // Prints reversed string
	}

	public void swapTwoNumbers(int a, int b) {
		System.out.printf("a is %s, b is %s :: ", a, b);
		b = a + b; // if a = 1, b = 2, a + b = 3
		a = b - a; // 3 - 1 = 2
		b = b - a; // 3 - 2 = 1

		System.out.printf("After swapping: a is %s, b is %s \n", a, b);
	}

	public void checkVowel(String input) {
		boolean isVowel = input.toLowerCase().matches(".*[aeiou].*");
		System.out.println("isVowel:" + isVowel);
	}
	
	public void checkPrimeNumber(int input) {
		boolean isPrime = true;
		if(input == 0 || input == 1) {
			System.out.println("Not Prime");
			return;
		}
		
		if(input == 2) {
			System.out.println("Prime");
			return;
		}
		
		for(int i = 2; i <= input/2; i++) {
			if(input % i == 0) {
				System.out.println("Not Prime");
				isPrime = false;
				break;
			}
		}
		
		if(isPrime) System.out.println("Prime"); 
	}
}

public class Common {

	public static void main(String[] args) {
		Code code = new Code();
		code.reverseAString("Malayalam"); // To reverse a String
		code.swapTwoNumbers(1, 2);
		code.checkVowel("aeoiou");
		code.checkPrimeNumber(97);
	}
}
