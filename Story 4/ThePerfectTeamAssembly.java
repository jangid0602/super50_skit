/**
 * <p>This class solves  The Perfect Team Assembly  Challenge  using recursion (Power set generation). </p>
 *
 * @Author- Aaditya Jain
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThePerfectTeamAssembly {

    static void backtrack(String[] devs, int index,
                          List<String> current,
                          List<List<String>> result) {

        result.add(new ArrayList<>(current));

        for (int i = index; i < devs.length; i++) {

            current.add(devs[i]);

            backtrack(devs, i + 1, current, result);

            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        Scanner scannerobj = new Scanner(System.in);

        System.out.print("Enter number of developers: ");
        int devNumber = scannerobj.nextInt();
        scannerobj.nextLine();

        String[] developers = new String[devNumber];

        System.out.println("Enter developer names:");
        for (int i = 0; i < devNumber; i++) {
            developers[i] = scannerobj.nextLine();
        }

        List<List<String>> result = new ArrayList<>();

        backtrack(developers, 0, new ArrayList<>(), result);

        System.out.println("All possible team combinations:");
        System.out.println(result);

        scannerobj.close();
    }
}
