package Oneup.Story5;
public class TheStaircaseArchitect{
   //
        public int getNumberofWays(int n){
        if(n==0||n==1) return 1;
        return getNumberofWays(n-1)+getNumberofWays(n-2);
     }

    }
    
