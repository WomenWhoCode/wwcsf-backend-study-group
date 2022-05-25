package data.structures;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Program to calculate sum of two integers. Program to concatenate two strings which are inputted and integers.
 * <p>
 * Problem: Given two digits a and b, find a+b. Input format: The first line of
 * the input contains two integers a and b (separated by a space). Constraints:
 * 0???a,b???9. Output format: Output a+b.
 *
 * @author prachi.shah
 * @see //www.coursera.org/learn/algorithmic-toolbox/programming/ZtG0y/a-plus-b
 */
public class ConcatAdd {

    private static final Logger log = Logger.getLogger(ConcatAdd.class.getName());

    private static final int UPPERLIMIT = 9;
    private static final int LOWERLIMIT = 0;

    private void concatenateIntegers(int firstNumber, int secondNumber) {

        if (firstNumber >= LOWERLIMIT && firstNumber <= UPPERLIMIT && secondNumber >= LOWERLIMIT
                && secondNumber <= UPPERLIMIT) {
            String result = Integer.toString(firstNumber) + Integer.toString(secondNumber);
            log.log(Level.INFO, "Concatenation: {0}", result);
        }
    }

    private void addIntegers(int firstNumber, int secondNumber) {
        if (firstNumber >= LOWERLIMIT && firstNumber <= UPPERLIMIT && secondNumber >= LOWERLIMIT
                && secondNumber <= UPPERLIMIT) {
            int result = firstNumber + secondNumber;
            // int result = Integer.sum(firstNumber, secondNumber);
            log.log(Level.INFO, "Addition: {0}", result);
        } else {
            log.info("Cannot calculate the sum. Make sure the input numbers honor the constraint 0-9 single digit " +
                    "input.");
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int firstNumber = scan.nextInt();
        int secondNumber = scan.nextInt();

        ConcatAdd apb = new ConcatAdd();
        apb.concatenateIntegers(firstNumber, secondNumber);
        apb.addIntegers(firstNumber, secondNumber);

        scan.close();
    }
}

/*
 * Output:
 * 9
 * 9
 * Mar 24, 2018 4:27:20 PM data.structures.ConcatAdd concatenateIntegers
 * INFO: Concatenation: 99
 * Mar 24, 2018 4:27:20 PM data.structures.ConcatAdd
 * addIntegers INFO: Addition: 18
 */
