package coding.problems;

/**
 * Recursion
 * Towers Of Hanoi
 * 4 discs: n 3 posts: from, to, auxiliary
 * <p>
 * https://www.youtube.com/watch?v=SAAhUjv0tsM
 * https://www.youtube.com/watch?v=rVPuzFYlfYE
 * <p>
 * recursion(nDisks, fromSource, toDestination, usingAuxiliary);
 * <p>
 * Time complexity:  exponential O(2^n)
 * There are exactly 2^n-1 moves, so for listing them all we cannot do better than O(2^n) time complexity.
 * <p>
 * Space complexity: O(n) space and increasing
 *
 * @author prachi.shah
 */
public class RecursionTowersOfHanoi {

    private static String from = "A";
    private static String to = "C";
    private static String auxiliary = "B";

    private static void recursion(int disk, String from, String to, String auxiliary) {
        if (disk == 1) // base case/end condition = only 1 disk
        {
            System.out.println("Moved " + disk + " from: " + from + " to: " + to);
        } else {
            recursion(disk - 1, from, auxiliary, to); // calling same method

            System.out.println("Moved " + disk + " from " + from + " to " + to);

            recursion(disk - 1, auxiliary, to, from); // calling same method
        }
    }

    public static void main(String[] args) {
        recursion(4, from, to, auxiliary);
    }
}

/*
 * OUTPUT:
Moved 1 from: A to: B
Moved 2 from A to C
Moved 1 from: B to: C
Moved 3 from A to B
Moved 1 from: C to: A
Moved 2 from C to B
Moved 1 from: A to: B
Moved 4 from A to C
Moved 1 from: B to: C
Moved 2 from B to A
Moved 1 from: C to: A
Moved 3 from B to C
Moved 1 from: A to: B
Moved 2 from A to C
Moved 1 from: B to: C
 */
