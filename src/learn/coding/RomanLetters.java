package learn.coding;

public class RomanLetters {

	static int getValue(char val) {
		switch (val) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return -1;
		}
	}

	static int getRomanValue(String romanValue) {
		int res = 0;

		for (int i = 0; i < romanValue.length(); i++) {
			int s1 = getValue(romanValue.charAt(i));
			
			if(i + 1 < romanValue.length()) {
				int s2 = getValue(romanValue.charAt(i + 1));
				
				if(s1 >= s2) {
					res = res + s1;
				} else {
					res = res + s2 - s1;
					i++;
				}
			} else {
				res = res + s1;
			}

		}
		
		return res;
	}

	public static void main(String[] args) {
		System.out.println(getRomanValue("CD"));
	}

}
