package impl;

import impl.concreteObserver.BackDisplay;
import impl.concreteObserver.ForeDisplay;
import impl.concreteSubject.BackDownloadProgress;

/**
 * Created by ryanhuenwork on 16-10-3.
 */
public class ObserMain {
    public static void main(String[] args) {
        BackDownloadProgress backDownloadProgress = new BackDownloadProgress();
        backDownloadProgress.attach(new ForeDisplay());
        backDownloadProgress.attach(new BackDisplay());

        backDownloadProgress.startDownload();


    }
}
