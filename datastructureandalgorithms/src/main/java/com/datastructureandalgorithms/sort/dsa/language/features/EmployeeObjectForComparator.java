package language.features;

import java.util.Comparator;

public class EmployeeObjectForComparator implements Comparable<EmployeeObjectForComparator> {

    private int id;
    private String name;
    private int age;
    private long salary;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getSalary() {
        return salary;
    }

    public EmployeeObjectForComparator(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // For comparable interface
    @Override
    public int compareTo(EmployeeObjectForComparator emp) {
        return (this.id - emp.id);
    }

    // For comparator interface
    public static Comparator<EmployeeObjectForComparator> nameComparator =
            new Comparator<EmployeeObjectForComparator>() {
                @Override
                public int compare(EmployeeObjectForComparator o1, EmployeeObjectForComparator o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            };

    public static Comparator<EmployeeObjectForComparator> ageComparator =
            new Comparator<EmployeeObjectForComparator>() {
                @Override
                public int compare(EmployeeObjectForComparator o1, EmployeeObjectForComparator o2) {
                    return o1.getAge() - o2.getAge();
                }
            };

    public static Comparator<EmployeeObjectForComparator> salaryComparator =
            new Comparator<EmployeeObjectForComparator>() {
                @Override
                public int compare(EmployeeObjectForComparator o1, EmployeeObjectForComparator o2) {
                    return (int) (o1.getSalary() - o2.getSalary());
                }
            };

}
