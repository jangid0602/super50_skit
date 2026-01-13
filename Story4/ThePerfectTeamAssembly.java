/**

 * Description- You are a manager with a list of $N$ specialized developers. You want
 to see every possible combination of team members you could form
 (subsets).
 * Author - Mayank Rathore
 */
import java.util.ArrayList;
public class ThePerfectTeamAssembly {
    static ArrayList<ArrayList<String>> result = new ArrayList<>();

    static void subsets(String[] devs, int index, ArrayList<String> current) {

        result.add(new ArrayList<>(current));

        for (int i = index; i < devs.length; i++) {
            current.add(devs[i]);
            subsets(devs, i + 1, current);
            current.remove(current.size() - 1);
        }
    }
    public static void main(String[] args) {

        Input input=new Input();
        System.out.print("Enter number of developers: ");
        int n= input.inputInteger();
        String[] devs = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter developer " + (i + 1) + ": ");
            devs[i] = input.inputWord();
        }

        subsets(devs, 0, new ArrayList<>());

        System.out.println("\nAll possible teams:");
        System.out.println(result);


    }

}
