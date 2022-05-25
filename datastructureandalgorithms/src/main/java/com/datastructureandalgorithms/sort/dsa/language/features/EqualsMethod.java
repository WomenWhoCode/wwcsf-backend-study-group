package language.features;

/*
 * String equals() and == equality operator
 * @prachi.shah
 */
public class EqualsMethod {
    public static void main(String[] args) {

        String Str1 = "ABCD";
        String Str2 = "ABCD";
        String Str3 = Str2;
        if (Str1 != Str2) {
            System.out.println("String 1 == String 2 is false");
        } else {
            System.out.println("String 1 == String 2 is true");
            if (Str2 == Str3)
                System.out.println("String 2 == String 3 is true");
            else
                System.out.println("String 2 == String 3 is false");

            if (Str1.equals(Str2))
                System.out.println("String 1 equals string 2 is true");
            else
                System.out.println("String 1 equals string 2 is false");
        }
    }
}

/* OUTPUT:
String 1 == String 2 is true
String 2 == String 3 is true
String 1 equals string 2 is true
*/