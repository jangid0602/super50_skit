
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        // LavaFloor obj = new LavaFloor();
        
        // List<Integer> list = new ArrayList<>(List.of(5, 15, 25));

        // System.out.println(obj.get_longest_stable_path(list, 5));


        Missing_page_number obj = new Missing_page_number();
        List<Integer> list = new ArrayList<>(List.of(2,3,8));
        List<String> result = obj.get_missing_pages(list, 10);
        int size = result.size();
        for(int i=0;i<size;i++){
            System.out.println(result.get(i));
        }
    }
}
