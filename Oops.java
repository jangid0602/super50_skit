
public class OOPS {
    public static class Point{
float x;
float y;
Point(){
    this.x=0;
    this.y=0;
}
 Point(float x,float y){
this.x=x;
this.y=y;
}
public double distance(Point other){
    double dx = other.x-this.x;
     double dy = other.y-this.y;
     return Math.sqrt(dx*dx+dy*dy);
}
public void translate(float dx,float dy){
this.x=this.x+dx;
this.y=this.y+dy;
}
 @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}
abstract static  class Shape extends Point{
   
   abstract double get_area();
}
public static class Circle extends Shape{
    float radius;
    Circle(float radius){
        
        this.radius=radius;
    }

        @Override
        double get_area() {
           return 3.141592*radius*radius;
    
    }

}
public static  class Square extends Shape{
    float side;
    Square(float side){
       
        this.side=side;
    }

        @Override
        double get_area() {
           return side*side;
    
    }
    
}
public static void main(String[] args) {
    Point p1 =new Point(0,0);
    Point p2 = new Point(3,4);
    System.out.println(p1.distance(p2));
    Circle c = new Circle(5);
    System.out.printf("%.2f\n",c.get_area());
    Square s = new Square(2);
    System.out.printf("%.2f\n",s.get_area());
    p1.translate(1, 2);
    System.out.println(p1);



}
}