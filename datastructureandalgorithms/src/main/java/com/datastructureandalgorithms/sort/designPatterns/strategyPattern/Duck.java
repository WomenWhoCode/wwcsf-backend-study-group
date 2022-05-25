//@author prachi.shah
//@info Abstract class
// Base class

package com.patterns.design.strategyPattern;

public abstract class Duck {

    //create reference to quack and fly behaviors

    QuackBehavior quackBahaviorOfDuck;
    FlyBehavior flyBehaviorOfDuck;

    // setter methods for both
    public void setQuackBahaviorOfDuck(QuackBehavior qb) {
        this.quackBahaviorOfDuck = qb;
    }

    public void setFlyBehaviorOfDuck(FlyBehavior fb) {
        this.flyBehaviorOfDuck = fb;
    }

    //display method which is Abstract so it can be overriden by Duck subclasses
    public abstract void display();

    public void doQuack() {
        quackBahaviorOfDuck.quack();
    }

    public void goFly() {
        flyBehaviorOfDuck.fly();
    }
}
