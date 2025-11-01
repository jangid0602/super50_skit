package story1;
import java.text.DecimalFormat;

// Base class: Point
class Point {
    protected double x;
    protected double y;

    // Constructor
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Distance between two points
    double distance(Point other) {
        return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2));
    }

    // Translate the point by dx, dy
    void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    // Display coordinates
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.0");
        return "(" + df.format(x) + ", " + df.format(y) + ")";
    }
}

// Abstract class: Shape
abstract class Shape {
    abstract double get_area();
}

// Derived class: Circle
class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double get_area() {
        return Math.PI * radius * radius;
    }
}

// Derived class: Square
class Square extends Shape {
    private double side;

    Square(double side) {
        this.side = side;
    }

    @Override
    double get_area() {
        return side * side;
    }
}

