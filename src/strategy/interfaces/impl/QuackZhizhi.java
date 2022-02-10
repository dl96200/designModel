package strategy.interfaces.impl;

import strategy.interfaces.QuackBehavior;

public class QuackZhizhi implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("吱吱叫");
    }
}
