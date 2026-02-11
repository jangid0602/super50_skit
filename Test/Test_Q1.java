/**
 * @Filename- Test_Q1.java
 * @Description - 1.Problem Statement: Memory Leak Detector
    Design a class Memory to simulate memory allocation.
    ● Each object created consumes x units.
    ● A static variable total_memory tracks total allocated memory.
    Implement a method free() to release an object’s memory.
 * @Author - Nancy Jain
 */

 import java.util.Scanner;
class Memory{
    public static int total_memory=0; //static variable to track memory
    public void getAllocatedMemory(int allocated_memory){
         total_memory+=allocated_memory; //allocated memory + total memory
    }
    public void getFreeMemory(int free_memory){
        total_memory-=free_memory; // total memory - free memory
    }
    public int showMemory(){
        return total_memory; //total available memory
    }
}
public class Test_Q1{
    public static void main(String[] args) {
        try(Scanner scanner =new Scanner(System.in)){
            boolean running =true;
            Memory memory = new Memory();
            do{
                System.out.println("\n ## Memory Leak Detector ##");
                System.out.println("1. Allocate Memory");
                System.out.println("2. Free Memory");
                System.out.println("3. Show Memory");
                System.out.println("4. Quit");
                System.out.println("Enter you choice");
                int choice = readInt(scanner);
                switch (choice) {
                    case 1:
                        System.out.println("Enter memory to Allocate.");
                        int allocated_memory = readInt(scanner);
                        memory.getAllocatedMemory(allocated_memory);
                        System.out.println(allocated_memory+"units allocated successfully.");
                        break;
                    case 2:
                        System.out.println("Enter memory to Free.");
                        if(Memory.total_memory == 0 ){
                            System.out.println("No memory available to free.");
                            break;
                        }
                        int free_memory = readInt(scanner);
                        if(free_memory - Memory.total_memory < 0){
                            System.out.println("less memory available to free.");
                        }
                        System.out.println(free_memory+"units freed successfully.");
                        memory.getFreeMemory(free_memory);
                        break;
                    case 3:
                        System.out.println("Currently allocated memory: " + Memory.total_memory + " units.");
                        break;
                    case 4:
                        System.out.println("Do you want to exit if yes press 1 else press 0");
                        int action = readInt(scanner);
                        if(action==1){
                        System.out.println("Exiting...");
                        System.exit(0); 
                }  
                    default:
                        System.out.println("Wrong choice");
                }
            }while(running);
        }
    }
    private static int readInt(Scanner sc){
        while(true){
            if(sc.hasNextLine()){
                int val=sc.nextInt();
                sc.nextLine();
                return val;
            }else{
                String bad = sc.nextLine();
                System.out.println("Invalid Choice: \""+ bad +"\" is not an Integer.");
                System.out.println("Please enter valid Integer value.");
            }
        }
    }
}
