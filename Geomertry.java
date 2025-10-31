import java.lang.*;
import java.util.Scanner;

class Point extends MathFunctions{
    private double xCoordinate;
    private double yCoordinate;

    Point(double xCoordinate, double yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    double distance(Point other) {
        double deltaX = this.xCoordinate - other.xCoordinate;
        double deltaY = this.yCoordinate - other.yCoordinate;
        double euclideanDistance = squareRoot(power(deltaX, 2) + power(deltaY, 2));
        return euclideanDistance;
    }

    void translate(double dx, double dy) {
        this.xCoordinate += dx;
        this.yCoordinate += dy;
    }

    @Override
    public String toString() {
        return "(" + xCoordinate + "," + yCoordinate + ")";
    }

}

abstract class Shape {

    abstract double get_area();
}

class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double get_area() {
        double area = this.radius * this.radius * Math.PI;
        return area;

    }
}

class Square extends Shape {
    private double side;

    Square(double side) {
        this.side = side;
    }

    @Override
    double get_area() {
        double area = this.side * this.side;
        return area;
    }

}

public class Geomertry {

    
    static double getValidDoubleInput(Scanner scanner, String message) {
        double value;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                break;
            } else {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next(); 
            }
        }
        return value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter coordinates for Point A:");
        double x1 = getValidDoubleInput(scanner, "x1: ");
        double y1 = getValidDoubleInput(scanner, "y1: ");

        System.out.println("Enter coordinates for Point B:");
        double x2 = getValidDoubleInput(scanner, "x2: ");
        double y2 = getValidDoubleInput(scanner, "y2: ");

        System.out.println("Enter translation values:");
        double dx = getValidDoubleInput(scanner, "dx: ");
        double dy = getValidDoubleInput(scanner, "dy: ");

        Point self = new Point(x1, y1);
        Point other = new Point(x2, y2);

        double dist = self.distance(other);
        System.out.printf("Distance: %.2f%n", dist);

        self.translate(dx, dy);
        System.out.println("Translated Point: " + self);

        double radius = getValidDoubleInput(scanner, "Enter radius of Circle: ");
        Shape circle = new Circle(radius);
        System.out.printf("Circle Area: %.2f%n", circle.get_area());

        double side = getValidDoubleInput(scanner, "Enter side of Square: ");
        Shape square = new Square(side);
        System.out.printf("Square Area: %.2f%n", square.get_area());

    }
}