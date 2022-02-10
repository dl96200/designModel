package singleton;

public enum EnumSingleton {
    INTANCE;
}
class EnumTest{
    public static void main(String[] args) {
        EnumSingleton singleton = EnumSingleton.INTANCE;
    }
}