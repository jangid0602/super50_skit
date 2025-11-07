import java.util.*;
import static java.lang.Math.*;

/**
 * @Filename-GeometryHierarchy.java
 * @Description-This will demonstrates the use of Object-Oriented Programming
 *                   (OOP) concepts
 * @Author-Aditya Virmani
 */

class Point {
    private float x, y;

    private float mySqrt(float n) {

        float low = 0, high = n, mid = 0;
        float epsilon = 0.0001f;

        if (n < 1)
            high = 1;

        while (high - low > epsilon) {
            mid = (low + high) / 2;
            float square = mid * mid;

            if (square - n >= 0 && square - n < epsilon)
                return mid;
            else if (square - n < 0 && -(square - n) < epsilon)
                return mid;
            else if (square < n)
                low = mid;
            else
                high = mid;
        }

        return mid;
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float distance(Point other) {
        float dx = this.x - other.x;
        float dy = this.y - other.y;
        return (float) mySqrt(dx * dx + dy * dy);
    }

    public void translate(float dx, float dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

}

abstract class Shape {

    public abstract float getArea();
}

class Circle extends Shape {
    private float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    public float getArea() {
        float pi = 3.1416f;
        return pi * radius * radius;
    }
}

class Square extends Shape {
    private float side;

    public Square(float side) {
        this.side = side;
    }

    public float getArea() {
        return side * side;
    }
}

public class GeometryHierarchy {
    private static float getFloatInput(Scanner input, String message) {
        while (true) {
            try {
                System.out.print(message);
                return Float.parseFloat(input.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a numeric value.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        float x1 = getFloatInput(input, "Enter x1: ");
        float y1 = getFloatInput(input, "Enter y1: ");
        float x2 = getFloatInput(input, "Enter x2: ");
        float y2 = getFloatInput(input, "Enter y2: ");

        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);

        float distance = p1.distance(p2);

        float radius = getFloatInput(input, "Enter radius of circle: ");
        float side = getFloatInput(input, "Enter side of square: ");

        Circle circle = new Circle(radius);
        Square square = new Square(side);

        float dx = getFloatInput(input, "Enter dx for translation: ");
        float dy = getFloatInput(input, "Enter dy for translation: ");

        p1.translate(dx, dy);

        System.out.println("Distance between given points: " + distance);
        System.out.println("Circle Area: " + circle.getArea());
        System.out.println("Square Area: " + square.getArea());
        System.out.println("Translated Point1: " + p1);
    }
}