package string;
import java.util.HashMap;
import java.util.Map;


public class Isomorphic {

	public static void main(String [] args) {
		System.out.println(isomorphic("foo", "bar"));
	}
	public static boolean isomorphic(String a, String b) {
	    if (a.length() != b.length()) return false;
	    
	    // Build two Hashmaps to maintain mapping relationships
	    Map<Character, Character> x = new HashMap<>();
	    Map<Character, Character> y = new HashMap<>();
	    for (int i = 0; i < a.length(); i++) {
	        char c1 = a.charAt(i);
	        char c2 = b.charAt(i);
	 
	        if (!x.containsKey(c1))
	            x.put(c1,c2);
	        else if (x.get(c1) != c2)
	            return false;
	 
	        if (!y.containsKey(c2))
	            y.put(c2,c1);
	        else if (y.get(c2) != c1)
	            return false;
	    }
	    return true;
	}
}
