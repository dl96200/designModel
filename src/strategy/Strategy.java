package strategy;

/**
 * 策略模式
 * 分析项目开发的变话部分，通过接口的封装，把变化的部分与不变化部分联系起来，不变的部分使用接口，变化部分增加实现
 * 1，本示例中根据鸭子的后续变化需求，将 叫声（quack）与 飞行（fly）,将后续各自变化统一包装为行为的接口，飞行的行为，叫声的行为，
 * 并在父类中组合该接口，实现不同行为的扩展
 */
public class Strategy {
    public static void main(String[] args) {
        //创建
        Duck duck = new RedHeadDuck();
        duck.display();
        duck.fly();
        duck.quack();
        //创建
        Duck duck2 = new RubberDuck();
        duck2.display();
        duck2.fly();
        duck2.quack();
    }
}
