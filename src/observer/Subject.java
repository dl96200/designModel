package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标对象，它知道观察它的观察者，并提供注册和删除观察者接口
 */
public class Subject {
    List<Observer> observers = new ArrayList<>();
    boolean attach(Observer observer){
        return observers.add(observer);
    }
    boolean detach(Observer observer){
        return observers.remove(observer);
    }
    void notifyObservers(){
        for (Observer observer:observers) {
            observer.update(this);
        }
    }

}
