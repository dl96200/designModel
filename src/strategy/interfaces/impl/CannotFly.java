package strategy.interfaces.impl;

import strategy.interfaces.FlyBehavior;

public class CannotFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can not fly");
    }
}
