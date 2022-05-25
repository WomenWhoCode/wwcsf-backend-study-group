package coding.problems;

import java.util.logging.Level;
import java.util.logging.Logger;

/* 
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * https://leetcode.com/problems/valid-anagram/description/
 * Example 1:
Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */

public class ValidAnagram {

    public static final Logger logger = Logger.getAnonymousLogger();

    public static void main(String[] args) {

        logger.info("Program to check for valid Anagram:");
        String original = "anagram";
        String toValidate = "nagaram";
        ValidAnagram valAn = new ValidAnagram();
        String result = String.valueOf(valAn.validateAnagram(original, toValidate));
        logger.log(Level.INFO, result);
    }

    private boolean validateAnagram(String original, String toValidate) {

        printArrays(original);
        printArrays(toValidate);

        if (original.isEmpty() || toValidate.isEmpty()) { // Empty inputs
            logger.log(Level.INFO, "Not a valid Anagram");
            return false;
        }

        if (original.length() != toValidate.length()) { // Length does not match fail validation
            logger.log(Level.INFO, "Anagram is not valid");
            return false;
        }

        /*
         * SOLUTION No.1: SORTING both strings will result in two identical strings; use
         * Arrays class for sorting
         * Complexity: O(n log n) time;
         * Space: O(n) for toCharArray() and O(1) for sorting char[]
         *
         * originalChars = original.toCharArray(); // Space: O(n) char[] toValidateChars
         * = toValidate.toCharArray(); // Space: O(n)
         *
         * Arrays.sort(originalChars); // O(n log n) Arrays.sort(toValidateChars); //
         * O(n log n)
         *
         * printArrays(Arrays.toString(originalChars));
         * printArrays(Arrays.toString(toValidateChars));
         *
         * return (Arrays.equals(originalChars, toValidateChars)); // Comparison: O(n)
         *
         * OUTPUT:
         * INFO: anagram
         * Jun 30, 2018 7:02:05 PM algorithms.ValidAnagram printArrays
         * INFO: nagaram
         * Jun 30, 2018 7:02:05 PM algorithms.ValidAnagram printArrays
         * INFO: [a, a, a, g, m, n, r]
         * Jun 30, 2018 7:02:05 PM algorithms.ValidAnagram printArrays
         * INFO: [a, a, a, g, m, n, r]
         * Jun 30, 2018 7:02:05 PM algorithms.ValidAnagram main
         * INFO: true
         */

        /*
         * SOLUTION No.2: HASH TABLE
         * Complexity: O(n) time because accessing the counter table is a constant time operation.
         * Space: O(1). Although we do use extra space, the space complexity is O(1)O(1) because the table's size
         * stays constant no matter how large nn is.
         * To examine if tt is a rearrangement of ss, we can count occurrences of each letter in the two strings and
         * compare them.
         * Since both ss and tt contain only letters from a-za−z, a simple counter table of size 26 is suffice.
         * One counter is needed, because we could increment the counter for each letter in ss and decrement the
         * counter for each letter in tt,
         * then check if the counter reaches back to zero
         */

        int[] table = new int[26];

        for (int i = 0; i < original.length(); i++) {
            table[original.charAt(i) - 'a']++;    // Compares ASCII integer values of the characters
            // Increments the count of each character occurrence by 1
            // Position to increment is the character's position between 1-26
        }
        for (int i = 0; i < toValidate.length(); i++) {
            table[toValidate.charAt(i) - 'a']--;            // Decreases the count of each char occurrence

            if (table[toValidate.charAt(i) - 'a'] < 0) {    // <0 means that character has occurred more times in
            	// second string
                return false;                                // So, not valid anagram
            }
        }

        logger.log(Level.INFO, "Anagram is valid");
        return true;

        /*
         * SOLUTION No. 3 -> Complexity n-square // Create original Map HashMap<Integer,
         * Character> originalMap = new HashMap<>(); for (int i = 0; i <
         * original.length(); i++) { originalMap.put(i, original.charAt(i)); }
         *
         * // Validate int counter = 1; for (int i = 0; i < toValidate.length(); i++) {
         * if (originalMap.containsValue(toValidate.charAt(i))) { counter++; } }
         *
         * String counters = String.valueOf(counter); log.log(Level.INFO, counters);
         * return (counter == original.length());
         */
    }

    private void printArrays(String toPrint) {
        logger.log(Level.INFO, toPrint);
    }
}

/*
 * OUTPUT: Jun 30, 2018 6:51:37 PM algorithms.ValidAnagram main INFO: Program to
 * check for valid Anagram: Jun 30, 2018 6:51:37 PM algorithms.ValidAnagram
 * printArrays INFO: Anagram Jun 30, 2018 6:51:37 PM algorithms.ValidAnagram
 * printArrays INFO: Nagaram Jun 30, 2018 6:51:37 PM algorithms.ValidAnagram
 * validateAnagram INFO: 7 Jun 30, 2018 6:51:37 PM algorithms.ValidAnagram main
 * INFO: true
 */
