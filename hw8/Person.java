import java.sql.Timestamp;
import java.util.*;

public class Person {
    String name;
    int age;
    List<String> hobbies;
    Date timestamp;

    public Person(String name, int age, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = new ArrayList<>(hobbies);
        this.timestamp = new Timestamp(new  Date().getTime());
    }

    @Override
    public String toString() {
        return name + " (Age: " + age + ", Hobbies: " + hobbies + ")" + " (Timestamp: " + timestamp + ")";
    }
}
