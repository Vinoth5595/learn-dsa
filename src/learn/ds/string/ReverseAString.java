package learn.ds.string;

/**
 * Reverse a String
 * 
 * @author vinoth
 *
 */
public class ReverseAString {

	public static void main(String[] args) {
		String myName = "Vinoth new branch";

		String reversedString = "" ;
		char[] nameCharArr = myName.toCharArray();

		for (int i = nameCharArr.length - 1; i >= 0; i--) {
			reversedString += nameCharArr[i];
		}

		// Testing commit

		System.out.println(reversedString);
	}

}
