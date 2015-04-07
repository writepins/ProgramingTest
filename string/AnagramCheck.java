package string;

//Q: StringToDouble in the next hour (following the end of the interview) and then to email it to the interviewer. This method had to include thorough 
//error checking and a method to test various cases (invalid characters, double too large, ect).

//two strings are anagrams when they contain same characters(not necessarily in the same order) and their length is same


public class AnagramCheck {

	static String word1 = "cat";
	static String word2 = "tac";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isAnagram(word1, word2));
	}
	
	private static boolean isAnagram(String str1, String str2) {
		// If length of strings are not same, the strings are not anagrams.
		if (str1 == null || str2 == null || str1.length() != str2.length()) {
			return false;
		}
		char[] str1Chars = str1.toLowerCase().toCharArray();
		StringBuilder builder = new StringBuilder(str2.toLowerCase());
		for (Character ch : str1Chars) {
			// Find the index of the current character in builder.
			int index = builder.indexOf(String.valueOf(ch));
			if (index == -1) {
				return false;
			}
			// Remove the character from builder so that multiple occurrences of
			// a character in the first string will be matched with equal number
			// of occurrences of the character in the second string.
			builder.delete(index, index + 1);
		}
		return true;
	}
}
