package language.features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsApi {

    private static List<String> fruits = new ArrayList<>();

    public static void main(String[] args) {
        CollectionsApi c = new CollectionsApi();
        c.addAll();
        c.sort();
        c.sortComparator();
        c.sortComparatorReverse();
    }

    private void addAll() {
        Collections.addAll(fruits, "Apple", "Banana", "Orange");
        System.out.println("AddAll(): ");
        fruits.forEach(System.out::println);
    }

    private void sort() {
        fruits.add("Cantaloupe");
        fruits.add("Pomegranate");
        fruits.add("Cherry");
        Collections.sort(fruits);
        System.out.println("Sort(): ");
        fruits.forEach(System.out::println);
    }

    private void sortComparator() {
        fruits.add("Papaya");
        fruits.add("Avocado");
        fruits.sort(comparator);
        System.out.println("Sort using Comparator(): ");
        fruits.forEach(System.out::println);
    }

    private void sortComparatorReverse() {
        fruits.add("Pineapple");
        fruits.add("Lemon");
//        fruits.add("Tamarind");
//        fruits.add("Mango");
        fruits.sort(Comparator.reverseOrder());
        System.out.println("Sort Reverse order using Comparator(): ");
        fruits.forEach(System.out::println);
    }

    private static Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            return s1.compareTo(s2);
        }
    };

}
