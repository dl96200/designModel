package factory;
public class SimpleFactory {
    public static Shape getShape(String type){
        if("RECTANGLE".equals(type))
            return new Rectangle();
        else if ("SQUARE".equals(type))
            return new Square();
        else
            return null;
    }
}
