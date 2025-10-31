import java.util.*;

class Point {
    float x, y;

    Point() {
        x = 0;
        y = 0;
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float mySqrt(float x) {
        if (x == 0 || x == 1)
            return x;

        float l = 0, r = x, mid;
        float eps = 0.0001f; // precision

        while ((r - l) > eps) {
            mid = (l + r) / 2;
            if (mid * mid > x)
                r = mid;
            else
                l = mid;
        }
        return l;
    }

    public float findDistance(Point other) {
        float dx = other.x - this.x;
        float dy = other.y - this.y;
        return mySqrt(dx * dx + dy * dy);
    }

    public void translate(float dx, float dy) {
        x += dx;
        y += dy;
    }

    public String getCoordinates() {
        return "(" + x + "," + y + ")";
    }
}

public class Geometry {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter coordinates for 2 points:");
        float x1 = sc.nextFloat();
        float y1 = sc.nextFloat();
        float x2 = sc.nextFloat();
        float y2 = sc.nextFloat();
        System.out.println("enter radius:");
        double r = sc.nextDouble();
        System.out.println("enter side of a square:");

        double s = sc.nextDouble();
        System.out.println("enter distances by which the point has to be translated:");
        float dx = sc.nextFloat();
        float dy = sc.nextFloat();

        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        Circle c = new Circle(r);
        Square sq = new Square(s);

        System.out.println("Distance: " + p1.findDistance(p2));
        System.out.println("Circle Area: " + c.getArea());
        System.out.println("Square Area: " + sq.getArea());

        p1.translate(dx, dy);
        System.out.println("Translated Point1: " + p1);

    }
}

abstract class Shape {
    abstract double getArea();

}

class Circle extends Shape {
    double radius;

    Circle() {
        radius = 0;
    }

    Circle(double radius) {
        this.radius = radius;
    }

    double getArea() {
        double pi = 3.14;
        double area = pi * radius * radius;
        return area;
    }
}

class Square extends Shape {
    double side;

    Square() {
        side = 0;
    }

    Square(double side) {
        this.side = side;
    }

    double getArea() {
        double area = side * side;
        return area;
    }
}
