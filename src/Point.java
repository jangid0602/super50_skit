/**
 * <p>Point  class is the base class for all the classes Shape,Circle,Sqaure</p>
 * <p>With member function distance,trnaslate,display</p>
 * <p>This class will initialise the x & y coordinates of both point </p>
 * <p>Find the distance ,translate,show the translation of point1</p>
 * @Author- Aaditya Jain
 */

public class Point {
    double xcordinate, ycordinate;
    public Point(double xcordinate, double ycordinate){
        this.xcordinate = xcordinate;
        this.ycordinate = ycordinate;
    }
    public double distance( Point secondPoint)
    {
        return Math.sqrt(Math.pow(secondPoint.xcordinate -this.xcordinate,2)+Math.pow(secondPoint.ycordinate -this.ycordinate,2));
    }
    public void translate(double dx,double dy)
    {
        this.xcordinate +=dx;
        this.ycordinate +=dy;
    }
    public String Display()
    {
        return String.format("(%.2f, %.2f)", xcordinate, ycordinate);
    }

}
