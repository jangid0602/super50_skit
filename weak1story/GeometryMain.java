package story1;

import java.util.Scanner;
import java.text.DecimalFormat;

public class GeometryMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.00");

        System.out.println("Enter coordinates of Point 1 (x1 y1): ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        System.out.println("Enter coordinates of Point 2 (x2 y2): ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        System.out.println("Enter radius of the Circle: ");
        double radius = sc.nextDouble();

        System.out.println("Enter side length of the Square: ");
        double side = sc.nextDouble();

        System.out.println("Enter translation values (dx dy): ");
        double dx = sc.nextDouble();
        double dy = sc.nextDouble();

        // Create Points
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);

        // Compute Distance
        double dist = p1.distance(p2);
        System.out.println("\nDistance between points: " + df.format(dist));

        // Create Circle and Square
        Circle c = new Circle(radius);
        Square s = new Square(side);

        System.out.println("Circle Area: " + df.format(c.get_area()));
        System.out.println("Square Area: " + df.format(s.get_area()));

        // Translate point1
        p1.translate(dx, dy);
        System.out.println("Translated Point1: " + p1);
    }
}
