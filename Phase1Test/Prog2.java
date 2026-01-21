import java.util.ArrayList;

public class Prog2 {

    public static void main(String[] args) {

        int[] pages = {4};
        int n = 4;

        ArrayList<String> ans = new ArrayList<>();

        int prev = 0;

        for (int p : pages) {
            if (p - prev > 2) {
                ans.add((prev + 1) + "-" + (p - 1));
            } else if (p - prev == 2) {
                ans.add(String.valueOf(prev + 1));
            }
            prev = p;
        }

  
        if (n - prev > 1) {
            ans.add((prev + 1) + "-" + n);
        } else if (n - prev == 1) {
            ans.add(String.valueOf(n));
        }

        System.out.println(ans);
    }
}
