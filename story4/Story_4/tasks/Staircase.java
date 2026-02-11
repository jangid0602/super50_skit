package tasks;
/**
 * Filename- Staircase.java
 * Description- A builder is designing a staircase with $N$ steps. He can climb either 1
step or 2 steps at a time. Write a function to calculate the total number
of distinct ways he can reach the top.
 * Author - Nancy Jain
 * Date - 07/01/2026
 */
public class Staircase {
    public static int Architect(int N){
        if(N==0) return 1;
        if(N<0) return 0;

        return Architect(N-1) + Architect(N-2);
    }
}
