/**
 * Filename- Ancestry.java
 * Description- In a family tree, each person has a wealth value and a list of children. To 
calculate the "Total Legacy" of a person, you must add their wealth to 
the wealth of all their descendants.
 * Author - Nancy Jain
 * Date - 07/01/2026
 */
package tasks;

public class Ancestry {
    
    public static int wealth(TreeNode root){
        if(root == null) return 0;
        return root.data + wealth(root.left) + wealth(root.right);
    }
}
