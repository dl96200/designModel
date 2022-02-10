package strategy;
import strategy.interfaces.QuackBehavior;
import strategy.interfaces.impl.CanFly;
import strategy.interfaces.impl.CannotFly;
import strategy.interfaces.impl.QuackGaga;

public class RubberDuck extends Duck{
    public RubberDuck(){
      super();
      super.setFlyBehavior(new CannotFly());
      super.setQuackBehavior(new QuackBehavior() {
          @Override
          public void quack() {
              System.out.println("我不会叫呀");
          }
      });
    }

    @Override
    public void display() {
        System.out.println("我的材质事橡胶");
    }

}
