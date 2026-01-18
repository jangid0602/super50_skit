import java.util.List;
import java.util.ArrayList;

/**
 * @Filename- DigitalAncestry.java
 * @Description- In this a person class which consist of wealth and number of childers and we calculate the familys
 * @Author- Arman Agrawal
 */




class Person {
    private int wealth;
    private List<Person> children;

    Person(int wealth, List<Person> children) {
        this.wealth = wealth;
        this.children = children;
    }

    int getWealth() {
        return wealth;
    }

    List<Person> getChildren() {
        return children;
    }

    boolean hasChildren() {
        return children != null && !children.isEmpty();
    }
}



public class DigitalAncestry {

    public static Person buildFamilyTree(InputUtils input) {

        int wealth = input.readInt("Enter person's wealth: ");
        int childCount = input.readInt("Enter number of children: ");

        List<Person> children = new ArrayList<>();

        for (int i = 1; i <= childCount; i++) {
            System.out.println("\nEntering details for child " + i);
            children.add(buildFamilyTree(input));
        }

        return new Person(wealth, children);
    }

    public static int calculateLegacy(Person person) {

        if (person == null) {
            return 0;
        }

        int totalLegacy = person.getWealth();

        if (person.hasChildren()) {
            for (Person child : person.getChildren()) {
                totalLegacy += calculateLegacy(child);
            }
        }

        return totalLegacy;
    }
}
