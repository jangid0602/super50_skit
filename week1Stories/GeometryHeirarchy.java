/**
@Filename  -GeometryHeirarchy.java
@Description - Design a class hierarchy using OOP concepts to model geometric
objects and compute distances and areas.
@author - Nancy Jain
*/

import java.util.Scanner;
import java.util.InputMismatchException;

 class Point {  
    public double x ,y;                      //Base class
    public Point(double x, double y){                             //Constructor to initialize coordinates
        this.x = x;
        this.y = y;
    }

    public double distance(Point otherPoint){                 //Returns the Euclidean distance between the current point and another Point
        return Math.sqrt(Math.pow(this.x - otherPoint.x , 2)+(Math.pow(this.y - otherPoint.y ,2)));
    }
    public void translate(double dx, double dy){                //Moves the point by dx and dy
        this.x += dx;
        this.y +=dy;
    }
    public String getStr(){                              //Returns coordinates in the format (x, y)
        return "( "+ x + "," + y + " )";
    }
}

abstract class Shape extends Point {          //derived class of Point
    public Shape(double x, double y) {
        super(x, y);
    }

    public abstract double getArea();                 //Abstract method to compute the area
}

class Circle extends Shape{
    private double radius;
    public Circle(double x, double y ,double radius) {
        super(x, y);
        this.radius=radius;
    }
    public double getArea(){
        return Math.PI*radius*radius;
    }
}

class Square extends Shape{
    private double side;
    public Square(double x, double y ,double side){
        super(x,y);
        this.side=side;
    }
    public double getArea(){
        return side*side;
    }
}

public class GeometryHeirarchy {
 /**
 * @param args
 */
public static void main(String[] args) {
    boolean running = true;
    Scanner scanner = new Scanner(System.in);
    do{
    try {

        System.out.println("Enter x1 coordinate :");
        double x1 = scanner.nextDouble();
        System.out.println("Enter y1 coordinate :");
        double y1 = scanner.nextDouble();
        Point point1 = new Point(x1,y1);

        System.out.println("Enter x2 coordinate :");
        double x2 = scanner.nextDouble();
        System.out.println("Enter y2 coordinate :");
        double y2 = scanner.nextDouble();
        Point point2 = new Point(x2,y2);
        System.out.println("Distance between points (x1,y1) and (x2,y2): "+ point1.distance(point2)+" unit");

        System.out.println("Enter distance to move x coordinate by dx :");
        double dx = scanner.nextDouble();
        System.out.println("Enter distance to move y coordinate by dy :");
        double dy = scanner.nextDouble();
        point1.translate(dx,dy);
        System.out.println("Translated Point1: "+ point1.getStr());

        System.out.println("Enter radius for circle:");
        double radius = scanner.nextDouble();
        Circle circle = new Circle(x1 , y1 , radius);
        System.out.printf("Circle Area: %.2f units sq%n", circle.getArea());

        System.out.println("Enter side for square:");
        double side = scanner.nextDouble();
        Square square = new Square(x1 ,y1 ,side);
        System.out.println("Square Area: "+ square.getArea()+" units sq.");

        System.out.print("Do you want to quit? (y/n): ");
        char confirmQuit;
        while(true){
            String input = scanner.next().trim().toLowerCase();
            if(input.equals("y") || input.equals("n")){
                confirmQuit = input.charAt(0);
                break;
            }else{
                System.out.println("Invalid input! Please enter y or n:");
            }
        }
            if (confirmQuit == 'y') {
                running = false;
                System.out.println("Exiting...");
        }
    } catch(final InputMismatchException e){
        System.out.println("Invalid input entered. Please try again");
        scanner.nextLine();
    }
  }while (running); 
 }
}
