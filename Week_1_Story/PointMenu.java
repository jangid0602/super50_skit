/**
 * @Filename - PointMenu.java
 * @Description - Menu-driven driver code for Week 1 problems
 * @Author - Anish Saini 
 */
import java.util.Scanner;

public class PointMenu {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("------ Geometry Hierarchy Program ------");

        double x1 = safeDoubleInput(userInput, "Enter x1: ");
        double y1 = safeDoubleInput(userInput, "Enter y1: ");

        double x2 = safeDoubleInput(userInput, "Enter x2: ");
        double y2 = safeDoubleInput(userInput, "Enter y2: ");

        MyPoint p1 = new MyPoint(x1, y1);
        MyPoint p2 = new MyPoint(x2, y2);

        double dist = p1.distance(p2);
        System.out.printf("Distance: %.2f%n", dist);

        double r = safePositiveDoubleInput(userInput, "Enter radius of circle: ");
        Circle c = new Circle(r);
        System.out.printf("Circle Area: %.2f%n", c.getArea());

        double side = safePositiveDoubleInput(userInput, "Enter side of square: ");
        Square sq = new Square(side);
        System.out.printf("Square Area: %.2f%n", sq.getArea());

        double dx = safeDoubleInput(userInput, "Enter translation dx: ");
        double dy = safeDoubleInput(userInput, "Enter translation dy: ");
        p1.translate(dx, dy);
        System.out.println("Translated Point1: " + p1);

        userInput.close();
    }

    static double safeDoubleInput(Scanner userInput, String message) {
        System.out.print(message);
        while (!userInput.hasNextDouble()) {
            System.out.println("Please enter a valid numeric value!");
            userInput.next();
            System.out.print(message);
        }
        return userInput.nextDouble();
    }

    static double safePositiveDoubleInput(Scanner userInput, String message) {
        double val = safeDoubleInput(userInput, message);
        while (val <= 0) {
            System.out.println("Please enter a positive number!");
            val = safeDoubleInput(userInput, message);
        }
        return val;
    }
}