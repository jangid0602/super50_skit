/**

 * Description- A builder is designing a staircase with $N$ steps. He can climb either 1
 step or 2 steps at a time. Write a function to calculate the total number
 of distinct ways he can reach the top.
 * Author - Mayank Rathore

 */
public class StaircaseArchitect {
    static int countWays(int stepcount)
    {
        if(stepcount==1||stepcount==0)
        {
            return 1;

        }
        return countWays(stepcount - 1) + countWays(stepcount - 2);

    }
    public static void main(String[] args)
    {
        Input input=new Input();
        System.out.println("Enter number of stair");
        int stepcount= input.inputInteger();
        System.out.println("Nmber of ways are:"+countWays(stepcount));
    }

}
