package learn.coding.sample;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StringSplit {
    public static void main(String[] args) {
        // If we are getting the input as list
        List<String> strings = Arrays.asList("Chennai Super Kings", "Rajasthan Royals", "Delhi Capitals", "Test"); // List of String
        List<String> firstLetterFromEachWordAsList = getFirstLetterFromEachWordAsList(strings); // Returning the result as list
        System.out.println("List -> " + firstLetterFromEachWordAsList); // Printing the list

        // If we are getting the input as array
        String[] stringArray = {"Chennai Super Kings", "Rajasthan Royals", "Delhi Capitals", "Test"}; // Array of String
        String[] outputArray = getFirstLetterFromEachWordAsArray(stringArray); // Returning the result as Array
        System.out.println("Array -> " + Arrays.toString(outputArray)); // Printing the Array
    }

    public static String[] getFirstLetterFromEachWordAsArray(String[] inputArray) {
        if (inputArray.length == 0) {
            return inputArray;
        }

        String[] resultArray = Arrays.stream(inputArray).map(string -> {
            String trimmedString = string.trim();
            if (trimmedString.length() == 0) { // Return if the String is empty
                return trimmedString;
            }

            String[] splitStrings = trimmedString.split(" "); // Split the string using space
            StringBuffer stringBuffer = new StringBuffer();
            for (String word : splitStrings) {
                stringBuffer.append(word.charAt(0)); // Appending the first character of each word
            }

            return stringBuffer.toString(); // Returning the appended string
        }).toArray(String[]::new); // Returning as String Array

        return resultArray; // Returning as String Array
    }

    public static List<String> getFirstLetterFromEachWordAsList(List<String> stringList) {
        if (stringList.isEmpty()) { // if list is empty, then return empty list
            return Collections.emptyList();
        }

        List<String> acronymList = stringList.stream().map(string -> {
            String trimmedString = string.trim();
            if (trimmedString.length() == 0) { // Return if the String is empty
                return trimmedString;
            }

            String[] splitStrings = trimmedString.split(" "); // Split the string using space
            StringBuffer stringBuffer = new StringBuffer();
            for (String word : splitStrings) {
                stringBuffer.append(word.charAt(0)); // Appending the first character of each word
            }

            return stringBuffer.toString(); // Returning the appended string
        }).collect(Collectors.toList()); // Return as list

        return acronymList;
    }
}
