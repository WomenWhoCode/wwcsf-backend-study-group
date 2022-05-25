package coding.problems;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class StringNonRepeatCharacter {
    public static void main(String[] args) {
        StringNonRepeatCharacter stringNonRepeatCharacter = new StringNonRepeatCharacter();

        String swiss = "swiss";
        String twisters = "twisters";
        String sswwyy = "sswwyy";

        System.out.println(stringNonRepeatCharacter.getFirstNonRepeatingCharacter(swiss));
        System.out.println(stringNonRepeatCharacter.getFirstNonRepeatingCharacter(twisters));
        System.out.println(stringNonRepeatCharacter.getFirstNonRepeatingCharacter(sswwyy));
    }

    private char getFirstNonRepeatingCharacter(String word) {
        Map<Character, Integer> mapOfCharacters = new LinkedHashMap<>(word.length());

        for (char ch : word.toCharArray()) {
            if (mapOfCharacters.containsKey(ch)) {
                mapOfCharacters.put(ch, mapOfCharacters.get(ch) + 1);
            } else {
                mapOfCharacters.put(ch, 1);
            }
        }

        Set<Map.Entry<Character, Integer>> entrySet = mapOfCharacters.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        mapOfCharacters.clear();
        return ' ';
    }

}
