public class Square extends Shape{
    double side;

    Square(){
        side = 0.0;
    }

    Square(double side){
        this.side = side;
    }

    public double getSide(){
        return side;
    }
    @Override
    public double getArea(){
        return side * side;
    }
}
