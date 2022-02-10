package factory;

public class Test {
    public static void main(String[] args) {

        //简单工厂模式
        SimpleFactory simpleFactory = new SimpleFactory();
        simpleFactory.getShape("RECTANGLE").draw();
        simpleFactory.getShape("SQUARE").draw();

        //工厂模式
        ShapeFactory squareFactory = new SquareFactory();
        squareFactory.getShape().draw();
        ShapeFactory rectangleFactory = new RectangleFactory();
        rectangleFactory.getShape().draw();

        //抽象工厂模式
        AbstractFactory colorFactoryAbstract = new ColorFactoryAbstract();
        colorFactoryAbstract.getColor("RED").fill();
        colorFactoryAbstract.getColor("GREEN").fill();
        AbstractFactory shapeFactoryAbstract = new ShapeFactoryAbstract();
        shapeFactoryAbstract.getShape("RECTANGLE").draw();
        shapeFactoryAbstract.getShape("SQUARE").draw();

    }

}
