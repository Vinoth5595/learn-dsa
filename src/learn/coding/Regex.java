package learn.coding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String[] args) {
		String regex = "[aeiou]";
		String text = "satdsad";
		Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(text);
	    int matches = 0;
	    while (matcher.find()) {
	        matches++;
	    }
		System.out.println(matches);
	}

}
