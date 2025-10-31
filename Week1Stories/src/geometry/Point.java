package geometry;

/**
 * The Point class represents a point in a 2D coordinate plane.
 * It supports basic geometric operations such as calculating
 * Euclidean distance and translating coordinates.
 *
 * <p>This class demonstrates encapsulation and method definition.
 * <p>
 * Example:
 * <pre>
 *     Point p1 = new Point(0, 0);
 *     Point p2 = new Point(3, 4);
 *     System.out.println(p1.distance(p2)); // Output: 5.0
 * </pre>
 *
 * Author: Nasir Ahmed
 * Version: 1.0
 */
public class Point {

    /** The x-coordinate of the point */
    private double x;

    /** The y-coordinate of the point */
    private double y;

    /**
     * Constructs a Point object with given x and y coordinates.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculates the Euclidean distance between the current point
     * and another Point object.
     *
     * @param other the other Point object
     * @return the distance between the two points
     */
    public double distance(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Translates the point by the specified offsets.
     *
     * @param dx displacement along the x-axis
     * @param dy displacement along the y-axis
     */
    public void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    /**
     * Returns a string representation of the point in the format (x, y).
     *
     * @return formatted string representation of the point
     */
    @Override
    public String toString() {
        return String.format("(%.1f, %.1f)", x, y);
    }
}
