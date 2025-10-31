package geometry;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Main class serves as the entry point for the geometry package.
 * It allows users to perform coordinate geometry operations such as:
 * 1. Calculating distance between two points
 * 2. Translating a point
 * 3. Calculating area of a Circle
 * 4. Calculating area of a Square
 * 5. Exit the program
 *
 * The program ensures robust input validation — supports floating-point values
 * for coordinates and dimensions, and handles invalid user entries gracefully.
 *
 * Author: Nasir Ahmed
 * Date: 29 October 2025
 */
public class Main {

    /**
     * Entry point of the program.
     * Displays a menu-driven interface for performing geometric operations.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== GEOMETRY MENU ===");
            System.out.println("1. Compute Distance Between Two Points");
            System.out.println("2. Translate a Point");
            System.out.println("3. Compute Area of a Circle");
            System.out.println("4. Compute Area of a Square");
            System.out.println("5. Exit");

            int choice = getValidChoice(sc, 1, 5);

            switch (choice) {
                case 1 -> handleDistance(sc);
                case 2 -> handleTranslate(sc);
                case 3 -> handleCircleArea(sc);
                case 4 -> handleSquareArea(sc);
                case 5 -> {
                    System.out.println("Exiting geometry program...");
                    sc.close();
                    return;
                }
            }
        }
    }

    /**
     * Prompts the user for a valid menu choice within [min, max].
     *
     * @param sc   Scanner instance
     * @param min  Minimum valid option
     * @param max  Maximum valid option
     * @return     User's validated choice
     */
    private static int getValidChoice(Scanner sc, int min, int max) {
        while (true) {
            try {
                System.out.print("Enter your choice (" + min + "-" + max + "): ");
                int choice = sc.nextInt();
                if (choice >= min && choice <= max)
                    return choice;
                System.out.println("Invalid choice! Please select a number between " + min + " and " + max + ".");
            } catch (InputMismatchException e) {
                System.out.println("Illegal entry! Please enter an integer value.");
                sc.nextLine(); // Clear invalid input
            }
        }
    }

    /**
     * Prompts for a valid floating-point value.
     *
     * @param sc       Scanner instance
     * @param message  Prompt message
     * @return         Valid double value entered by the user
     */
    private static double getValidDouble(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a numeric value.");
                sc.nextLine();
            }
        }
    }

    /**
     * Handles distance computation between two points.
     */
    private static void handleDistance(Scanner sc) {
        System.out.println("\n--- Compute Distance Between Two Points ---");
        double x1 = getValidDouble(sc, "Enter x1: ");
        double y1 = getValidDouble(sc, "Enter y1: ");
        double x2 = getValidDouble(sc, "Enter x2: ");
        double y2 = getValidDouble(sc, "Enter y2: ");

        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        double distance = p1.distance(p2);

        System.out.printf("Distance: %.2f\n", distance);
    }

    /**
     * Handles point translation operation.
     */
    private static void handleTranslate(Scanner sc) {
        System.out.println("\n--- Translate a Point ---");
        double x = getValidDouble(sc, "Enter x: ");
        double y = getValidDouble(sc, "Enter y: ");
        double dx = getValidDouble(sc, "Enter dx (shift in x): ");
        double dy = getValidDouble(sc, "Enter dy (shift in y): ");

        Point p = new Point(x, y);
        p.translate(dx, dy);
        System.out.println("Translated Point: " + p);
    }

    /**
     * Handles area computation for a circle.
     */
    private static void handleCircleArea(Scanner sc) {
        System.out.println("\n--- Compute Circle Area ---");
        double radius;
        while (true) {
            radius = getValidDouble(sc, "Enter radius: ");
            if (radius > 0) break;
            System.out.println("Radius must be positive!");
        }

        Shape circle = new Circle(radius);
        System.out.printf("Circle Area: %.2f\n", circle.getArea());
    }

    /**
     * Handles area computation for a square.
     */
    private static void handleSquareArea(Scanner sc) {
        System.out.println("\n--- Compute Square Area ---");
        double side;
        while (true) {
            side = getValidDouble(sc, "Enter side length: ");
            if (side > 0) break;
            System.out.println("Side length must be positive!");
        }

        Shape square = new Square(side);
        System.out.printf("Square Area: %.2f\n", square.getArea());
    }
}
