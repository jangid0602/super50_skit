import java.util.Scanner;

class MemoryLeakDetector{
    public static int total_Memory = 0;
    
    void Allocate(int x){
        this.total_Memory+=x;
    }

    public void free(int x){
        if(this.total_Memory>=x){
            this.total_Memory-=x;
        }else{
        System.out.println("Insufficient Memory");
        }
    }

    @Override
    public String toString(){
        return "Total Memory :"+total_Memory;
     }
}


public class Challenge{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemoryLeakDetector m = new MemoryLeakDetector();
        int choice = 0;
        do{
        System.out.println("""
                Enter What You want to perform
                1.Allocate
                2.Free
                3.Show
                4.Exit
        """);

        choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                int x;
                System.out.println("Enter the value You want to Allocate");
                x = sc.nextInt();
                m.Allocate(x);
                break;
            case 2: 
                int y;
                System.out.println("Enter the value You want to Free");
                y = sc.nextInt();
                m.free(y);
                break;
            case 3:
                System.out.println(m);
            case 4:
                return;
            default:
                System.out.println("Invalid Choice");
                break;
        }
    }while(choice>0);
    }
}