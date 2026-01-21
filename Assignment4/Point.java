public class Point {
    private int x_coordinate, y_coordinate;

    public Point() {
        this.x_coordinate = 0;
        this.y_coordinate = 0;
    }

    public Point(int x_coordinate, int y_coordinate) {
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }

    double getDistance(Point finalPoint) {
        double distance = 0;

        int dx = this.x_coordinate - finalPoint.x_coordinate;
        int dy = this.y_coordinate - finalPoint.y_coordinate;
        distance = Math.sqrt(dx * dx + dy * dy);

        return distance;
    }

    public String translate(int dx, int dy) {
        x_coordinate += dx;
        y_coordinate += dy;
        return "(" + x_coordinate + ", " + y_coordinate + ")";
    }

    public String getCoordinates() {
        return "(" + x_coordinate + ", " + y_coordinate + ")";
    }
}
