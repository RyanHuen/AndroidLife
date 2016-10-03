package main;

/**
 * Created by ryanhuenwork on 16-10-3.
 */
public class CallMain {
    public static void main(String[] args) {
        Person person = new Person();
        Dog dog = new Dog();
        person.setCallBack(dog);
        person.hitDog();
    }
}
