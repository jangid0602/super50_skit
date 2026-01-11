import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a person in a family tree with wealth and children
 *
 * @author Bhavya Jain
 * @date 7 Jan 2025
 */
public class Person {
    private final int wealth;
    private final List<Person> children;

    public Person(int wealth) {
        this.wealth = wealth;
        this.children = new ArrayList<>();
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public int getWealth() {
        return wealth;
    }

    public List<Person> getChildren() {
        return children;
    }
}
