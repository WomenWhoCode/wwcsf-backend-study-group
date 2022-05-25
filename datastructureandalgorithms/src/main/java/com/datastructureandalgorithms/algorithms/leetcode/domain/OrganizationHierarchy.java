package com.datastructureandalgorithms.algorithms.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author prachishah
 */
public class OrganizationHierarchy {

  // Command line or String input
  // 1:Max:4,4:Ann:0,2:Jim:4,3:Tom:1
  // Position:Name:No_of_direct_reports
  // String input in format. Print org. chart in tree structure.
  // 1 root node: Max, 4 direct reports. They are not mentioned in the input.
  // 4: Ann, no direct report
  // 2: Jim, 4 direct reports
  // 3: Tom, 1 direct report
  // Max
  //  -Jim
  //    --Tom
  //      ---Ann
  public static void main(String[] args) {
    OrganizationHierarchy organizationHierarchy = new OrganizationHierarchy();
    String organizationChart = "1:Max:4,4:Ann:0,2:Jim:4,3:Tom:1";
    Map<String, Map<String, String>> hierarchy = organizationHierarchy.getOrganizationHierarchy(
        organizationChart);
    System.out.println(organizationHierarchy.printHierarchy(hierarchy));
  }

  public Map<String, Map<String, String>> getOrganizationHierarchy(String organizationChart) {
    // Data Validations
    if (organizationChart == null || organizationChart.isEmpty()) {
      System.out.println(
          "Cannot get organization hierarchy. Kindly provide an organization chart.");
      return new HashMap<>();
    }

    // Map of Maps
    Map<String, Map<String, String>> organizationHierarchy = new HashMap<>();
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
      String name = names[1]; // Max
      String numDirectReports = names[2]; // 4
      Map<String, String> directReports = new HashMap<>();
      directReports.put(name, numDirectReports);
      organizationHierarchy.put(pos, directReports);
    }
    return organizationHierarchy;
  }

  private String printHierarchy(Map<String, Map<String, String>> hierarchy) {
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

}

// Output:
// Max
// -Jim
// --Tom
// ---Ann