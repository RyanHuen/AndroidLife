package base;

/**
 * Created by ryanhuenwork on 16-10-3.
 */
public class CallMain {
    public static void main(String[] args) {
        Person person = new Person(new Dog());
        person.hitDog();
    }
}
