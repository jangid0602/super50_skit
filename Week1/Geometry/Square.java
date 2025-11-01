package Week1.Geometry;

public class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() { return side; }

    @Override
    public double getArea() {
        return side * side;
    }
}
