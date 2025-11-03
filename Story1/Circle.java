/**
 * Represents a circle, implementing the Shape interface.
 */
public class Circle implements Shape {
    double radius; // Radius of the circle

    Circle() {
        radius = 0.0;
    }

    Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Gets the radius of the circle.
     * @return Radius of the circle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Computes the area of the circle using π ≈ 3.14.
     * @return Area of the circle
     */
    @Override
    public double getArea() {
        return 3.14 * radius * radius;
    }
}
