package data.structures;

import java.util.Arrays;

public class ArrayReverseInPlace {
    public static void main(String[] args) {
        ArrayReverseInPlace inPlace = new ArrayReverseInPlace();
        String scala = "scala";
        String docker = "docker";
        System.out.println("Reverse of '" + scala + "': " + inPlace.reverse(scala));
        System.out.println("Reverse of '" + docker + "': " + inPlace.reverse(docker));
    }

    private String reverse(String word) {
        char[] characters = word.toCharArray();

        for (int i = 0; i < characters.length / 2; i++) {
            char temp = characters[i];
            characters[i] = characters[characters.length - 1 - i];
            characters[characters.length - 1 - i] = temp;
        }
        return Arrays.toString(characters);
    }

}
