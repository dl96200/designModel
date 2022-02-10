package strategy.interfaces.impl;

import strategy.interfaces.QuackBehavior;

public class QuackGaga implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("嘎嘎叫");
    }
}
