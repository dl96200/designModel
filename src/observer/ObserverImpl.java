package observer;

public class ObserverImpl implements Observer{
    public String obserState;
    @Override
    public void update(Subject subject) {
        this.obserState = ((SubjectConcrete)subject).getSubjectState();
        System.out.println("收到消息："+obserState);
    }
}
