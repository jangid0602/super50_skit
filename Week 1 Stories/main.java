import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MySolution MySolutionObj = new MySolution();

        while (true) {
            System.out.println("\nChoose a Problem:");
            System.out.println("1. The Efficient Traveller");
            System.out.println("2. The Sum that Stands Out");
            System.out.println("3. Flip The Switch");
            System.out.println("4. The Odd One Out");
            System.out.println("5. Smart Pair Finder");
            System.out.println("6. The Minimalist Painter");
            System.out.println("7. The Geometry Hierarchy");
            System.out.println("8. Exit");

            int choice = getPositiveIntInput(scanner, "Enter your choice: ");

            switch (choice) {
                case 1:
                    int NoOfCities = getPositiveIntInput(scanner, "Enter number of cities: ");
                    int[] EnergyCost = new int[NoOfCities];

                    System.out.println("Enter energy costs between cities:");
                    for (int i = 0; i < NoOfCities; i++) {
                        EnergyCost[i] = getPositiveIntInput(scanner, "Cost for city " + (i + 1) + ": ");
                    }

                    int InitialEnergy = getPositiveIntInput(scanner, "Enter initial energy: ");
                    int farthestCityIndex = MySolutionObj.GetFarthestCityIndex(EnergyCost, InitialEnergy);
                    System.out.println("Farthest city index reachable: " + farthestCityIndex);
                    break;
                case 2:
                    int SizeOfArray = getPositiveIntInput(scanner, "Enter size of array: ");
                    int[] array = new int[SizeOfArray];

                    System.out.println("Enter array elements:");
                    for (int i = 0; i < SizeOfArray; i++) {
                        array[i] = getIntInput(scanner, "Element " + (i + 1) + ": ");
                    }

                    int index = MySolutionObj.findBalancedIndex(array, SizeOfArray);
                    if (index != -1) {
                        System.out.println("Index where prefix sum equals suffix sum: " + index);
                    } else {
                        System.out.println("No such index found. Returned -1.");
                    }
                    break;
                case 3:
                    int switchArraySize = getPositiveIntInput(scanner, "Enter size of switches array: ");
                    int[] switches = new int[switchArraySize];

                    System.out.println("Enter switch states (0 or 1):");
                    for (int i = 0; i < switchArraySize; i++) {
                       while (true) {
                            int val = getIntInput(scanner, "Switch " + (i + 1) + ": ");
                            if (val == 0 || val == 1) {
                                switches[i] = val;
                                break; // valid input — exit loop
                            } 
                            else {
                                System.out.println("Invalid input! Please enter 0 or 1 only.");
                            }
                       }
                    }

                    int minFlips = MySolutionObj.getMinNoFlips(switches, switchArraySize);
                    System.out.println("Minimum number of flips required: " + minFlips);
                    break;
                case 4:
                    int n = getPositiveIntInput(scanner, "Enter array size: ");
                    int[] nums = new int[n];
                    System.out.println("Enter array elements:");
                    for (int i = 0; i < n; i++) {
                        nums[i] = getIntInput(scanner, "Element " + (i + 1) + ": ");
                    }
                    int oddOne = MySolutionObj.findOddOneOut(nums);
                    System.out.println("The odd one out is: " + oddOne);
                    break;

                case 5:
                    int size = getPositiveIntInput(scanner, "Enter size of array: ");
                    int[] arr = new int[size];
                    System.out.println("Enter array elements:");
                    for (int i = 0; i < size; i++) {
                        arr[i] = getIntInput(scanner, "Element " + (i + 1) + ": ");
                    }
                    int target = getIntInput(scanner, "Enter target sum (k): ");
                    boolean hasPair = MySolutionObj.hasPairWithSum(arr, target);
                    System.out.println("Pair with target sum exists: " + hasPair);
                    break;

                case 6:
                    int timeSize = getPositiveIntInput(scanner, "Enter number of walls: ");
                    int[] time = new int[timeSize];
                    System.out.println("Enter time taken for each wall:");
                    for (int i = 0; i < timeSize; i++) {
                        time[i] = getPositiveIntInput(scanner, "Time for wall " + (i + 1) + ": ");
                    }
                    int minTime = MySolutionObj.getMinimalistPainterTime(time);
                    System.out.println("Minimum total time after skipping one wall: " + minTime);
                    break;
                case 7: 
                     
                    System.out.print("Enter coordinates of Point1 (x1 y1): ");
                    double x1 = scanner.nextDouble();
                    double y1 = scanner.nextDouble();

                    System.out.print("Enter coordinates of Point2 (x2 y2): ");
                    double x2 = scanner.nextDouble();
                    double y2 = scanner.nextDouble();

                    GeometryHierarchy.Point p1 = new GeometryHierarchy.Point(x1, y1);
                    GeometryHierarchy.Point p2 = new GeometryHierarchy.Point(x2, y2);

                    double distance = p1.distance(p2);
                    System.out.println("Distance between points: " + distance);

                    System.out.print("Enter radius of circle: ");
                    double r = scanner.nextDouble();
                    GeometryHierarchy.Circle c = new GeometryHierarchy.Circle(r);
                    System.out.println("Circle Area: " + c.getArea());

                    System.out.print("Enter side of square: ");
                    double s = scanner.nextDouble();
                    GeometryHierarchy.Square sq = new GeometryHierarchy.Square(s);
                    System.out.println("Square Area: " + sq.getArea());
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }

    // Helper for any integer input
    private static int getIntInput(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                sc.nextLine(); // clear invalid input
            }
        }
    }

    // Helper for positive integer input only
    private static int getPositiveIntInput(Scanner sc, String prompt) {
        while (true) {
            int val = getIntInput(sc, prompt);
            if (val > 0)
                return val;
            System.out.println("Please enter a positive integer!");
        }
    }
}
