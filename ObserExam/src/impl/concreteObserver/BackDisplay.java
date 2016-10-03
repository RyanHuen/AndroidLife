package impl.concreteObserver;

import base.Observer;

/**
 * Created by ryanhuenwork on 16-10-3.
 */
public class BackDisplay extends Observer {

    @Override
    public void update(int progress) {
        System.out.println("我是被遮挡的页面，进度条在走……" + progress);
    }
}
