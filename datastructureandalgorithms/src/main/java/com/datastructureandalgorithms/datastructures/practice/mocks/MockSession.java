package com.datastructureandalgorithms.mocks;

public class MockSession {

  public static void main(String[] args) {
    MockSession mockSession = new MockSession();
    System.out.println("Hello World!");
    mockSession.printNumbers(10);
  }

  public void printNumbers(int count) {
    for (int i = 0; i < count; i++) {
      System.out.print(i + " ");
    }
  }

}