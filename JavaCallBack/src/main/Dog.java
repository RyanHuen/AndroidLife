package main;

/**
 * Created by ryanhuenwork on 16-10-3.
 */
public class Dog implements CallBack{

    @Override
    public void callBack(Person person) {
        System.out.println("狗被人打了，狗咬回：" + person);
    }
}
