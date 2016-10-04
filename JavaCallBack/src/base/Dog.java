package base;

/**
 * Created by ryanhuenwork on 16-10-3.
 */
public class Dog {
    CallBack mCallBack;

    public void setCallBack(CallBack callBack) {
        mCallBack = callBack;
    }

    public void bitePerson() {
        System.out.println("狗反咬一口");
        mCallBack.callBack();
    }
}
