/**
 * <p>Sqaure is the derived class of Shape class which will initialise radius and find area of the square</p>
 * <p>Member function of this class are constructor to initialise side and getArea to calculate area of Square</p>
 * @author -Aaditya Jain
 * */
public class Square extends Shape{
    double side;
    public Square(Double side)
    {
        this.side=side;
    }

    @Override
    public double getArea() {
        return side*side;
    }
}
