package main;

/**
 * Created by ryanhuenwork on 16-10-3.
 */
public class Person {
    CallBack mCallBack;

    public void setCallBack(CallBack callBack) {
        mCallBack = callBack;
    }

    public void hitDog() {
        mCallBack.callBack(this);
    }

    public void shout() {
        System.out.println("人被狗咬了，好疼啊");
    }
}
