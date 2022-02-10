package strategy;

import strategy.interfaces.impl.CanFly;
import strategy.interfaces.impl.QuackGaga;

public class RedHeadDuck extends Duck{
    public RedHeadDuck() {
        super();
        super.setFlyBehavior(new CanFly());
        super.setQuackBehavior(new QuackGaga());
    }
    @Override
    public void display() {
        System.out.println("我的脑袋红红");
    }
}
