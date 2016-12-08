package com.ryanhuen.rxbusdownload.event;

/**
 * Created by ryanhuencompany on 16-12-8.
 */

public class ProgressUpdateEvent {
    private int progress;

    public ProgressUpdateEvent(int progress) {
        this.progress = progress;
    }

    public int getProgress() {
        return progress;
    }
}
