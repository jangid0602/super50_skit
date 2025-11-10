import java.util.*;
public class Main {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("chosse the opertion\n 1.Memory Leak Detector \n 2.The Clone Commander");
    int choice=sc.nextInt();
    if(choice==1){
      System.out.println("choose the operation to stimulate the memory location  \n 1.allocate \n 2.free\n 3.show");
      int total_memory  =0;
      MemoryLeakDector memory=new MemoryLeakDector(total_memory);
      int choic =sc.nextInt();
      switch (choic) {
        case 1:
          System.out.println("enter the memory you wnat to allocate");
          int alocatememory=sc.nextInt();
          memory.aloocate(alocatememory);
          break;
         case 2:
           System.out.println("enter the memory you want to free");
           int fre=sc.nextInt();
           if(total_memory<fre){
            System.out.println("totalmemory less than free memory please eneter valid ");
            break;
           }
           memory.free(fre);
           break;
           case 3:
            System.out.println("the total memory "+memory.show());
        default:
          break;
      }
    }
  }
}
