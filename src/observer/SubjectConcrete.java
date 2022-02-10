package observer;

import java.util.Random;

public class SubjectConcrete extends Subject{
    //目标对象状态
    public String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
        this.notifyObservers();
    }

    public static void main(String[] args) {
        //创建订阅
        SubjectConcrete subject = new SubjectConcrete();
        subject.attach(new ObserverImpl());
        subject.setSubjectState("成功");
    }
}
