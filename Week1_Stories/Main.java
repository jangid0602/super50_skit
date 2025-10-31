/**
 * @Filename - Main.java
 * @Description - Menu-driven program to test all Stories (Q1–Q7).
 * @Author - Rishu Sharma
 * @Date - 31-October-2025
 * @Subject - Week 1 Stories
 */


import java.text.DecimalFormat;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--------- MENU ---------");
            System.out.println("1. Efficient Traveler");
            System.out.println("2. Equilibrium Index");
            System.out.println("3. Flip the Switch");
            System.out.println("4. Odd One Out");
            System.out.println("5. Smart Pair Finder");
            System.out.println("6. Minimalist Painter");
            System.out.println("7. Geometry Hierarchy");
            System.out.println("8. Exit");
            System.out.print("Enter your choice (1 to 8): ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("\nQ1: Efficient Traveler");
                    System.out.print("Enter number of cities: ");
                    int n = sc.nextInt();
                    int[] costs = new int[n];
                    System.out.print("Enter energy costs between cities: ");
                    for (int i = 0; i < n; i++) costs[i] = sc.nextInt();
                    System.out.print("Enter initial energy: ");
                    int energy = sc.nextInt();
                    int farthest = Functions_Q1to6.farthestCity(costs, energy);
                    System.out.println("Farthest city reachable: " + farthest);
                }

                case 2 -> {
                    System.out.println("\nQ2: Equilibrium Index");
                    System.out.print("Enter array size: ");
                    int n = sc.nextInt();
                    int[] arr = new int[n];
                    System.out.print("Enter elements: ");
                    for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
                    int index = Functions_Q1to6.equilibriumIndex(arr);
                    System.out.println("Equilibrium Index: " + index);
                }

                case 3 -> {
                    System.out.println("\nQ3: Flip the Switch");
                    System.out.print("Enter array size: ");
                    int n = sc.nextInt();
                    int[] bits = new int[n];
                    System.out.print("Enter 0s and 1s: ");
                    for (int i = 0; i < n; i++) bits[i] = sc.nextInt();
                    int flips = Functions_Q1to6.minFlipsToEqual(bits);
                    System.out.println("Minimum flips required: " + flips);
                }

                case 4 -> {
                    System.out.println("\nQ4: Odd One Out");
                    System.out.print("Enter array size: ");
                    int n = sc.nextInt();
                    int[] nums = new int[n];
                    System.out.print("Enter numbers: ");
                    for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
                    int single = Functions_Q1to6.singleNumber(nums);
                    System.out.println("Unique element: " + single);
                }

                case 5 -> {
                    System.out.println("\nQ5: Smart Pair Finder");
                    System.out.print("Enter array size: ");
                    int n = sc.nextInt();
                    int[] nums = new int[n];
                    System.out.print("Enter numbers: ");
                    for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
                    System.out.print("Enter target sum: ");
                    int k = sc.nextInt();
                    boolean hasPair = Functions_Q1to6.hasPairWithSum(nums, k);
                    System.out.println("Pair with sum " + k + " exists: " + hasPair);
                }

                case 6 -> {
                    System.out.println("\nQ6: Minimalist Painter");
                    System.out.print("Enter number of walls: ");
                    int n = sc.nextInt();
                    int[] time = new int[n];
                    System.out.print("Enter painting times: ");
                    for (int i = 0; i < n; i++) time[i] = sc.nextInt();
                    int result = Functions_Q1to6.minimalPaintTime(time);
                    System.out.println("Minimal total paint time: " + result);
                }

                case 7 -> {
                    System.out.println("\nQ7: Geometry Hierarchy");
                    DecimalFormat df1 = new DecimalFormat("0.0");
                    DecimalFormat df2 = new DecimalFormat("0.00");

                    System.out.print("Enter x1 y1: ");
                    double x1 = sc.nextDouble();
                    double y1 = sc.nextDouble();
                    System.out.print("Enter x2 y2: ");
                    double x2 = sc.nextDouble();
                    double y2 = sc.nextDouble();
                    System.out.print("Enter circle radius: ");
                    double radius = sc.nextDouble();
                    System.out.print("Enter square side: ");
                    double side = sc.nextDouble();
                    System.out.print("Enter dx dy (translation for Point1): ");
                    double dx = sc.nextDouble();
                    double dy = sc.nextDouble();

                    Point p1 = new Point(x1, y1);
                    Point p2 = new Point(x2, y2);
                    Circle circle = new Circle(radius);
                    Square square = new Square(side);

                    double distance = p1.distance(p2);
                    p1.translate(dx, dy);

                    System.out.println("Distance: " + df1.format(distance));
                    System.out.println("Circle Area: " + df2.format(circle.getArea()));
                    System.out.println("Square Area: " + df1.format(square.getArea()));
                    System.out.println("Translated Point1: " + p1);
                }

                case 8 -> {
                    System.out.println("\nThank you! Exiting program...");
                    exit = true;
                }

                default -> System.out.println("Invalid choice! Please enter between 1–8.");
            }
        }

        sc.close();
    }
}
