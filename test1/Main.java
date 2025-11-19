package Java.openupvs.test1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scannerobject = new Scanner(System.in);
        boolean k=true;
        while(k)
        {
            System.out.println("""
                                 Choose an operation
                                 1. create
                                 2. show
                                 3. free
                                 Enter your choice (1-7): """);
            
            int choice=scannerobject.nextInt();
            scannerobject.nextLine(); // consume newline
            switch(choice)
            {
                case 1:
                    System.out.println("create object");
                    Memory object1 = new Memory();
                    object1.createObject();
                    break;
                
                case 2:
                System.out.println("Show total memory");
                Memory object2 = new Memory();
                System.out.println( object2.show());
                break;
                case 3:
                System.out.println("free a object memory");
                Memory object3 = new Memory();
                object3.free();
                break;



                
    }
    
}
    }
}
