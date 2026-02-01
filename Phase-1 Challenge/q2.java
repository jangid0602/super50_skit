import java.util.*;

public class q2 {
    
    static void missingPageNumbers(HashSet<Integer> set,int N,List<String> missingPages)
    {
        for(int i =1;i<=N;i++)
        {
            if(set.contains(i)) continue;
            int currValue =  i;
            while(currValue <= N && !(set.contains(currValue)) )
            {
               currValue++;
            }
            
            if(i == currValue - 1) {
                missingPages.add(String.valueOf(i));
            }
            else{
                String str = i + " - "+  (currValue -1);
                missingPages.add(str);
            }

            i = currValue;
            
        }
    }

    public static void main(String[] args) {
        
        HashSet<Integer> set = new HashSet<>();
        List<String> list = new ArrayList<>();

        int pages[] = {4};
        int N = 4;
        for(int i= 0;i<pages.length;i++)
        {
            set.add(pages[i]);
        }

        missingPageNumbers(set, N, list);
        System.out.println(list);

    }
}
