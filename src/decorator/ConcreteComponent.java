package decorator;

public class ConcreteComponent implements Component{
    @Override
    public void operate() {
        System.out.println("生产豆浆");
    }
}
