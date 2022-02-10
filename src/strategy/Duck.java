package strategy;

import strategy.interfaces.FlyBehavior;
import strategy.interfaces.QuackBehavior;

public class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void swim() {
        System.out.println("I can swim");
    }
    public void display() {
        System.out.println("I can display");
    }
    public void fly() {
        this.flyBehavior.fly();
    }
    public void quack() {
        this.quackBehavior.quack();
    }
}
