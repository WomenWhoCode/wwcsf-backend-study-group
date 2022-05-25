package data.structures;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ArrayListDuplicates {
    public static void main(String[] args) {
        ArrayListDuplicates dup = new ArrayListDuplicates();
        String wordOdd = "obodbad";
        String wordEven = "abcdca";

        System.out.println("All duplicate characters are:");
        dup.findDuplicates(wordOdd);
        dup.findDuplicates(wordEven);

        System.out.println("Duplicate characters in '" + wordOdd + "' are: ");
        dup.findDuplicatesAndIndex(wordOdd);
        System.out.println("Duplicate characters in '" + wordEven + "' are: ");
        dup.findDuplicatesAndIndex(wordEven);
    }

    private void findDuplicatesAndIndex(String word) {
        // Build HashMap with character and number of times they appear in String
        HashMap<Character, Integer> mapOfCharacters = new HashMap<>();  // 26 max size
        char[] characters = word.toCharArray();
        for (char ch : characters) {
            if (mapOfCharacters.containsKey(ch)) {
                mapOfCharacters.put(ch, mapOfCharacters.get(ch) + 1);
            } else {
                mapOfCharacters.put(ch, 1);
            }
        }

        // Iterate through HashMap to print all duplicate characters of String
        Set<Map.Entry<Character, Integer>> entrySet = mapOfCharacters.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                System.out.printf("%s : %d %n", entry.getKey(), entry.getValue());
            }
        }
    }

    private void findDuplicates(String word) {
        HashMap<Character, Integer> mapOfCharacters = new HashMap<>();  // 26 max size
        StringBuilder duplicates = new StringBuilder();
        char[] characters = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (mapOfCharacters.containsKey(characters[i])) {
                duplicates.append(characters[i]);
            } else {
                mapOfCharacters.put(characters[i], i);
            }
        }
        System.out.printf("Duplicates are: %s%n", duplicates.toString());
    }

}
