package Oneup.Assignment4.geometry;

class Circle extends Shape{                  //circle class that extends shape
    int radius;
    public Circle(int radius){
        this.radius=radius;                 // area of circle  only depends on radius
    }
    @Override
    double getarea() {
        
        
        return 2.14*radius*radius;   //area of circle is pi*r*r
    }
}


