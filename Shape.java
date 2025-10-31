abstract class Shape {
    // Abstract method — must be implemented by all subclasses
    public abstract double getArea();
}

// Circle class that extends Shape
class Circle extends Shape {
    
    private double radius;

    
    public Circle(double radius) {
        this.radius = radius;
    }

    
    @Override
    public double getArea() {
       
        return Math.PI * radius * radius;
    }

    
    public double getRadius() {
        return radius;
    }

    
    @Override
    public String toString() {
        return "Circle => Radius: " + radius + ", Area: " + String.format("%.2f", getArea());
    }
}

// Square class that extends Shape
class Square extends Shape {
    // Private data member for side length
    private double side;

    // Constructor to initialize side
    public Square(double side) {
        this.side = side;
    }

    // Method to calculate and return area of the square
    @Override
    public double getArea() {
        // Formula for area of square = side * side
        return side * side;
    }

    // Getter method for side
    public double getSide() {
        return side;
    }

    // Overriding toString() method to print square details
    @Override
    public String toString() {
        return "Square => Side: " + side + ", Area: " + String.format("%.2f", getArea());
    }
}
