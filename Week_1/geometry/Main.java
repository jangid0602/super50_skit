package Oneup.Assignment4.geometry;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Point p = new Point();  // Default point
        Circle c = null;        // Circle object (initially null)
        int choice;

        do {
            // 🔹 Print menu using ONE println statement
            System.out.println(
                "\n===== GEOMETRY MENU =====\n" +
                "1. Set Point Coordinates\n" +
                "2. Get Distance from Another Point\n" +
                "3. Translate Point\n" +
                "4. Show Current Coordinates\n" +
                "5. Get Area of Circle\n" +
                "6. Exit\n" +
                "Enter your choice: "
            );

            // 🔹 Input validation for choice
            while (!sc.hasNextInt()) {
                System.out.println(" Invalid input! Please enter a number between 1 and 6.");
                sc.next();
                System.out.print("Enter your choice again: ");
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter x coordinate: ");
                    int x = sc.nextInt();
                    System.out.print("Enter y coordinate: ");
                    int y = sc.nextInt();
                    p = new Point(x, y);
                    System.out.println("✅ Point set to (" + x + ", " + y + ")");
                }

                case 2 -> {
                    System.out.print("Enter x1 coordinate: ");
                    int x1 = sc.nextInt();
                    System.out.print("Enter y1 coordinate: ");
                    int y1 = sc.nextInt();
                    System.out.println("📏 Distance = " + p.getdistance(x1, y1));
                }

                case 3 -> {
                    System.out.print("Enter dx: ");
                    int dx = sc.nextInt();
                    System.out.print("Enter dy: ");
                    int dy = sc.nextInt();
                    List<Integer> newC = p.translate(dx, dy);
                    System.out.println(" Translated Point = " + newC);
                }

                case 4 -> {
                    System.out.println(" Current Coordinates: " + p.getcurrentcordinates());
                }

                case 5 -> {
                    
                        System.out.println(" Area of Circle = " + c.getarea());
                    
                }

                case 6 -> {
                    System.out.println(" Exiting program...");
                }

                default -> System.out.println(" Invalid choice! Try again.");
            }

        } while (choice != 6); // exit condition

        sc.close();
    }
}
