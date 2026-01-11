import java.util.*;

/**
 * @filename - DigitalAncestry.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

class Person {
    String name;
    int wealth;
    List<Person> children;

    Person(String name, int wealth) {
        this.name = name;
        this.wealth = wealth;
        this.children = new ArrayList<>();
    }
}

public class DigitalAncestry {

    static Person buildTree(Scanner sc) {
        System.out.print("Enter person name: ");
        String name = sc.next();

        System.out.print("Enter wealth of " + name + ": ");
        int wealth = sc.nextInt();

        Person person = new Person(name, wealth);

        System.out.print("How many children does " + name + " have? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEntering child of " + name);
            person.children.add(buildTree(sc));
        }

        return person;
    }

    // calculate total legacy
    static int calculateLegacy(Person person) {
        int total = person.wealth;

        for (Person child : person.children) {
            total += calculateLegacy(child);
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter family tree:\n");
        Person root = buildTree(sc);

        int totalLegacy = calculateLegacy(root);
        System.out.println("\nTotal Legacy = " + totalLegacy);

        sc.close();
    }
}
