public class RobotClone {
  public String name;
  public int battery ;
  public double x,y;
  public RobotClone(String name,int battery,double x,double y){
    this.name=name;
    this.battery=battery;
    this.x=x;
    this.y=y;
  }
  public void move(double dx,double dy){
    x+=dx;
    y+=dy;
  }

}
public class  Clone extends RobotClone {
   String name;
   int battery;
   public double x,y;
   public RobotClone(name,battery,x,y){
     this.name=name
   }
  
}
