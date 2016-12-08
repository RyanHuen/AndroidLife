package com.ryanhuen.rxbusdownload;

import android.os.SystemClock;

import com.ryanhuen.rxbusdownload.event.ProgressUpdateEvent;
import com.ryanhuen.rxbusdownload.rx.RxBus;

/**
 * Created by ryanhuencompany on 16-12-8.
 */

public class DownLoadingComponent extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 100; i++) {
            SystemClock.sleep(300);
            RxBus.getInstance().postEvent(new ProgressUpdateEvent(i));
        }
    }
}
