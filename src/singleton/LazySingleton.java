package singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class LazySingleton {
    private volatile static LazySingleton singleton;
    private LazySingleton() throws IllegalAccessException {
        //无法仿制 反射攻击：由于反射可以在懒加载之前执行，导致提前生成了
        if(singleton != null) {
            throw new IllegalAccessException("已存在实例");
        }
    }
    public static LazySingleton getInstance(){
        if(singleton == null){
            synchronized(LazySingleton.class){
                if(singleton == null) {
                    //字节码层面
                    try {
                        singleton = new LazySingleton();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        try {
            Constructor<LazySingleton> lazySingletonClass = LazySingleton.class.getDeclaredConstructor();
            try {
                lazySingletonClass.setAccessible(true);
                LazySingleton singleton = lazySingletonClass.newInstance();
                LazySingleton instance = LazySingleton.getInstance();
                System.out.println(singleton==instance);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

//        new Thread(() ->  {
//            LazySingleton instance = LazySingleton.getInstance();
//            System.out.println(Thread.currentThread().getName()+instance.toString());
//        }).start();
//        new Thread(() ->  {
//            LazySingleton instance2 = LazySingleton.getInstance();
//            System.out.println(Thread.currentThread().getName()+instance2.toString());
//        }).start();
    }
}
