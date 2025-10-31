package geometry;

/**
 * The Square class represents a square in a 2D plane.
 * It extends the Shape class and overrides the getArea() method
 * to compute the area using the formula: side².
 */
public class Square extends Shape {

    /** Side length of the square */
    private final double side;

    /**
     * Constructs a Square object with the specified side length.
     *
     * @param side side length of the square
     */
    public Square(double side) {
        this.side = side;
    }

    /**
     * Returns the area of the square.
     *
     * @return area = side²
     */
    @Override
    public double getArea() {
        return side * side;
    }
}