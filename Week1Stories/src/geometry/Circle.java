package geometry;

/**
 * The Circle class represents a circle in a 2D plane.
 * It extends the Shape class and overrides the getArea() method
 * to compute the area using the formula: π * r².
 */
public class Circle extends Shape {

    /** Radius of the circle */
    private final double radius;

    /**
     * Constructs a Circle object with the specified radius.
     *
     * @param radius radius of the circle
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Returns the area of the circle.
     *
     * @return area = π * radius²
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}