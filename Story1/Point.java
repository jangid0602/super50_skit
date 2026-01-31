/**
 * Represents a point in 2D Cartesian coordinates.
 */
public class Point {
    double x; 
    double y; 
    Point() {
        x = 0.0;
        y = 0.0;
    }
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculates the Euclidean distance to another point, rounded down to integer.
     * @param otherPoint The other point to calculate distance to
     * @return Integer Euclidean distance between this point and the other point
     */
    public int getDistance(Point otherPoint) {
        double xDistanceSquared = (this.x - otherPoint.x) * (this.x - otherPoint.x);
        double yDistanceSquared = (this.y - otherPoint.y) * (this.y - otherPoint.y);
        double sumOfSquares = xDistanceSquared + yDistanceSquared;
        int roundedDistance = (int)(Math.sqrt(sumOfSquares));
        return roundedDistance;
    }

    /**
     * Translates (moves) the point by dx and dy.
     * @param dx The change in x-coordinate
     * @param dy The change in y-coordinate
     * @return The translated point
     */
    public Point translatePoint(int dx, int dy) {
        this.x += dx;
        this.y += dy;
        return this;
    }

    /**
     * Constructs a string representation of the point.
     * @return String of the form "(x, y)"
     */
    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
