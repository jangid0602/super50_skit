import java.nio.channels.Pipe.SourceChannel;
import java.util.Scanner;

class TheCloneCommander{
    String name;
    int battery;
    int[] position = new int[2];

    TheCloneCommander(){

    }

    TheCloneCommander(String name,int battery,int[] position){
        this.name =name;
        this.battery = battery;
        this.position[0] = position[0];
        this.position[1] = position[1];
    }
    void move(int dx,int dy){
        this.position[0]+=dx;
        this.position[1]+=dy;

    }

    public TheCloneCommander clone(TheCloneCommander a){
            return new TheCloneCommander(this.name, this.battery, this.position);
    }
    @Override
    public String toString(){
        return this.name + "(Battery:" + this.battery+"," +"Position: ("+this.position[0]+"," +this.position[1]+"))";
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        String name;
        int battery;
        int [] position = new int[2];

        System.out.println("Enter Name");
        name = sc.nextLine();
        System.out.println("Enter Battery");
        battery = sc.nextInt();
        System.out.println("Enter x and y corrdinate");
        for(int i = 0;i<2;i++){
            position[i] = sc.nextInt();
            
        }

        TheCloneCommander c = new TheCloneCommander(name, battery, position);
        TheCloneCommander c1 = null;
        do{
            System.out.println("""
                    1.Move
                    2.Clone
                    3.Show
                    4.Exit
                    """);
               
                    choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {
                        case 1:
                                System.out.println("Enter where You want to move");
                                int x;
                                int y;
                                x = sc.nextInt();
                                y = sc.nextInt();
                                c.move(x, y);  
                            break;
                        case 2:
                            System.out.println("You want to Clone");
                             c1 = c.clone(c);
                        
                        case 3:
                            System.out.println("Original" + c);
                            System.out.println("Clone"+c1);
                        case 4:
                            return;  
                        default:
                            break;
                    }
        }while (choice!=0);
            
        }

    
}
