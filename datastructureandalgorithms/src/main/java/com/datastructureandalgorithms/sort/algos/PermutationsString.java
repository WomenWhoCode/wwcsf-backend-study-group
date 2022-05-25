package coding.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

// TODO
public class PermutationsString {
    public static void main(String[] args) {
        PermutationsString permutations = new PermutationsString();
        String swiss = "a";
        String twisters = "ab";

        System.out.println(permutations.getPermutations(swiss).toString());
        System.out.println(permutations.getPermutations(twisters).toString());
    }

    private List getPermutations(String word) {
        if (word.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        if (word.length() == 1) {
            return Collections.singletonList(word);
        }

        if (word.length() == 2) {
            char[] perm = new char[]{word.charAt(0), word.charAt(1)};
            return Arrays.asList(word, Arrays.toString(perm));
        }
        return Collections.EMPTY_LIST;
    }

}
