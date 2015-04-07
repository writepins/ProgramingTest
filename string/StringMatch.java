package string;
public class StringMatch {
 
    public static void main(String[] args) {
        System.out.println("\nResult = "
                + findMe("rge", "geeksforgeeks"));
    }
 
    public static boolean findMe(String subString, String mainString) {
        boolean foundme = false;
        int max = mainString.length() - subString.length();
        int j = 0;
        int k = 0;
        // Implement your own Contains Method with Recursion
        checkrecusion: 
        for (int i = 0; i <= max; i++) {
            int n = subString.length();
            j = i;
            k = 0;
 
            while (n-- != 0) {
                if (mainString.charAt(j++) != subString.charAt(k++)) {
                    continue checkrecusion;
                }
            }
            
            foundme = true;
            break checkrecusion;
        }
        System.out
        .println(foundme ? "\nImplement your own Contains() Method - Result: Yes, Match Found.." + " at index : "+(j-k)
                : "\nImplement your own Contains() Method - Result:  Nope - No Match Found..");
        return foundme;
    }
}