package string;
public class LongestRepeatedCharacter {
	
	private static String text = "aaaabbbbb";
	
	public static void main(String [] args) {
		System.out.println(getLongestRepeated(text));
	
	}
	
	public static String getLongestRepeated(String text) {
	
		if (text.length() < 1 || text == null || text.equals("")) return null;
		int j = 1; 
		int max = 0;
		int sum = 0;
		String result = null;
		for (int i = 0; j < text.length(); i++) {
			while (text.charAt(i) == text.charAt(j)) {
				j++;
			}
			if (text.charAt(i) != text.charAt(j)) {
				sum = j - i;
				if (sum > max) {
					max = sum;
					result = text.substring(i , j);
				}
				j++;
				i = j - 2;
			}
		}
		if (max == 1) return text;
		return result;
	}
}