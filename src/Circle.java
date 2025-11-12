 /**
 * <p>Circle is the derived class of Shape class which will initialise radius and find area of the circle</p>
  * <p>Member function of this class are constructor to initialise radius and getArea to calculate area of circle</p>
  * @author -Aaditya Jain
  * */


class Circle extends Shape{
    double radius;
    public Circle(double radius)
    {
        this.radius=radius;
    }

     @Override
     public double getArea() {
         return 3.14*radius*radius;
     }
 }
