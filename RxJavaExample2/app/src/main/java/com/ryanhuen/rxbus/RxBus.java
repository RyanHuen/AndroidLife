
package com.ryanhuen.rxbus;

import io.reactivex.Flowable;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;

/**
 * 基本功能的RxBus <br/>
 * 使用枚举作为单例 <br/>
 * Created by RyanHuen on 17-1-10.
 */

public enum RxBus {
    INSTANCE;
    public static final String TAG = RxBus.class.getName();
    private FlowableProcessor<Object> mRxBus;

    RxBus() {
        mRxBus = PublishProcessor.create().toSerialized();
    }

    public void postEvent(Object event) {
        synchronized (RxBus.class) {
            if (this.hasSubscribers()) {
                mRxBus.onNext(event);
            }
        }
    }

    /**
     * 不指定类型，返回Object类型的Observable对象
     *
     * @return
     */
    public Flowable<Object> toSubscriber() {
        return toSubscriber(Object.class);
    }

    /**
     * 根据传入对象类型返回对应类型的Observable对象
     *
     * @param <T> 返回类型
     * @param type 传入类型
     * @return
     */
    public <T> Flowable<T> toSubscriber(Class<T> type) {
        return mRxBus.ofType(type).onBackpressureBuffer();
    }

    private boolean hasSubscribers() {
        return mRxBus.hasSubscribers();
    }

}
