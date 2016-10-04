package base;

/**
 * Created by ryanhuenwork on 16-10-3.
 */
public class Person implements CallBack {
    Dog mDog;

    public Person(Dog dog) {
        mDog = dog;
        mDog.setCallBack(this);
    }

    public void hitDog(){
        System.out.println("人不高兴，揍了狗");
        mDog.bitePerson();
    }

    @Override
    public void callBack() {
        System.out.println("人被狗咬了  好疼啊");
    }
}
