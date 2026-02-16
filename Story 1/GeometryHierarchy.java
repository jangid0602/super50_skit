import java.util.Scanner;

/**
 * @file GeometryHierarchy.java
 * @description Demonstrates OOP principles:
 * Inheritance, Encapsulation, Method Overriding, and Function Overloading
 * for Point, Shape, Circle, and Square classes.
 * @author - Badal
 */

// 🔹 Base Class: Point
class Point {
    private double x;
    private double y;

    // Constructor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getter methods (Encapsulation)
    public double getX() { return x; }
    public double getY() { return y; }

    // Translate (method overloading example)
    public void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public void translate(Point shift) { // Overloaded version
        this.x += shift.getX();
        this.y += shift.getY();
    }

    // Distance between two points
    public double distance(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // String representation
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

// 🔹 Abstract Class: Shape
abstract class Shape {
    // Abstract method to be overridden
    public abstract double getArea();
}

// 🔹 Derived Class: Circle
class Circle extends Shape {
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Override getArea()
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// 🔹 Derived Class: Square
class Square extends Shape {
    private double side;

    // Constructor
    public Square(double side) {
        this.side = side;
    }

    // Override getArea()
    @Override
    public double getArea() {
        return side * side;
    }
}

// 🔹 Main Class
public class GeometryHierarchy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input two points
        System.out.print("Enter coordinates of Point1 (x y): ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        System.out.print("Enter coordinates of Point2 (x y): ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);

        System.out.println("Distance between points: " + String.format("%.2f", p1.distance(p2)));

        // Circle area
        System.out.print("Enter radius of circle: ");
        double r = sc.nextDouble();
        Circle c = new Circle(r);
        System.out.println("Area of Circle: " + String.format("%.2f", c.getArea()));

        // Square area
        System.out.print("Enter side of square: ");
        double s = sc.nextDouble();
        Square sq = new Square(s);
        System.out.println("Area of Square: " + String.format("%.2f", sq.getArea()));

        // Translation demo
        System.out.print("Enter translation (dx dy): ");
        double dx = sc.nextDouble();
        double dy = sc.nextDouble();
        p1.translate(dx, dy);
        System.out.println("Translated Point1: " + p1);

        sc.close();
    }
}
