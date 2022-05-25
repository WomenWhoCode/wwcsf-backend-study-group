package language.features;

import java.util.Arrays;
import java.util.Collections;

public class ComparableAndComparator {

    public static void main(String[] args) {
        EmployeeObjectForComparator[] empArr = new EmployeeObjectForComparator[4];
        empArr[0] = new EmployeeObjectForComparator(10, "Mikey", 25, 10000);
        empArr[1] = new EmployeeObjectForComparator(20, "Arun", 29, 20000);
        empArr[2] = new EmployeeObjectForComparator(5, "Lisa", 35, 5000);
        empArr[3] = new EmployeeObjectForComparator(1, "Pankaj", 32, 50000);

        // Sorting employees array using Comparable interface implementation
        System.out.println("Sort by ID:");
        Arrays.sort(empArr);
        for (EmployeeObjectForComparator emp : empArr) {
            System.out.println(emp.getId() + "  " + emp.getName() + "  " + emp.getAge() + "  " + emp.getSalary());
        }
        System.out.println("Default Sorting of Employees list:\n" + Arrays.toString(empArr));

        // Sorting by name, using Comparator interface
        System.out.println("Sort by Name:");
        Arrays.sort(empArr, EmployeeObjectForComparator.nameComparator);
        for (EmployeeObjectForComparator emp : empArr) {
            System.out.println(emp.getId() + "  " + emp.getName() + "  " + emp.getAge() + "  " + emp.getSalary());
        }

        // Sorting by age, using Comparator interface
        System.out.println("Sort by Age:");
        Arrays.sort(empArr, EmployeeObjectForComparator.ageComparator);
        for (EmployeeObjectForComparator emp : empArr) {
            System.out.println(emp.getId() + "  " + emp.getName() + "  " + emp.getAge() + "  " + emp.getSalary());
        }

        // Sorting by salary, using Comparator interface
        System.out.println("Sort by Salary:");
        Arrays.sort(empArr, EmployeeObjectForComparator.salaryComparator);
        for (EmployeeObjectForComparator emp : empArr) {
            System.out.println(emp.getId() + "  " + emp.getName() + "  " + emp.getAge() + "  " + emp.getSalary());
        }
    }

}
