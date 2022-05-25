package com.patterns.design.strategyPattern;

public class NoFly implements FlyBehavior {

    public void fly() {
        System.out.println("I am a duck who does NOT Fly");
    }
}
