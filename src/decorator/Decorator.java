package decorator;

import decorator.eg.Drink;

//实现抽象组件接口
public class Decorator implements Component{
    Component component;
    //持有抽象接口的引用

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operate() {
    }
}
