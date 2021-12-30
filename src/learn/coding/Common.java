package learn.coding;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Player implements Comparable<Player> {
	private String name;
	private Integer age;
	private Integer rank;

	public Player(String name, Integer age, Integer rank) {
		super();
		this.name = name;
		this.age = age;
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", age=" + age + ", rank=" + rank + "]";
	}

	@Override
	public int compareTo(Player o) {
		return Integer.compare(this.getRank(), o.getRank());
	}
}

class AgeComparator implements Comparator<Player> {

	@Override
	public int compare(Player o1, Player o2) {
		return Integer.compare(o1.getAge(), o2.getAge());
	}

}

class NameComparator implements Comparator<Player> {

	@Override
	public int compare(Player o1, Player o2) {
		return o1.getName().compareTo(o2.getName());
	}

}

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
		if (userInput == null || userInput.strip().equals("")) {
			throw new IllegalArgumentException("invalid input");
		}

		StringBuilder stringBuilder = new StringBuilder();
		char[] charArr = userInput.toCharArray();

		for (char c : charArr) {
			if (!Character.isWhitespace(c)) {
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
		if (num == 1)
			return 1;
		return num * factorial(num - 1);
	}

	public void factorialNumber(int n) {
		System.out.println(factorial(n));
	}

	public void pyramidPattern(int n) {
		for (int i = 1; i <= n; i++) {
			int whiteSpaces = n - i;

			printString(" ", whiteSpaces);

			printString(i + " ", i);

			System.out.println();
		}
	}

	private void printString(String string, int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(string);
		}
	}
}

public class Common {

	public static void main(String[] args) {
		Code code = new Code();
//		code.reverseAString("Malayalam"); // To reverse a String
//		code.swapTwoNumbers(1, 2);
//		code.checkVowel("aeoiou");
//		code.checkPrimeNumber(97);
//		code.fibonacciSeriesBruteForce(10);
//		code.fibonacciSeries(5);
//		code.checkOddNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
//		code.checkOddNumbers2(Arrays.asList(2, 4));
//		code.checkPalindromeString("Malayalam");
//		code.removeWhiteSpaces("Hello World");
//		code.sortArray(new int[] {4, 6, 1, 2});
//		code.factorialNumber(5);
//		code.pyramidPattern(5);

//		Player player1 = new Player("Vinoth", 26, 1);
//		Player player2 = new Player("Nirmal", 10, 3);
//		Player player3 = new Player("Jaya", 30, 2);
//		
//		List<Player> playerList = Arrays.asList(player1, player2, player3);
//		System.out.println(playerList);
//		Collections.sort(playerList);
//		System.out.println("Based on Rank:" + playerList);
//		Collections.sort(playerList, new AgeComparator());
//		System.out.println("Based on Age:" + playerList);
//		Collections.sort(playerList, new NameComparator());
//		System.out.println("Based on Name:" + playerList);

//		LinkedList<Integer> linkedList = new LinkedList<>();
//		linkedList.add(1);
//		linkedList.add(2);
//		linkedList.add(3);
//		reverseLinkedList(linkedList);
		
		int[] arr = {1,5,7,8,1,9,43,2};
		bubbleSort(arr);

//		Map<String, Integer> unsortMap = new HashMap<>();
//		unsortMap.put("z", 10);
//		unsortMap.put("b", 5);
//		unsortMap.put("a", 6);
//		unsortMap.put("c", 20);
//		unsortMap.put("d", 1);
//		unsortMap.put("e", 7);
//		unsortMap.put("y", 8);
//		unsortMap.put("n", 99);
//		unsortMap.put("g", 50);
//		unsortMap.put("m", 2);
//		unsortMap.put("f", 9);
//
//		sortMapbyKeyjava8(unsortMap);

		String[] strArr = {"vinoth", "vin", "vinot", "vino"};
		System.out.println(findLongestCommonPrefix(strArr));

		int[] intArr = {1, 2, 4, 5, 6, 6, 8, 9, 10};
		int target = 11;
		System.out.println(findClosestValue(intArr, target));
	}

	private static int findClosestValue(int[] intArr, int target) {
		int closest = Math.abs(target - intArr[0]);
		int index = 0;

		for(int i = 1; i < intArr.length; i++){
			int tempClosest = Math.abs(target - intArr[i]);
			if(tempClosest < closest){
				closest = tempClosest;
				index = i;
			}
		}

		return intArr[index];
	}

	private static String findLongestCommonPrefix(String[] strArr) {
		if(strArr.length == 0) return "";

		String prefix = strArr[0];

		for(int i = 0; i < strArr.length; i++){
			while(strArr[i].indexOf(prefix) != 0){
				prefix = prefix.substring(0, prefix.length() - 1);
				if(prefix.isEmpty()) return "";
			}
		}
		return prefix;
	}

	private static void sortMapbyKeyjava8(Map<String, Integer> unsortMap) {
		LinkedHashMap<String, Integer> collect = unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		System.out.println(collect);
	}

	private static void bubbleSort(int[] arr) {
		boolean swapped;
		for (int i = 0; i < arr.length - 1; i++) {
			swapped = false;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}

			if (swapped == false)
				break;
		}

		System.out.println(Arrays.toString(arr));
	}

	private static void reverseLinkedList(LinkedList<Integer> linkedList) {
		LinkedList<Integer> reversedList = new LinkedList<>();
		linkedList.descendingIterator().forEachRemaining(reversedList::add);
		System.out.println(reversedList);
	}
}
