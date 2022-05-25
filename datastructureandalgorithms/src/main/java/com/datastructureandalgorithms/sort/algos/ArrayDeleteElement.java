package data.structures;

import java.util.Arrays;

public class ArrayDeleteElement {

    public static void main(String[] args) {
        char[] array = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(deleteArray(array, 4)));
        System.out.println(deleteArray(array, 4).length);
    }

    public static char[] deleteArray(char[] inputArray, int position) {
        if (position >= 0 && position < inputArray.length) {
            char[] temp = new char[inputArray.length - 1]; // -1 as the array will now shrink by 1
            System.arraycopy(inputArray, 0, temp, 0, position);
            System.arraycopy(inputArray, position + 1, temp, position, inputArray.length - position - 1);
            return temp;
        } else {
            return inputArray;
        }
    }

}
