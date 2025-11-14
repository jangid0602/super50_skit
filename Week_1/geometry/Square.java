package Oneup.Assignment4.geometry;

class Square extends Shape {    //derived class for square 
    int side;
    public Square(int side){           //constructer
        this.side=side;
    }
    @Override
    double getarea() {
        
        return side*side;            //area of circle side*side
    }
    
}

