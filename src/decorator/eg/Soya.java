package decorator.eg;

/**
 * 被装饰者
 */
public class Soya implements Drink{
    @Override
    public double price() {
        return 5;
    }

    @Override
    public String desc() {
        return "豆浆";
    }
}
