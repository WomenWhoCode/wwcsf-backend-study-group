package data.structures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class StringDuplicates {
    public static void main(String[] args) {
        StringDuplicates duplicates = new StringDuplicates();
        String java = "Java";   // a
        String twister = "twister"; // t
        duplicates.findDuplicates(java);
        duplicates.findDuplicates(twister);
    }

    private void findDuplicates(String word) {
        if (word == null || word.isEmpty()) {
            System.out.println("Cannot find duplicates because string is null or empty.");
        }
        HashMap<Character, Integer> duplicates = new HashMap<>();
        char[] characters = word.toCharArray();
        for (char ch : characters) {
            if (duplicates.containsKey(ch)) {
                duplicates.put(ch, duplicates.get(ch) + 1);
            } else {
                duplicates.put(ch, 1);
            }
        }

        Set<Entry<Character, Integer>> entrySet = duplicates.entrySet();
        for (Entry entry : entrySet) {
            if ((Integer) entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }
    }

}
