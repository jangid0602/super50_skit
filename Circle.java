public class Circle extends Shape {
    double radius;
    Circle(){
        radius = 0.0;
    }
    Circle(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    @Override
    public double getArea(){
        return 3.14 * radius * radius;
    }
}
