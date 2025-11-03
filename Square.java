/**
 * Represents a square, implementing the Shape interface.
 */
public class Square implements Shape {
    double side; // Side length of the square

    Square() {
        side = 0.0;
    }

    Square(double side) {
        this.side = side;
    }

    /**
     * Gets the length of one side of the square.
     * @return Side length of the square
     */
    public double getSide() {
        return side;
    }

    /**
     * Computes the area of the square.
     * @return Area of the square
     */
    @Override
    public double getArea() {
        return side * side;
    }
}
