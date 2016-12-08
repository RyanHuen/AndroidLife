package com.ryanhuen.rxbusdownload.rx;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * 管理 CompositeSubscription
 * <p>
 * Created by YoKeyword on 16/7/19.
 */
public class RxSubscriptions {
    private static CompositeSubscription mSubscriptions = new CompositeSubscription();

    public static boolean isUnsubscribed() {
        return mSubscriptions.isUnsubscribed();
    }

    public static void add(Subscription s) {
        if (s != null) {
            mSubscriptions.add(s);
        }
    }

    public static void remove(Subscription s) {
        if (s != null) {
            mSubscriptions.remove(s);
        }
    }

    public static void clear() {
        mSubscriptions.clear();
    }

    public static void unsubscribe() {
        mSubscriptions.unsubscribe();
    }

    public static boolean hasSubscriptions() {
        return mSubscriptions.hasSubscriptions();
    }
}
