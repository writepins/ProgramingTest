package string;

public class IntegerToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(intToString(525));
	}
	
	// 1. keep appending the remainder of the number to the strinbuffer
	// 2. every time the new number would be n/10 so 525 becomes 52 then 5 then 0 
	public static String intToString(int n) { 
	    if (n == 0) return "0";
	    StringBuilder sb = new StringBuilder();
	    while (n > 0) { 
	        int curr = n % 10;
	        n = n/10;
	        sb.append(curr);
	    }
	    String s = sb.substring(0);
	    sb = new StringBuilder();
	    for (int i = s.length() -1; i >= 0; i--) { 
	        sb.append(s.charAt(i));
	    }
	    return sb.substring(0);
	}

}
