package strategy.interfaces.impl;

import strategy.interfaces.FlyBehavior;

public class CanFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can fly");
    }
}
