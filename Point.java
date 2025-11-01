public class Point {
    double x;
    double y;

    Point(){
        x = 0.0;
        y = 0.0;
    }
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getDistance(Point otherPoint){
       double xDistance = (this.x - otherPoint.x) * (this.x - otherPoint.x);
       double yDistance = (this.y - otherPoint.y) * (this.y - otherPoint.y);
       double totalOfBoth = xDistance + yDistance;
       int answerDistance = (int)(Math.sqrt(totalOfBoth));
       return answerDistance;
    }

    public Point translatePoint(int dx, int dy){
        this.x += dx;
        this.y += dy;
        return this;
    }

    @Override
    public String toString(){
        return "(" + this.x + ", " + this.y + ")";
    }

}
