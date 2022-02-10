package adaptor;

public class TwoPlug2ThreePlugAdaptor implements ThreePlugI{
    GBTwoPlug twoPlug;

    public TwoPlug2ThreePlugAdaptor(GBTwoPlug twoPlug) {
        this.twoPlug = twoPlug;
    }

    @Override
    public void powerWithThree() {
        System.out.println("三相转二相成功");
        twoPlug.powerWithTwo();
    }
}
