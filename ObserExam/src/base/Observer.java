package base;

/**
 * Created by ryanhuenwork on 16-10-3.
 */
public abstract class Observer {

    /**
     * 定义一个抽象方法，用于被观察者状态发生变化时执行自身的响应
     */
    public abstract void update(int progress);

    protected Subject mSubject;
}
