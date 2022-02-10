package template;

public class Coffee extends RefreshBeverage{

    @Override
    protected void brew() {
        System.out.println("使用沸水冲泡咖啡");
    }

    @Override
    protected void addCondiments() {
        System.out.println("添加奶和糖");
    }
}
