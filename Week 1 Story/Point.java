public class Point {
    private float x;
    private float y;

    // Constructor to initialize coordinates
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    //distance between two points
    public double distance(Point other) {
        double dx = other.x - this.x;
        double dy = other.y - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // translation Of point
    public void translate(float dx, float dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}


abstract class Shape extends Point {

    // Abstract method
    public abstract double getArea();
}

// Circle class extends Shape
class Circle extends Shape {
    private float radius;

    // Constructor
    public Circle(float radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// Square class extends Shape
class Square extends Shape {
    private int side;

    // Constructor
    public Square(int side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }
}
