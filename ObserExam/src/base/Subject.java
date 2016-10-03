package base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryanhuenwork on 16-10-3.
 * 被观察者，继承了此类的类就是被观察者对象了。当被观察者发生了变化，就会执行notifyAllObservers()方法通知
 * mObserves集合中的所有观察者，进行状态更新
 */
public abstract class Subject {
    private List<Observer> mObservers = new ArrayList<>();

    public void attach(Observer observer) {
        mObservers.add(observer);
    }

    public void dettach(Observer observer) {
        mObservers.remove(observer);
    }

    public void notifyAllObservers(int progress) {
        for (int i = 0; i < mObservers.size(); i++) {
            Observer observer = mObservers.get(i);
            observer.update(progress);
        }
    }
}
