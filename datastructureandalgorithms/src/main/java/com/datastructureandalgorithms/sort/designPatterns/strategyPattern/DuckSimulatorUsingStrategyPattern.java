package com.patterns.design.strategyPattern;

// Driver class: is the starting point of the application
public class DuckSimulatorUsingStrategyPattern {

    public static void main(String[] args) {

        Duck duck = new MallardDuck();

        // Mallard Duck who quacks and flies
        duck.setFlyBehaviorOfDuck(new Fly());
        duck.setQuackBahaviorOfDuck(new Quack());
        duck.display();
        duck.doQuack();
        duck.goFly();

        // Decoy Duck who does NOT quacks and does NOT fly
        duck = new DecoyDuck();
        duck.setFlyBehaviorOfDuck(new FlyWithARocket());
        duck.setQuackBahaviorOfDuck(new NoQuack());
        duck.display();
        duck.doQuack();
        duck.goFly();

        // Rubber Duck who squeaks and flies with a Rocket
        duck = new RubberDuck();
        duck.setFlyBehaviorOfDuck(new NoFly());
        duck.setQuackBahaviorOfDuck(new Squeak());
        duck.display();
        duck.doQuack();
        duck.goFly();
    }
}
