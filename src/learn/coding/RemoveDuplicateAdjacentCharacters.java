package learn.coding;

import java.util.Stack;

public class RemoveDuplicateAdjacentCharacters {

	public static void main(String[] args) {
		String str1 ="azzxzy";
		  System.out.print(ShortenString(str1));
	}

	private static String ShortenString(String str) {
		/*
		 * 1. Create a stack to remove adjacent element from the list
		 * 2. Traverse the string and check if the stack is empty or the top 
		 *    element of the stack not equal to the current character. if true, 
		 *    push to the stack.
		 * 3. otherwise pop the element from the top of the stack.
		 * 4. finally print all the remaining element in the stack.
		 */
		
		Stack<Character> stack = new Stack<>();
		
		if(str == null || str.length() == 0 || str.trim().length() == 1) {
			return str;
		}
		
		int i = 0;
		
		while(i < str.length()) {
			if(stack.isEmpty() || str.charAt(i) != stack.peek()) {
				stack.add(str.charAt(i));
				i++;
			} else {
				stack.pop();
				i++;
			}
		}
		
		if(stack.isEmpty()) {
			return "Empty String";
		} else {
			String shortString = "";
			while(!stack.isEmpty()) {
				shortString = stack.peek() + shortString;
				stack.pop();
			}
			
			return shortString;
		}
	}

}
