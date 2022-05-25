package coding.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String[] group = new String[]{"are", "bat", "ear", "code", "tab", "era"};
        System.out.println("Grouped Anagrams: " + ga.groupAnagrams(group));
    }

    public List<List<String>> groupAnagrams(String[] group) {
        HashMap<String, List<String>> anagrams = new HashMap<>();
        for (String str : group) {
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!anagrams.containsKey(key)) {
                anagrams.put(key, new ArrayList<>());
            }
            anagrams.get(key).add(str);

        }
        return new ArrayList<>(anagrams.values());
    }
}
