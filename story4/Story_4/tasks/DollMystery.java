package tasks;
/**
 * Filename- DollMystry.java
 * Description- In a set of nested Russian dolls. Inside each doll is a smaller
doll, until you reach the smallest one which contains a tiny golden key.
Write a recursive function findKey(doll) that opens a doll, checks if it's
the smallest, and if not, calls itself on the doll found inside.
 * Author - Nancy Jain
 * Date - 07/01/2026
 */
public class DollMystery{
    public static int solve(int[] sizes,boolean[] open){
        return hasKey(0,sizes,open);
    }
    private static int hasKey(int index , int[] sizes ,boolean[] open){
        if(index == sizes.length) return 0;
        if(open[index] && sizes[index]==1)    return 1;
        
        return hasKey(index+1 , sizes ,open);
    }
}