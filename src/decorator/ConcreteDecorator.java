package decorator;

import decorator.eg.Drink;

public class ConcreteDecorator extends Decorator{

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operate() {
        super.operate();
        System.out.println("已装饰");
    }
}
