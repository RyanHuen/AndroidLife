
package com.ryanhuen.rxbus;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by RyanHuen on 17-1-10.
 */

public enum RxBus {
    INSTANCE;
    public static final String TAG = RxBus.class.getName();
    private Subject<Object> rxBus;

    RxBus() {
        rxBus = PublishSubject.create().toSerialized();
    }

    public void postEvent(Object event) {
        synchronized (RxBus.class) {
            if (this.hasObservers()) {
                rxBus.onNext(event);
            }
        }
    }

    /**
     * 不指定类型，返回Object类型的Observable对象
     * 
     * @return
     */
    public Observable<Object> tObservable() {
        return tObservable(Object.class);
    }

    /**
     * 根据传入对象类型返回对应类型的Observable对象
     * 
     * @param type 传入类型
     * @param <T> 返回类型
     * @return
     */
    public <T> Observable<T> tObservable(Class<T> type) {
        return rxBus.ofType(type);
    }

    private boolean hasObservers() {
        return rxBus.hasObservers();
    }
}
