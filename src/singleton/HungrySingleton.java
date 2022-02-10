package singleton;

public class HungrySingleton {
    /**
     * 类加载 加载，连接（验证：结构，准备：初始化默认值，解析：符号引用解析为直接引用），初始化（初始化类变量）
     */
    private static HungrySingleton singleton;

    static {
        try {
            singleton = new HungrySingleton();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private HungrySingleton() throws IllegalAccessException {
        if(singleton != null) {
            throw new IllegalAccessException("已存在实例");
        }
    }

    public static HungrySingleton getInstance() {
        return singleton;
    }

    public static void main(String[] args) {
        new Thread(() -> {
            HungrySingleton instance = HungrySingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + instance.toString());
        }).start();
        new Thread(() -> {
            HungrySingleton instance2 = HungrySingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + instance2.toString());
        }).start();
    }
}
