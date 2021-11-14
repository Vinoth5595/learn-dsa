package learn.coding;

class Code{
	
	/**
	 * To reverse a String
	 * 
	 * @param value - input value
	 */
	public void reverseAString(String value) {
		if(value == null || value.trim().equals("")) {
			throw new IllegalArgumentException("Invalid Argument");
		}
		
		char[] charArr = value.toCharArray();
		StringBuilder stringBuilder = new StringBuilder();
		
		for(int i = charArr.length - 1; i >= 0; i--) {
			stringBuilder.append(charArr[i]);
		}
		
		System.out.println(stringBuilder); // Prints reversed string
	}
}

public class Common {

	public static void main(String[] args) {
		Code code = new Code();
		code.reverseAString("Malayalam"); // To reverse a String
	}
}
