package adaptor;

public class NoteBook {
    ThreePlugI threePlug;

    public NoteBook(ThreePlugI threePlug) {
        this.threePlug = threePlug;
    }

    public void charge(){
        threePlug.powerWithThree();
    }

    public static void main(String[] args) {
        GBTwoPlug twoPlug = new GBTwoPlug();
        ThreePlugI threePlug = new TwoPlug2ThreePlugAdaptor(twoPlug);
        NoteBook noteBook = new NoteBook(threePlug);
        noteBook.charge();
    }
}
