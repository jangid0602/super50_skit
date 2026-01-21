package Oneup.Assignment4.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Point {                               //Base class
    private int x;
    private int y;
     public Point(){                         //default constructer
        this.x=0;                      
        this.y=0;
     }
    public Point(int x,int y){                      //parameterised constructer
        this.x=x;
        this.y=y;
    }
    public double getdistance(int x1,int y1){
          double distance = Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2));  //calculatin eucladian distance
          return distance;
    }
    public List<Integer> translate(int dx,int dy){
        x+=dx;                                         // add cordinates
        y+=dy;
        return  Arrays.asList(x, y);


    }
    public List<Integer> getcurrentcordinates(){
        return Arrays.asList(x, y);
    }
}
    
