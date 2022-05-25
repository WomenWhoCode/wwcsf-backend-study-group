package language.conversion;

import java.util.StringTokenizer;

public class StringManipulation {

    public static void main(String[] args) {

        // Ways to create a String
        String name = "name";
        String surname = new String("name");

        char[] middle = {'n', 'a', 'm', 'e'};
        String middleName = new String(middle);

        equals(name, surname, middleName);
        stringCharAt(name, surname);
        reverseString(name);
        reverseStringBuffer(new StringBuffer("name"));
        tokenizer("my name is PS");
    }

    private static void tokenizer(String sentence) {
        StringTokenizer st = new StringTokenizer(sentence, " ");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }

    private static void reverseStringBuffer(StringBuffer name) {
        StringBuffer sb = new StringBuffer();
        for (int i = name.length() - 1; i >= 0; i--) {
            sb.append(name.charAt(i));
        }
        System.out.println("Original: " + name);
        System.out.println("Reverse: " + sb.toString());

        System.out.println("Original: " + name);
        System.out.println("Reverse: " + name.reverse());
    }

    private static void reverseString(String name) {
        String reverse = "";
        for (int i = name.length() - 1; i >= 0; i--) {
            reverse += name.charAt(i);
        }
        System.out.println("Original: " + name);
        System.out.println("Reverse: " + reverse);
    }

    private static void stringCharAt(String name, String surname) {
        System.out.println("Char at and CompareTo:");
        System.out.println(name.charAt(3));
        System.out.println(name.toString());
        System.out.println(name.toCharArray());
        System.out.println(name.compareTo(surname));
        System.out.println(name.compareTo("last"));
    }

    private static void equals(String name, String surname, String middleName) {
        System.out.println("==");
        System.out.println(name == surname);
        System.out.println(name == middleName);
        System.out.println(middleName == surname);
        String nameAgain = "name";
        System.out.println(name == nameAgain);

        System.out.println("Equals:");
        System.out.println(name.equals(nameAgain));
        System.out.println(name.equals(surname));
        System.out.println(name.equals(middleName));
        System.out.println(name.equals("last"));
    }

}
