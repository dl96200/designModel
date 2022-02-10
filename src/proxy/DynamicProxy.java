package proxy;

import java.lang.reflect.Proxy;

public class DynamicProxy {
    public static void main(String[] args) {
        Car car = new Car() {
            @Override
            public void run() {
                System.out.println("run now");
            }
        };
        Car proxy =  (Car) Proxy.newProxyInstance(Car.class.getClassLoader(),new Class[]{Car.class}, (proxy1, method, args1) -> {
            System.out.println("before");
            method.invoke(car);
            System.out.println("after");
            return null;
        });
        proxy.run();

    }

}
