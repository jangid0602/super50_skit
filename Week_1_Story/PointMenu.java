package Assignment_4;
import java.util.Scanner;

public class PointMenu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("------ Geometry Hierarchy Program ------");

        double x1 = safeDoubleInput(sc, "Enter x1: ");
        double y1 = safeDoubleInput(sc, "Enter y1: ");

        double x2 = safeDoubleInput(sc, "Enter x2: ");
        double y2 = safeDoubleInput(sc, "Enter y2: ");

        MyPoint p1 = new MyPoint(x1, y1);
        MyPoint p2 = new MyPoint(x2, y2);

        double dist = p1.distance(p2);
        System.out.printf("Distance: %.2f%n", dist);

        double r = safePositiveDoubleInput(sc, "Enter radius of circle: ");
        Circle c = new Circle(r);
        System.out.printf("Circle Area: %.2f%n", c.getArea());

        double s = safePositiveDoubleInput(sc, "Enter side of square: ");
        Square sq = new Square(s);
        System.out.printf("Square Area: %.2f%n", sq.getArea());

        double dx = safeDoubleInput(sc, "Enter translation dx: ");
        double dy = safeDoubleInput(sc, "Enter translation dy: ");
        p1.translate(dx, dy);
        System.out.println("Translated Point1: " + p1);

        sc.close();
    }

    static double safeDoubleInput(Scanner sc, String message) {
        System.out.print(message);
        while (!sc.hasNextDouble()) {
            System.out.println("Please enter a valid numeric value!");
            sc.next();
            System.out.print(message);
        }
        return sc.nextDouble();
    }

    static double safePositiveDoubleInput(Scanner sc, String message) {
        double val = safeDoubleInput(sc, message);
        while (val <= 0) {
            System.out.println("Please enter a positive number!");
            val = safeDoubleInput(sc, message);
        }
        return val;
    }
}
