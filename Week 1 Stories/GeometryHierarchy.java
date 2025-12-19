/* 
 * @filename - GeometryHierarchy.java
 * @description - Basic OOP solution for "The Geometry Hierarchy"
 * @author - Khushi
 */

public class GeometryHierarchy {

    // Base Class: Point
    static class Point {
        private double x;
        private double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double distance(Point other) {
            double dx = this.x - other.x;
            double dy = this.y - other.y;
            return Math.sqrt(dx * dx + dy * dy);
        }

        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    // Simple Shape Class
    static class Shape {
        public double getArea() {
            return 0.0;
        }
    }

    // Circle class
    static class Circle extends Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getArea() {
            return 3.1416 * radius * radius;
        }
    }

    // Square class
    static class Square extends Shape {
        private double side;

        public Square(double side) {
            this.side = side;
        }

        public double getArea() {
            return side * side;
        }
    }
}
