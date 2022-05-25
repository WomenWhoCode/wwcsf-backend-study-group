package com.datastructureandalgorithms.algorithms.leetcode.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChimeSolution {

  /** Question:
   * You've been asked to program a bot for a popular bank that will automate the management of incoming requests. There are three types of requests the bank can receive:
   * * transfer i j sum: request to transfer sum amount of money from the ith account to the jth one (i and j are 1-based);
   * * deposit i sum: request to deposit sum amount of money in the ith account (1-based);
   * * withdraw i sum: request to withdraw sum amount of money from the ith account (1-based).
   * Your bot should also be able to process invalid requests. There are two types of invalid requests:
   * * invalid account number in the requests;
   * * withdrawal / transfer of a larger amount of money than is currently available.
   * For the given list of balances and requests, return the state of balances after all requests have been processed, or an array of a single element [-<request_id>] (please note the minus sign), where <request_id> is the 1-based index of the first invalid request.
   * Example
   * * For balances = [10, 100, 20, 50, 30] and requests = ["withdraw 2 10", "transfer 5 1 20", "deposit 5 20", "transfer 3 4 15"], the output should be solution(balances, requests) = [30, 90, 5, 65, 30]. Here are the states of balances after each request:
   *     * "withdraw 2 10": [10, 90, 20, 50, 30];
   *     * "transfer 5 1 20": [30, 90, 20, 50, 10];
   *     * "deposit 5 20": [30, 90, 20, 50, 30];
   *     * "transfer 3 4 15": [30, 90, 5, 65, 30], which is the answer.
   * * For balances = [20, 1000, 500, 40, 90] and requests = ["deposit 3 400", "transfer 1 2 30", "withdraw 4 50"], the output should be solution(balances, requests) = [-2]. After the first request, balances becomes equal to [20, 1000, 900, 40, 90], but the second one turns it into [-10, 1030, 900, 40, 90], which is invalid. Thus, the second request is invalid, and the answer is [-2]. Note that the last request is also invalid, but it shouldn't be included in the answer.
   * Input/Output
   * * [execution time limit] 3 seconds (java)
   * * [input] array.integer balances Array of integers, where balances[i] is the amount of money in the (i + 1)th account. Guaranteed constraints: 0 < balances.length ≤ 100, 0 ≤ balances[i] ≤ 105.
   * * [input] array.string requests Array of requests in the order they should be processed. Each request is guaranteed to be in the format described above. It is guaranteed that for each i and j in a request 0 < i, j ≤ 1000. Guaranteed constraints: 0 < requests.length ≤ 100, for each i, j and sum in each element of request:
   *     * 0 < i ≤ 1000,
   *     * 0 < j ≤ 1000,
   *     * 0 ≤ sum ≤ 105.
   * * [output] array.integer The balances after executing all of the requests or array with a single integer - the index of the first invalid request preceded by -.
   * [Java] Syntax Tips
   * // Prints help message to the console
   * // Returns a string
   * //
   * // Globals declared here will cause a compilation error,
   * // declare variables inside the function instead!
   * String helloWorld(String name) {
   *     System.out.println("This prints to the console when you Run Tests");
   *     return "Hello, " + name;
   * }
   */
  public static void main(String[] args) {
    ChimeSolution cs = new ChimeSolution();
    int[] balances = {10, 100, 20, 50, 30};
    String[] requests = {"withdraw 2 10", "transfer 5 1 20", "deposit 5 20", "transfer 3 4 15"};
    System.out.println(Arrays.toString(cs.solution(balances, requests)));
  }

  int[] solution(int[] balances, String[] requests) {
// Data validations
    if (balances.length == 0 || requests.length == 0) {
      throw new RuntimeException("Kindly provide correct input");
    }

    List<Integer> balanceList = new ArrayList<>();
    for (int i = 0; i < balances.length; i++) {
      balanceList.add(balances[i]);
    }

    List<String> requestList = new ArrayList<>();
    for (int i = 0; i < requests.length; i++) {
      requestList.add(requests[i]);
    }

    for (int i = 0; i < requestList.size(); i++) {
      String[] requestTypes = requestList.get(i).split(" ");
      String nameOfTransaction = requestTypes[0]; // withdraw OR deposit
      if (requestTypes.length == 3) {
        int account = Integer.parseInt(requestTypes[1]);  // 2
        int amount = Integer.parseInt(requestTypes[2]);   // 10
        // withdraw
        // blances index accountnumber 2 -1 -> 100
        // 10 < 100
        // balance[1] is > 0
        // balance[1] 100 -10;
        // deposit: blances index accountnumber 2 -1 -> 100
        // balance[1] + 10
        if (nameOfTransaction == "withdraw") {
          int balanceAmount = balanceList.get(account - 1); // 100
          if (balanceAmount > 0 && balanceAmount - amount >= 0) {
            balanceList.set(account - 1, balanceAmount - amount);
          } else {
            int result = i * -1;
            return new int[]{result};
          }
        }
        if (nameOfTransaction == "deposit") {    // deposit
          int balanceAmount = balanceList.get(account - 1); // 100
          balanceList.set(account - 1, balanceAmount + amount);
        } else {
          int result = account * -1;
          return new int[]{result};
        }
      } else {
        if (nameOfTransaction == "transfer") {
          int accountFrom = Integer.parseInt(requestTypes[1]);  // 5
          int accountTo = Integer.parseInt(requestTypes[2]);  // 1
          int amount = Integer.parseInt(requestTypes[3]);   // 20
          int balanceAmountFromAccount = balanceList.get(accountFrom - 1);
          if (balanceAmountFromAccount > 0 && balanceAmountFromAccount >= amount) {
            balanceList.set(accountFrom - 1, balanceAmountFromAccount - amount);
            int balanceAmountToAccount = balanceList.get(accountTo - 1);
            balanceList.set(accountTo - 1, balanceAmountToAccount + amount);
          } else {
            int result = i * -1;
            return new int[]{result};
          }
        }
      }
    }
    return balanceList.stream()
        .mapToInt(Integer::intValue)
        .toArray();
  }
}
