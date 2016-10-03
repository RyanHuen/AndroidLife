package impl.concreteSubject;

import base.Subject;

/**
 * Created by ryanhuenwork on 16-10-3.
 */
public class BackDownloadProgress extends Subject {
    private int progress;

    /**
     * 模拟正在下载，进度正在更新
     *
     * @param progress
     */
    public void progressChange(int progress) {
        this.progress = progress;
        System.out.println("后台下载进度" + progress);
        notifyAllObservers(progress);
    }

    public void startDownload() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progressChange(i);
                }
            }
        }.start();
    }

}
