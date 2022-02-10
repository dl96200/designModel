package decorator.eg;

public class EggDecorator extends Decorator{
    public EggDecorator(Drink drink) {
        super(drink);
    }

    @Override
    public double price() {
        return super.price()+2.2;
    }

    @Override
    public String desc() {
        return super.desc()+"+鸡蛋";
    }
}
