package singleton;

public class StaticInnerSingleton {
    private static class Singleton {
        private static StaticInnerSingleton singleton = new StaticInnerSingleton();
    }

    private StaticInnerSingleton() {
        if(Singleton.singleton != null) {
//            throw new IllegalAccessException();
        }
    }

    public static StaticInnerSingleton getInstance() {
        return Singleton.singleton;
    }
}
