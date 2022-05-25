package com.patterns.design.strategyPattern;

public class Quack implements QuackBehavior {

    public void quack() {
        System.out.println("I am a duck who Quacks");
    }
}
