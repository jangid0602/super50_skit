/**
 * <p>This is the main class which performs all input/output & display operations.</p>
 * @Author - Aaditya Jain
 */
import java.util.Scanner;

public class Geometry {
    public static void main(String[] args) {
        Scanner scannerObj = new Scanner(System.in);

        System.out.println("=== Geometry Calculator ===");

        double x1 = inputHandler.getInput(scannerObj, "Enter x-coordinate of Point 1: ");
        double y1 = inputHandler.getInput(scannerObj, "Enter y-coordinate of Point 1: ");
        double x2 = inputHandler.getInput(scannerObj, "Enter x-coordinate of Point 2: ");
        double y2 = inputHandler.getInput(scannerObj, "Enter y-coordinate of Point 2: ");
        double radius = inputHandler.getInput(scannerObj, "Enter the radius of the circle: ");
        double side = inputHandler.getInput(scannerObj, "Enter the side length of the square: ");
        double dx = inputHandler.getInput(scannerObj, "Enter the translation in x-direction (dx): ");
        double dy = inputHandler.getInput(scannerObj, "Enter the translation in y-direction (dy): ");

        System.out.println("\n--- Calculating Results ---");

        // Create objects
        Point point1 = new Point(x1, y1);
        Point point2 = new Point(x2, y2);
        Circle circle = new Circle(radius);
        Square square = new Square(side);

        System.out.printf("Distance between points: %.2f%n", point1.distance(point2));
        System.out.printf("Circle Area: %.2f%n", circle.getArea());
        System.out.printf("Square Area: %.2f%n", square.getArea());

        point1.translate(dx, dy);
        System.out.println("Translated Point1: " + point1.Display());

        System.out.println("\n--- Program Completed Successfully ---");

        scannerObj.close();
    }
}
