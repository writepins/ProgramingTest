/*
Given a keypad, and a three digit number, list all words which are possible by pressing these numbers.

For example if my number is 234, possible words which can be formed are (Alphabetical order):

adg,adh,adi,aeg,aeh,aei,afg,afh,afi,bdg,bdh,bdi,beg,beh,bei,bfg,bfh,bfi
cdg,cdh,cdi,ceg,ceh,cei,cfg,cfh,cfi

 */

import java.util.LinkedList;
import java.util.List;

public class PhoneNumberCombinations {  
    // Number-to-letter mappings in order from zero to nine
    public static String mappings[][] = {
        {"0"}, {"1"}, {"A", "B", "C"}, {"D", "E", "F"}, {"G", "H", "I"},
        {"J", "K", "L"}, {"M", "N", "O"}, {"P", "Q", "R", "S"}, 
        {"T", "U", "V"}, {"W", "X", "Y", "Z"}
    };

    public static void generateCombosHelper(List<String> combos, 
            String prefix, String remaining) {
        // The current digit we are working with
        int digit = Integer.parseInt(remaining.substring(0, 1));
        
        if (remaining.length() == 1) {
            // We have reached the last digit in the phone number, so add 
            // all possible prefix-digit combinations to the list
            for (int i = 0; i < mappings[digit].length; i++) {
                combos.add(prefix + mappings[digit][i]);
            }
        } else {
            // Recursively call this method with each possible new 
            // prefix and the remaining part of the phone number.
            for (int i = 0; i < mappings[digit].length; i++) {
                generateCombosHelper(combos, prefix + mappings[digit][i], 
                        remaining.substring(1));
            }
        }
    }

    public static List<String> generateCombos(String phoneNumber) {
        // This will hold the final list of combinations
        List<String> combos = new LinkedList<String>();

        // Call the helper method with an empty prefix and the entire 
        // phone number as the remaining part.
        generateCombosHelper(combos, "", phoneNumber);

        return combos;
    }

    public static void main(String[] args) {
        String phone = "234";
        List<String> combos = generateCombos(phone);

        for (String s : combos) {
            System.out.print(s+",");
        }
    }
}
