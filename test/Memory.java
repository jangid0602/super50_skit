package Oneup.Assignment2;


public class Memory {
     static int x=0;
    Memory(int y){
        this.x+=y;
    }
    public static int  free(int y){
        return x-=y;

    }
    public int  getallocatedmemory(){
        return x;

    }
    
}
