package string;

public class StringANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isStringANumber("-3.3425"));
	}
	
	public static boolean isStringANumber(String word){
		if (word.length() < 1) {
			return false;
		}
		int i = 0;
		if (word.charAt(0) == '-' || word.charAt(0) == '+'){
			i = 1;
		}
		
		int decimalCount = 0;
		for (; i < word.length(); i++){
			char digit = word.charAt(i);
			
			//do not use Character.isDigit since char may be unicode which isDigit doesn't check
			if(decimalCount > 1){
				return false;
			}
			if (digit == '.'){
				decimalCount++;
				continue;
			}
			if (!(digit >= '0' && digit <= '9')){
				return false;
			}
		}
		return true;
	}

}
