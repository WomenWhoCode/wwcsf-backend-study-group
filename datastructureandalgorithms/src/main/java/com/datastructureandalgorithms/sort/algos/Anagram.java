package coding.problems;

import java.util.Collections;
import java.util.Arrays;

// https://javarevisited.blogspot.com/2013/03/Anagram-how-to-check-if-two-string-are-anagrams-example-tutorial.html
public class Anagram {

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        String bob = "bob";
        String ride = "ride";
        String dire = "dire";
        String tire = "tire";
        String rite = "rite";
        String tide = "tide";
        System.out.println(anagram.isAnagramUsingCollections(ride, dire));  // true
        System.out.println(anagram.isAnagramUsingCollections(tire, rite));  // true
        System.out.println(anagram.isAnagramUsingCollections(tide, rite));  // false
        System.out.println(anagram.isAnagramUsingCollections(tide, bob));  // false
    }

    private boolean isAnagramUsingCollections(String one, String two) {
        if (one.isEmpty() || two.isEmpty() || one.length() != two.length()) {
            return false;
        }

        char[] oneToArray = one.toCharArray();
        char[] twoToArray = two.toCharArray();
        Arrays.sort(oneToArray);
        Arrays.sort(twoToArray);
        return Arrays.equals(oneToArray, twoToArray);
    }

}
