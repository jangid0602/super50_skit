/**
 * Filename - LavaFloor.java
 * Description - Find longest stable path
 * Author - Nancy Jain
 * Date - 21/01/2026
 */

public class NodeSwap {
    public static LL Swap(LL head , int value){
        LL temp = head;
        while(temp != null){
            if(temp.data == value){
                if(temp.next != null){
                int swapValue = temp.data;
                temp.data = temp.next.data;
                temp = temp.next;
                temp.data = swapValue;
            }else return head;
            }
            temp = temp.next;
        }
        return head;
    }
}
