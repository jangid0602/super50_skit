
import java.util.LinkedList;

// Node Swap by Value (incomplete)
public class Prog3 {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        int x = 2;

        int temp = list.getFirst();

        System.out.println(list);

    }

    public static void swap(LinkedList<Integer> list,
            int ele1, int ele2) {

        int index1 = list.indexOf(ele1);
        int index2 = list.indexOf(ele2);

        if (index1 == -1 || index2 == -1) {
            return;
        }

        list.set(index1, ele2);
        list.set(index2, ele1);
    }
}
