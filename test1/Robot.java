package Java.openupvs.test1;

public class Robot {
    public
        String name;
        int battery;
        int x, y;
  
     public Robot(String name,int battery,int x,int y) {
        this.name=name;
        this.battery=battery;
        this.x=x;
        this.y=y;
    }

    public void move(int dx, int dy) {
        this.x=this.x+ dx;
        this.y=this.y+ dy;
    }

    
    public Robot clone() {
            Robot copy = new Robot(this.name,this.battery,this.x,this.y);
            copy.name = this.name +"_copy";
            return copy;
    }
    public void show()
    {
        System.out.println(this.name);
        System.out.println(this.battery,this.x,this.y);
    }

    

}
    

