package template;

/**
 * 抽象基类，为所有 子类提供一个算法框架
 * 提神饮料
 */
public abstract class RefreshBeverage {
    /**
     * 制备饮料的模板方法
     * 封装了所有子类共同遵循的算法框架
     */
    public final void prepareBeverageTemplate(){
        //步骤一 将水煮沸
        boilWater();
        //步骤二 炮制饮料
        brew();
        //步骤三 倒入杯中
        pourInCup();
        //步骤四 加入调味料
        if(isCustomerWantsCondiments()) {
            addCondiments();
        }
    }

    public boolean isCustomerWantsCondiments() {
        return true;
    }

    private void boilWater() {
        System.out.println("将水煮沸");
    }
    protected abstract void brew();
    private void pourInCup() {
        System.out.println("倒入杯中");
    }
    protected abstract void addCondiments() ;

}
