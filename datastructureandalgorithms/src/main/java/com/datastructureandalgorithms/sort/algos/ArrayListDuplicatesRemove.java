package data.structures;

import java.util.*;
import java.util.Map;

public class ArrayListDuplicatesRemove {

    public static void main(String[] args) {
        ArrayListDuplicatesRemove sol = new ArrayListDuplicatesRemove();

        List<Integer> duplicateIntegersList = new ArrayList<>();
        duplicateIntegersList.add(1);
        duplicateIntegersList.add(2);
        duplicateIntegersList.add(2);
        duplicateIntegersList.add(3);
        duplicateIntegersList.add(4);
        duplicateIntegersList.add(6);
        duplicateIntegersList.add(4);
        duplicateIntegersList.add(1);
        duplicateIntegersList.add(5);
        duplicateIntegersList.add(7);
        duplicateIntegersList.add(6);
        duplicateIntegersList.add(5);
        System.out.println("First List: " + duplicateIntegersList.toString());

        List<Integer> uniqueIntegersList = new ArrayList<>();
        uniqueIntegersList.add(1);
        uniqueIntegersList.add(2);
        uniqueIntegersList.add(3);
        uniqueIntegersList.add(4);
        System.out.println("Second List: " + uniqueIntegersList.toString());

        System.out.println("\nRemove duplicates iteratively:");
        System.out.println("First List: " + sol.removeDuplicates(duplicateIntegersList).toString());
        System.out.println("Second List: " + sol.removeDuplicates(uniqueIntegersList).toString());

        System.out.println("\nRemove duplicates using Set collection:");
        System.out.println("First List: " + sol.removeDuplicatesUsingSet(duplicateIntegersList).toString());
        System.out.println("Second List: " + sol.removeDuplicatesUsingSet(uniqueIntegersList).toString());
    }

    private List<Integer> removeDuplicates(List<Integer> listOfIntegers) {
        Map<Integer, Integer> mapOfIntegers = new HashMap<>();

        for (int i = 0; i < listOfIntegers.size(); i++) {
            if (mapOfIntegers.containsKey(listOfIntegers.get(i))) {
                listOfIntegers.remove(i);
                i--;
            } else {
                mapOfIntegers.put(listOfIntegers.get(i), i);
            }
        }
        return listOfIntegers;
    }

    private List<Integer> removeDuplicatesUsingSet(List<Integer> listOfIntegers) {
        Set<Integer> numbersWithoutDuplicates = new HashSet<>(listOfIntegers);
        listOfIntegers.clear();
        listOfIntegers.addAll(numbersWithoutDuplicates);
        return listOfIntegers;
    }

}
