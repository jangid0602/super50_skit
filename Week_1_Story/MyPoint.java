/**
 * @Filename - MyPoint.java
 * @Description - This will perform following operations related to 2D Point and Shapes:
 *                 1. Create a 2D Point with x and y coordinates.
 *                 2. Calculate distance between two points.
 *                 3. Translate the point by given dx and dy.
 *                 4. Create Shape abstract class and derived classes Circle and Square with area calculation.
 *
 * @Author - Anish Saini 
 */

class MyPoint {
    private double x;
    private double y;

    MyPoint() {
        this.x = 0;
        this.y = 0;
    }

    MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    
    public double getX() { return x; }
    public double getY() { return y; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

   
    public double distance(MyPoint other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

// Abstract Class
abstract class Shape {
    abstract double getArea();
}

// Derived Classes
class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }
}

class Square extends Shape {
    private double side;

    Square(double side) {
        this.side = side;
    }

    public double getSide() { return side; }
    public void setSide(double side) { this.side = side; }

    @Override
    double getArea() {
        return side * side;
    }
}