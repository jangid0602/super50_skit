public class Geometry {
  private double x;
  private double y;
  Geometry(double x,double y){
    this.x=x;
    this.y=y;
  }
  public double distance(Geometry other){
      double i=this.x-other.x;
      double j=this.y-other.y;
      return Math.sqrt(i*i+j*j);
  }
  public void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }
  public double getx(){
    return this.x;
  }
  public double gety(){ 
    return this.y;}
    

}
