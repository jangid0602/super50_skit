/**
 * <p>Abstract Class for handling string inputs — allows user to enter multiple string values dynamically.</p>
 * <p>User can press Enter twice (empty line) to stop entering strings.</p>
 * @Author- Aaditya Jain
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public abstract class stringHandler extends problemSolver {

    public String[] strings;
    public int numberOfStrings;

    @Override
    public void inputArray() {
        Scanner scannerObj = new Scanner(System.in);
        List<String> stringList = new ArrayList<>();

        System.out.println("Enter your strings (press Enter twice to stop):");

        while (true) {
            String input = scannerObj.nextLine().trim();
            if (input.isEmpty()) {
                break; // stop reading when user presses Enter on empty line
            }
            stringList.add(input);
        }

        strings = stringList.toArray(new String[0]);
        numberOfStrings = strings.length;

        if (numberOfStrings == 0) {
            System.out.println("No strings entered. Exiting...");
            System.exit(1);
        }
    }
}
