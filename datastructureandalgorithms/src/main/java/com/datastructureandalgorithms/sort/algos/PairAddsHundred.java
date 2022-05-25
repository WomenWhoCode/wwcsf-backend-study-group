package coding.problems;

import java.util.*;

/* PagerDuty onsite interview question 2019
 * Find a pair that adds up to a 100 - with an added requirement not to remove any duplicate pair.  Given no.s between 1
 * & 99 find all pairs that add to 100
 *
 * https://www.geeksforgeeks.org/count-pairs-with-given-sum/
 * https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/
 */
public class PairAddsHundred {

    public static void main(String[] args) {
        int[] A = new int[]{1, 5, 7, -1, 5};
        int[] B = {10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1};
        int[] C = {1, 1, 1, 1};
        int sumA = 6;
        int sumB = 11;
        int sumC = 2;
        PairAddsHundred p = new PairAddsHundred();
        System.out.println("A: ");
        p.findAllPairsDuplicate(A, sumA)
                .forEach(integerPair -> System.out.println("D: " + integerPair.getFirstNumber() + " , " + integerPair.getSecondNumber()));
        System.out.println();
        p.findAllPairsNonDuplicate(A, sumA)
                .forEach(integerPair -> System.out.println("ND: " + integerPair.getFirstNumber() + " , " + integerPair.getSecondNumber()));
        System.out.println("\nB: ");
        p.findAllPairsDuplicate(B, sumB)
                .forEach(integerPair -> System.out.println("D: " + integerPair.getFirstNumber() + " , " + integerPair.getSecondNumber()));
        System.out.println();
        p.findAllPairsNonDuplicate(B, sumB)
                .forEach(integerPair -> System.out.println("ND: " + integerPair.getFirstNumber() + " , " + integerPair.getSecondNumber()));
        System.out.println("\nC: ");
        p.findAllPairsDuplicate(C, sumC)
                .forEach(integerPair -> System.out.println("D: " + integerPair.getFirstNumber() + " , " + integerPair.getSecondNumber()));
        System.out.println();
        p.findAllPairsNonDuplicate(C, sumC)
                .forEach(integerPair -> System.out.println("ND: " + integerPair.getFirstNumber() + " , " + integerPair.getSecondNumber()));
    }

    // No Duplicates
    private Set<IntegerPair> findAllPairsNonDuplicate(int[] A, int sum) {
        Set<IntegerPair> allPairs = new HashSet<>();
        Set<Integer> input = new HashSet<>(A.length);
        for (int i : A) {
            int difference = sum - i;
            if (input.contains(difference)) { // Found pair
                //if (!allPairs.contains(new IntegerPair(i, difference))) {
                allPairs.add(new IntegerPair(i, difference));
                // }
            }
            input.add(i);
        }
        return allPairs;
    }

    // Duplicate pairs
    private List<IntegerPair> findAllPairsDuplicate(int[] A, int sum) {
        List<IntegerPair> allPairs = new ArrayList<>();
        Set<Integer> input = new HashSet<>(A.length);
        for (int i : A) {
            int difference = sum - i;
            if (input.contains(difference)) { // Found pair
                allPairs.add(new IntegerPair(i, difference));
            }
            input.add(i);
        }
        return allPairs;
    }
}
// Output:
//      A:
//        D: 5 , 1
//        D: -1 , 7
//        D: 5 , 1
//
//        ND: 5 , 1
//        ND: -1 , 7
//
//        B:
//        D: -1 , 12
//        D: 5 , 6
//        D: 4 , 7
//        D: 1 , 10
//        D: 1 , 10
//        D: 1 , 10
//
//        ND: -1 , 12
//        ND: 5 , 6
//        ND: 4 , 7
//        ND: 1 , 10
//
//        C:
//        D: 1 , 1
//        D: 1 , 1
//        D: 1 , 1
//
//        ND: 1 , 1