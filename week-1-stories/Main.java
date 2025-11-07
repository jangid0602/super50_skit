/*
 * @filename =  point  Class 
 * @description - calculating max cities to trael without becoming energy negative 
 * @author - Tanu Shree Jangid 
 */

import java.util.*;
import java.io.*;
import static java.lang.Math.*;

class Point {
    double x;
    double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double distance(Point other) {
        return Math.sqrt( Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2) );
    }

    void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}

abstract class Shape {
    abstract double getArea();
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double getArea() {
        return Math.PI * radius * radius;
    }
}

class Square extends Shape {
    double side;

    Square(double side) {
        this.side = side;
    }

    double getArea() {
        return side * side;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);

        System.out.println("Distance: " + p1.distance(p2));

        double radius = sc.nextDouble();
        Circle c = new Circle(radius);
        System.out.printf("Circle Area: %.2f\n", c.getArea());

        double side = sc.nextDouble();
        Square s = new Square(side);
        System.out.println("Square Area: " + s.getArea());

        double dx = sc.nextDouble();
        double dy = sc.nextDouble();
        p1.translate(dx, dy);
        System.out.println("Translated Point1: " + p1);
    }
}
