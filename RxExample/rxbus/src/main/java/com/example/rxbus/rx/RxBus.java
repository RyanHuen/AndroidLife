
package com.example.rxbus.rx;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.ReplaySubject;
import rx.subjects.SerializedSubject;

/**
 * Created by xianeng on 16-8-2.
 */
public class RxBus {

    private static final String TAG = RxBus.class.getSimpleName();

    private SerializedSubject<Object, Object> rxBus;
    private SerializedSubject<Object, Object> rxStickBus;

    @SuppressWarnings("unchecked")
    private RxBus() {
        rxBus = new SerializedSubject(PublishSubject.create());
        rxStickBus = new SerializedSubject<>(ReplaySubject.create());
    }

    private static RxBus mDefaultInstance;

    public static RxBus getInstance() {
        if (mDefaultInstance == null) {
            synchronized (RxBus.class) {
                if (mDefaultInstance == null) {
                    mDefaultInstance = new RxBus();
                }
            }
        }
        return mDefaultInstance;
    }

    public void postEvent(Object event) {
        synchronized (RxBus.class) {
            if (this.hasObservers()) {
                rxBus.onNext(event);
            }
        }
    }

    public void postStickEvent(Object event) {
        synchronized (RxBus.class) {
            rxStickBus.onNext(event);
        }
    }

    public <T> Observable<T> toObservable(Class<T> type) {
        return rxBus.asObservable().ofType(type).onBackpressureBuffer();
    }

    public <T> Observable<T> toStickObservable(final Class<T> type) {
        synchronized (RxBus.class) {
            return rxStickBus.asObservable().ofType(type).onBackpressureBuffer();
        }
    }

    private boolean hasObservers() {
        return rxBus.hasObservers();
    }

    public void destroy() {
        mDefaultInstance = null;
    }
}
