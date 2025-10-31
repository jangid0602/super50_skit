import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {

        System.out.println("Enter size of array:");
        int size = 0;
        while (true) {
            if (sc.hasNextInt()) {
                size = sc.nextInt();
                if (size > 0)
                    break;
                else
                    System.out.println("Size must be positive! Enter again:");
            } else {
                System.out.println("Invalid input! Enter a valid integer:");
                sc.next();
            }
        }
        ArrayproblemSolver aps = new ArrayproblemSolver(size);

        // Menu-driven operations
        while (true) {
            System.out.println("\n========= ARRAY OPERATIONS MENU =========");
            System.out.println("1. Calculate Farthest Index Reachable");
            System.out.println("2. Find Equilibrium Index");
            System.out.println("3. Find Minimum Bit Flips");
            System.out.println("4. Find Unique Element");
            System.out.println("5. Check if Pair Exists with Target Sum");
            System.out.println("6. Find Minimum Time Taken in Painting House");
            System.out.println("7. Exit");
            System.out.println("Enter choice from 1 to 7:");

            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                sc.nextLine(); // clear newline

                switch (choice) {
                    case 1:
                        System.out.println("Enter initial energy:");
                        if (sc.hasNextInt()) {
                            int energy = sc.nextInt();
                            System.out.println("Farthest index reachable: " +
                                    aps.calculateFarthestIndex(energy));
                            break;
                        } else {
                            System.out.println("wrong input!!");
                        }

                    case 2:
                        System.out.println("Equilibrium index: " +
                                aps.findEquilibriumIndex());
                        break;

                    case 3:

                        System.out.println("Minimum bit flips: " + aps.getMinimumBitFlips());
                        break;

                    case 4:
                        System.out.println("Unique element: " +
                                aps.getUniqueElement());
                        break;

                    case 5:
                        System.out.println("Enter target sum:");
                        if (sc.hasNextInt()) {
                            int target = sc.nextInt();
                            System.out.println("Pair exists: " +
                                    aps.hasPairWithTargetSum(target));
                            break;
                        } else {
                            System.out.println("wrong input!!");
                        }

                    case 6:

                        System.out.println("Minimum cost: " + aps.getMinimumTime());
                        break;

                    case 7:
                        System.out.println("Exiting program...");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } else {
                System.out.println("Invalid input! Please enter a number between 1 and 7.");
                sc.next(); // clear invalid input
            }
        }
    }
}
