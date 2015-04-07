package string;

public class RemoveStringDuplicates {	
	private static String text = "abcd";

	public static void main(String [] args) {
		System.out.println(removeStringDuplicates(text));
	}


	public static String removeStringDuplicates(String text){
		if (text == null || text.length() < 1) return null;
		StringBuffer buffer = new StringBuffer();
		buffer.append(text.charAt(0));
		for (int i = 1; i < text.length(); i++){
			if (!buffer.toString().contains(String.valueOf(text.charAt(i)))){
				buffer.append(text.charAt(i));
			}
		}
		return buffer.toString();
	}
}