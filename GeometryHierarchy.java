import static java.lang.Math.*;
import java.util.*;

class MathUtils {

    public static final double PI = 3.141592653589793;

    public static double pow(double base, double exp) {
        if (exp == 0) return 1;
        double result = 1;
        boolean negative = exp < 0;
        exp = Math.abs(exp);
        for (int i = 0; i < (int) exp; i++) {
            result *= base;
        }
        return negative ? 1 / result : result;
    }

    public static double sqrt(double n) {
        if (n < 0) throw new IllegalArgumentException("Cannot calculate sqrt of negative number.");
        if (n == 0 || n == 1) return n;

        double guess = n;
        double epsilon = 1e-6;

        while (Math.abs(guess * guess - n) > epsilon) {
            guess = (guess + n / guess) / 2;
        }
        return guess;
    }
}

class Point extends MathUtils{
    private double x, y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double distance(Point other) {
        return sqrt(pow(x - other.x, 2) + pow(y - other.y, 2));
    }

    void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}

abstract class Shape {
    abstract double getArea();

}

class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getArea() {
        return PI * radius * radius;
    }

}

class Square extends Shape {
    private double side;

    Square(double side) {
        this.side = side;
    }

    @Override
    double getArea() {
        return side * side;
    }

}

class Triangle extends Shape {
    private double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double getArea() {
        return 0.5 * base * height;
    }

}

class InputHelper {

    public static double getDoubleInput(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                return sc.nextDouble();
            } else {
                System.out.println("Invalid input! Please enter a number.");
                sc.next();
            }
        }
    }
}

public class GeometryHierarchy extends InputHelper{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("""
                    ===== Geometry Menu =====
                    1. Distance between two points
                    2. Circle Area
                    3. Square Area
                    4. Triangle Area
                    0. Exit
                    Enter your choice: """);

            if (!sc.hasNextInt()) {
                System.out.println("Invalid choice! Enter a number 0–4.");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    double x1 = getDoubleInput(sc, "Enter x1 for Point 1: ");
                    double y1 = getDoubleInput(sc, "Enter y1 for Point 1: ");
                    double x2 = getDoubleInput(sc, "Enter x2 for Point 2: ");
                    double y2 = getDoubleInput(sc, "Enter y2 for Point 2: ");
                    Point p1 = new Point(x1, y1);
                    Point p2 = new Point(x2, y2);
                    System.out.printf("Distance: %.2f%n", p1.distance(p2));

                    double dx = getDoubleInput(sc, "Enter dx for translation: ");
                    double dy = getDoubleInput(sc, "Enter dy for translation: ");
                    p1.translate(dx, dy);
                    System.out.println("Translated Point1: " + p1);
                    break;

                case 2:
                    double r = getDoubleInput(sc, "Enter radius of Circle: ");
                    Shape c = new Circle(r);
                    System.out.printf("Circle Area: %.2f%n", c.getArea());
                    break;

                case 3:
                    double side = getDoubleInput(sc, "Enter side of Square: ");
                    Shape s = new Square(side);
                    System.out.printf("Square Area: %.2f%n", s.getArea());
                    break;

                case 4:
                    double base = getDoubleInput(sc, "Enter base of Triangle: ");
                    double height = getDoubleInput(sc, "Enter height of Triangle: ");
                    Shape t = new Triangle(base, height);
                    System.out.printf("Triangle Area: %.2f%n", t.getArea());
                    break;

                case 0:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
                    break;
            }

        } while (choice != 0);
        sc.close();

    }
}
