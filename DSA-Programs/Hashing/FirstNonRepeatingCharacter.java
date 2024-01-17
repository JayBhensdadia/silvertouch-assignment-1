package Hashing;

import java.util.HashMap;

public class FirstNonRepeatingCharacter {

    public static char findFirstNonRepeatingChar(String str) {
        HashMap<Character, Integer> charCount = new HashMap<>();

        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (char c : str.toCharArray()) {
            if (charCount.get(c) == 1) {
                return c;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        String input = "programming";
        char result = findFirstNonRepeatingChar(input);

        System.out.println("The first non-repeating character in \"" + input + "\" is: " + result);

    }
}
