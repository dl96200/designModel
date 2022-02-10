package decorator.eg;

/**
 * 装饰器
 * 1,抽象类
 * 2,实现抽象组件接口
 * 3,持有抽象接口的引用
 */

public abstract class Decorator implements Drink{
    //实现抽象组件接口
    private Drink drink;
    //持有抽象接口的引用

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public double price() {
        return drink.price();
    }

    @Override
    public String desc() {
        return drink.desc();
    }
}
