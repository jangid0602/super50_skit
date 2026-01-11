import java.util.*;

class Person {
    String name;
    int wealth;
    List<Person> children;

    Person(String name, int wealth) {
        this.name = name;
        this.wealth = wealth;
        this.children = new ArrayList<>();
    }

    void addChild(Person child) {
        children.add(child);
    }
}

public class PersonLegacyCalculator {

    static int calculateLegacy(Person person) {
        // Base sum: person's own wealth
        int total = person.wealth;

        // Add wealth of all descendants
        for (Person child : person.children) {
            total += calculateLegacy(child);
        }

        return total;
    }


}

