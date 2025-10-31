/*
 * @filename:basic operation on array
 * @description:this perform will perform different operation on array
 * @author:Tanuj
 */
import java.util.*;
public class Main {
  public static void main(String args[]){
    System.out.println("enter the choice in whic you want to do opeartuion\n 1.Array opertaion \n2.Axis operation\n 3.Geometry opertions ");
    Scanner scanner=new Scanner(System.in);
    int selection=scanner.nextInt();
    if(selection==1){
      ArrayList<Integer>List=new ArrayList<>();
    System.out.println("enter the size of array");
    int n=scanner.nextInt();
    for(int i=0;i<n;i++){
      List.add(scanner.nextInt());
    }
    MyArray collection = new MyArray(List);
    boolean running=true;
    while(running){
      System.out.println("1.The Efficient Traveler\n2.The Sum That Stands Out\n 3.Flip the Switch\n 4.Flip the Switch \n 5. Smart Pair Finder \n 6. The Minimalist Painter");
    System.out.println("enter your choice ");
    int choice=scanner.nextInt();
    switch (choice) {
      case 1:
        System.out.println("enter the initialEnergy");
        int initialEnergy=scanner.nextInt();
        int result=collection.totalEnergyUsed(initialEnergy);
        if(result==-1){
          System.out.println("please enter valid intialEnergy thanks ");
        }
        else System.out.println("e the farthest city index you can reach"+result);
        break;


      case 2:
      result=collection.TheSumThatStandOut();
      if(result==-1)System.out.println("there is not valid index in your give list ");
      else System.out.println("first index where the prefix sum equals the suffix sum \r\n" + result);
        break;

      case 3:
       result=collection.minimumFlip();
      if(result==-1)System.out.println("please update your array must contain 0 and 1 only");
      else System.out.println(" minimum number of flips required to make all elements equal."+result);  
      break;

      case 4:
      result=collection.findTheOddOneOut();
      if(result==-1)System.out.println("list is not valid please validate it");
      else
      System.out.println("the no which ocuur in one is "+result);
      break;

      case 5:
      System.out.println("Enter the target number which you wantb to find");
      int number=scanner.nextInt();
      boolean ans=collection.pairFinder(number);
      if(ans==true)System.out.println("there is existence of smart pair whose sum is equal to number");
      else System.out.println("there is not existence of smart pair whose sum is equal to number");
      break;
      case 6:
      System.out.println("minimum total time after skipping one wall. "+collection.TheMinimalistPainter());
      break;
      case 0:
      running = false;
          System.out.println("Exiting...");
          break;
       default:
      System.out.println("invalid option");   
    }
    
    }
    
    }
    else if(selection==2){
      System.out.println("enter the coordinate x and y");
      double x=scanner.nextDouble();
      double y=scanner.nextDouble();
      Geometry point=new Geometry(x, y);
      boolean run=true;
      while (run) {
        System.out.println("enter the operation\n0.exit\n1.Eucldiean distance between two points \n2.To shift the points \n 3.To get the final points ");
        int choice=scanner.nextInt();
        switch (choice) {
          case 1:
            System.out.println("enter the points where you want to get elucdiean distance");
            double r=scanner.nextDouble();
            double c=scanner.nextDouble();
            Geometry p2=new Geometry(r,c);
            System.out.println("Distance between two points is "+point.distance(p2));
            break;
          case 2:
             System.out.println("eneter the position to shifts enter x and y");
             double c1=scanner.nextDouble();
             double c2=scanner.nextDouble();
             point.translate(c1, c2);
             System.out.println("After translation, Point x and y are: " +point.getx()+ point.gety());
           case 0:
           run=false;
           break;  
          default:
            break;
        }
      }
      
    }
else if(selection==3){
  boolean run=true;
  while(run){
    System.out.println("enter operation\n 0.exit\n1.getareaof circle \n2.getarea of rectangle");
    int choice=scanner.nextInt();
    switch (choice) {
      case 0:
        run=false;
        break;
      case 1:
      System.out.println("enter the radius of circle ");
      int radius=scanner.nextInt();
      Circle c = new Circle(radius);
       System.out.println(c);
      
       case 2:
       System.out.println("enter the side of square");
       int side=scanner.nextInt();
       Square s = new Square(side);
        System.out.println(s);
        default:
        System.out.println("invalid choive");
        break;
    }

}
    
  }
}}
