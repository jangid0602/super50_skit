public class q1
{
    static int longestStablePath(int height[],int k)
    {       
          int count = 1;
          for(int i =0;i<height.length-1;i++)
          {
              if(height[i + 1] - height[i] <= k) count++;
          }

          return count;
    }

    public static void main(String[] args) {
        
        int height[] = {1,2,5,8};
        int k = 3;
        System.out.println(longestStablePath(height, k));
    }
}