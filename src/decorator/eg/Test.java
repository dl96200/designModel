package decorator.eg;

public class Test {
    public static void main(String[] args) {
        Soya soya = new Soya();
        Decorator redBean = new RedBeanDecorator(soya);
        Decorator egg = new EggDecorator(redBean);
        Decorator sugar = new SugarDecorator(egg);
        System.out.println(redBean.desc()+"==>"+redBean.price());;
        System.out.println(egg.desc()+"==>"+egg.price());;
        System.out.println(sugar.desc()+"==>"+sugar.price());;
    }
}
