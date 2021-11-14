package learn.coding;

import java.util.Arrays;
import java.util.List;

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
		if (input == 0 || input == 1) {
			System.out.println("Not Prime");
			return;
		}

		if (input == 2) {
			System.out.println("Prime");
			return;
		}

		for (int i = 2; i <= input / 2; i++) {
			if (input % i == 0) {
				System.out.println("Not Prime");
				isPrime = false;
				break;
			}
		}

		if (isPrime)
			System.out.println("Prime");
	}

	public void fibonacciSeriesBruteForce(int n) {
		int a = 0, b = 1, c = 1;

		for (int i = 1; i <= n; i++) {
			System.out.print(a + ", ");
			a = b; // 1 - 1 - 2
			b = c; // 1 - 2 - 3
			c = a + b;// 2 - 3 - 5
		}

		System.out.println();
	}

	public int fibonacci(int num) {
		if (num <= 1) {
			return num;
		}

		int sum = fibonacci(num - 1) + fibonacci(num - 2);
		return sum;
	}

	public void fibonacciSeries(int input) {
		System.out.println(fibonacci(input));
	}

	public void checkOddNumbers(List<Integer> list) {
		for (int i : list) {
			if (i % 2 != 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	public void checkOddNumbers2(List<Integer> num) {
		boolean isOdd = num.parallelStream().anyMatch(n -> n % 2 != 0);
		System.out.println(isOdd ? "Odd" : "Even");
	}

	public void checkPalindromeString(String userInput) {
		if (userInput == null || userInput.strip().equals("")) {
			throw new IllegalArgumentException("Invalid input");
		}

		userInput = userInput.toLowerCase();
		char[] charArr = userInput.toCharArray();
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = charArr.length - 1; i >= 0; i--) {
			stringBuilder.append(charArr[i]);
		}

		System.out.println(stringBuilder.toString().equals(userInput) ? "Palindrome" : "Not Palindrome");
	}
	
	public void removeWhiteSpaces(String userInput) {
		if(userInput == null || userInput.strip().equals("")) {
			throw new IllegalArgumentException("invalid input");
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		char[] charArr = userInput.toCharArray();
		
		for(char c: charArr) {
			if(!Character.isWhitespace(c)) {
				stringBuilder.append(c);
			}
		}
		
		System.out.println(stringBuilder);
	}
	
	public void sortArray(int[] intArr) {
		Arrays.sort(intArr);
		
		System.out.println(Arrays.toString(intArr));
	}
	
	private int factorial(int num) {
		if(num == 1) return 1;
		return num * factorial(num - 1);
	}
	
	public void factorialNumber(int n) {
		System.out.println(factorial(n));
	}
}

public class Common {

	public static void main(String[] args) {
		Code code = new Code();
		code.reverseAString("Malayalam"); // To reverse a String
		code.swapTwoNumbers(1, 2);
		code.checkVowel("aeoiou");
		code.checkPrimeNumber(97);
		code.fibonacciSeriesBruteForce(10);
		code.fibonacciSeries(5);
		code.checkOddNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
		code.checkOddNumbers2(Arrays.asList(2, 4));
		code.checkPalindromeString("Malayalam");
		code.removeWhiteSpaces("Hello World");
		code.sortArray(new int[] {4, 6, 1, 2});
		code.factorialNumber(5);
	}
}
