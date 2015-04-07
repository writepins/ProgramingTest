package string;

import java.util.HashSet;
import java.util.Set;
 
/*
First take out the first char from String and permute the remaining chars
If String = Ò123Ó
First char = 1 and remaining chars permutations are 23 and 32.
Now we can insert first char in the available positions in the permutations.
23 -> 123, 213, 231
22 -> 132, 312, 321
 */

public class PermutationOfString {
 
	public static void main(String[] args) {
		String s = "ABC";
		System.out.println("\nString " + s + ":\nPermutations: " + permute(s));
	}
 
	public static Set<String> permute(String str) {
		Set<String> result = new HashSet<String>();
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			result.add("");
			return result;
		}
 
		char firstChar = str.charAt(0);
		String rem = str.substring(1);
		Set<String> words = permute(rem);
		for (String newString : words) {
			for (int i = 0; i <= newString.length(); i++) {
				result.add(addChar(newString, firstChar, i));
			}
		}
		return result;
	}
 
	public static String addChar(String str, char c, int j) {
		String first = str.substring(0, j);
		String last = str.substring(j);
		return first + c + last;
	}
}