package Week1.Geometry;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
                        
        System.out.println("Enter coordinates for Point1 (x1 y1): ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        System.out.println("Enter coordinates for Point2 (x2 y2): ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        
        double dist = p1.distance(p2);
        System.out.println("Distance: " + String.format("%.1f", dist));

          
        System.out.println("Enter radius for Circle: ");
        double radius = sc.nextDouble();
        Circle c = new Circle(radius);
        // Circle area printed to 2 decimal places as in example
        System.out.println("Circle Area: " + String.format("%.2f", c.getArea()));

        System.out.println("Enter side for Square: ");
        double side = sc.nextDouble();
        Square square = new Square(side);
        System.out.println("Square Area: " + String.format("%.1f", square.getArea()));

        System.out.println("Enter translation vector (dx dy): ");
        double dx = sc.nextDouble();
        double dy = sc.nextDouble();
        p1.translate(dx, dy);
        System.out.println("Translated Point1: " + p1.toString());

        sc.close();
    }
}
