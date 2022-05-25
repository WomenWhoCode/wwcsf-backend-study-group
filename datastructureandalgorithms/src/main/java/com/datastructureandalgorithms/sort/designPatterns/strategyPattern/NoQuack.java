package com.patterns.design.strategyPattern;

public class NoQuack implements QuackBehavior {

    public void quack() {
        System.out.println("I am a duck who does NOT Quack");
    }
}
