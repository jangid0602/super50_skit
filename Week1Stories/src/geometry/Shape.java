package geometry;

/**
 * <p>This Shape class acts as the abstract base class for all shapes
 * and provides a standard contract for computing areas.
 * <p>
 * Author: Nasir Ahmed
 * Version: 1.0
 */
public abstract class Shape {

    /**
     * Computes and returns the area of the shape.
     * Subclasses must provide their own implementation.
     *
     * @return area of the shape
     */
    public abstract double getArea();
}
