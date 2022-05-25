package com.datastructureandalgorithms.algorithms.practice;

import java.util.HashMap;
import java.util.Map;

public class OrganizationHierarchyOptimized {

  public static void main(String[] args) {
    OrganizationHierarchyOptimized organizationHierarchyOptimized = new OrganizationHierarchyOptimized();
    String organizationChart = "1:Max:4,4:Ann:0,2:Jim:4,3:Tom:1,5:John:6";
//    OrganizationHierarchyOptimized.Employee employee = organizationHierarchyOptimized.new Employee();
    Map<String, Map<String, Employee>> hierarchy = organizationHierarchyOptimized.getOrganizationHierarchy(
        organizationChart);
    System.out.println(organizationHierarchyOptimized.printHierarchy(hierarchy));
  }

  public Map<String, Map<String, Employee>> getOrganizationHierarchy(String organizationChart) {
    // Data Validations
    if (organizationChart == null || organizationChart.isEmpty()) {
      System.out.println(
          "Cannot get organization hierarchy. Kindly provide an organization chart.");
      return new HashMap<>();
    }

    // Map of Maps
    Map<String, Map<String, Employee>> organizationHierarchy = new HashMap<>();
    // <1, <Max, 4>>
    // 1:Max:4
    // 4:Ann:0
    // 2:Jim:4
    // 3:Tom:1
    String[] positions = organizationChart.split(",");
    for (String position : positions) {
      // Data Validations
      if (position == null || position.isEmpty()) {
        System.out.println("Kindly provide an organization position.");
        return new HashMap<>();
      }
      // 1
      // Max
      // 4
      // 4
      // Ann
      // 0
      // 2
      // Jim
      // 4
      // 3
      // Tom
      // 1
      String[] names = position.split(":");
      // names size 4 -> 1:Max:4:EMPTY_STRING
      // else 5 -> 3:Tom:4:1:Max
      String pos = names[0];  // 1
      Employee employee = new Employee();
      employee.name = names[1]; // Max
      employee.directReports = names[2]; // 4
      Map<String, Employee> directReports = new HashMap<>();
      directReports.put(employee.name, employee);
      organizationHierarchy.put(pos, directReports);
    }
    return organizationHierarchy;
  }

  private String printHierarchy(Map<String, Map<String, Employee>> hierarchy) {
    if (hierarchy.isEmpty()) {
      System.out.println("Cannot print organization hierarchy");
      return "";
    }

    // new entry we print name, add '-' prefix
    StringBuilder sb = new StringBuilder();
    hierarchy.forEach((key, value) -> {
      int keyInt = Integer.parseInt(key); // 1 4 2 3
      // hyphen = index/position
      String hyphen = "-";
      int count = keyInt - 1; // no. of hyphens
      sb.append("\n");
      for (int i = 0; i < count; i++) {
        sb.append(hyphen);
      }
//      value.entrySet().forEach(e -> sb.append(e.getKey()));
      // OR:
      value.forEach((k, v) -> sb.append(k));
    });
    return sb.toString();
  }

  // Inner Class
  public class Employee {

    String name;
    String directReports;
  }

}

// Output:
// Max
// -Jim
// --Tom
// ---Ann
// ----John