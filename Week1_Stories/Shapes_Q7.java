/**
 * @Filename - Shapes_Q7.java
 * @Description - Contains classes for Question 7 (OOP-based Geometry Hierarchy).
 * @Author - Rishu Sharma
 * @Date - 31-October-2025
 * @Subject - Week 1 Stories
 */


import java.text.DecimalFormat;

// Abstract base class representing a Shape
abstract class Shape {
    public abstract double getArea();
}

// Represents a 2D point
class Point {
    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Calculates Euclidean distance between two points
    public double distance(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Moves the point by dx, dy
    public void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.0");
        return "(" + df.format(x) + ", " + df.format(y) + ")";
    }
}

// Circle class extending Shape
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// Square class extending Shape
class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {   
        return side;
    }

    @Override
    public double getArea() {
        return side * side;
    }
}

