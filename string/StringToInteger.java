package string;
//check if the string is a valid number or not

public class StringToInteger {

	static String word = "80";

	public static void main(String [] args){

		if (getAtoi(word) == -1)
			System.err.println();
		else
			System.out.println(getAtoi(word));
		
	}

	public static int getAtoi(String word){
		word = word.trim();
		if (word.length() < 1) return -1;
		int sum = 0;
		char sign = word.charAt(0);
		if (sign == '*' || sign == '%' || sign == '@'){
			throw new IllegalArgumentException("invalid number");
		}
			
		boolean negative = false;
		int i = 0;
		if (sign == '-'){
			negative = true;
			i = 1;
		}
		if (sign == '+'){
			i = 1;
		}

		int length = word.length();
		for (; i < length; i++){	
			char digit = word.charAt(i);

			//do not use Character.isDigit since char may be unicode which isDigit doesn't check
			if (!(digit >= '0' && digit <= '9'))
				throw new IllegalArgumentException("number contains other than digit at index "+i);
			
			int base = (int)Math.pow(10, length-i-1);
			digit = (char)(word.charAt(i) - '0');
			sum = sum + (digit * base);
		}
		if(negative)
			sum = 0 - sum;
		return sum;
	}
}

class StringEmpty extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String error;

	public StringEmpty(String error){
		this.error = error;
	}

	public String getError(){
		return error;
	}
}