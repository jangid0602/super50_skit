/**
 * @filename GeometryHierarchy.java
 * The program models geometric objects including Point, Circle, and Square. 
 * It computes distances between points, calculates areas of shapes, and performs 
 * coordinate translations. The program uses Math.sqrt() only, avoiding other inbuilt 
 * mathematical functions, as per the assignment constraints.
 * @author Mayank Rathore
 * @class GeometryHierarchy
 * @description The GeometryHierarchy class acts as the main driver to test 
 *              the functionality of the Point, Shape, Circle, and Square classes,
 *              showcasing practical implementation of OOP principles such as 
 *              inheritance, method overriding, encapsulation, and function overloading.
 */

package Java.openupvs.Assignment4;

import java.util.InputMismatchException;
import java.util.Scanner;

// Base Class: Point
class Point {
    private double x;
    private double y; // Encapsulation

    // Default Constructor
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    // Parameterized Constructor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Method to calculate distance between two points
    public double distance(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        double d = Math.sqrt(dx * dx + dy * dy);
        return (int)(d * 100 + 0.5) / 100.0; // round to 2 decimal places
    }

    // Method to translate (move) the point
    public void translate(double dx, double dy) {
        this.x = this.x + dx;
        this.y = this.y + dy;
    }

    // String representation of the point
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}

// Derived Class: Shape extends Point
abstract class Shape extends Point {
    public abstract double getArea();
}

// Derived Class: Circle extends Shape
class Circle extends Shape {
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Override getArea method
    public double getArea() {
        double pi = 3.1416;
        double area = pi * this.radius * this.radius;
        return (int)(area * 100 + 0.5) / 100.0;
    }
}

// Derived Class: Square extends Shape
class Square extends Shape {
    private double side;

    // Constructor
    public Square(double side) {
        this.side = side;
    }

    // Override getArea method
    public double getArea() {
        double area = this.side * this.side;
        return (int)(area * 100 + 0.5) / 100.0;
    }
}

// Main Driver Class
public class GeometryHierarchy {
    public static void main(String[] args) {
        Scanner scannerObject = new Scanner(System.in);

        try {
            System.out.println("Enter coordinates of first point (x1 y1): ");
            double x1 = scannerObject.nextDouble();
            double y1 = scannerObject.nextDouble();

            System.out.println("Enter coordinates of second point (x2 y2): ");
            double x2 = scannerObject.nextDouble();
            double y2 = scannerObject.nextDouble();

            System.out.println("Enter radius of the circle: ");
            double radius = scannerObject.nextDouble();

            System.out.println("Enter side of the square: ");
            double side = scannerObject.nextDouble();

            System.out.println("Enter values to translate point1 (dx dy): ");
            double dx = scannerObject.nextDouble();
            double dy = scannerObject.nextDouble();

            // Object creation
            Point p1 = new Point(x1, y1);
            Point p2 = new Point(x2, y2);
            Circle c = new Circle(radius);
            Square s = new Square(side);

            // Output results
            System.out.println("Distance: " + p1.distance(p2));
            System.out.println("Circle Area: " + c.getArea());
            System.out.println("Square Area: " + s.getArea());
            p1.translate(dx, dy);
            System.out.println("Translated Point1: " + p1);

            scannerObject.close();
        } 
        catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter numeric values only.");
        }
    }
}
