package proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface InvocationHandler {
    public Object invoke(Object proxy, Method m, Object...o);
}

class TimeHandler implements InvocationHandler {
    public Car target;
    public TimeHandler(Car target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method m, Object... o) {
        try {
            System.out.println("run log:"+System.currentTimeMillis());
            m.invoke(this.target);
            System.out.println("run log:"+System.currentTimeMillis());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}
