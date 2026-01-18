import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Filename-PerfectTeamAssembly.java
 * @Description-Generates all possible team combinations using backtracking
 * @Author-Aditya Virmani
 */
public class PerfectTeamAssembly {
    static void generateSubsets(int index, List<List<String>> allTeams, List<String> currentTeam,
            List<String> developers) {

        if (index == developers.size()) {
            allTeams.add(new ArrayList<>(currentTeam));
            return;
        }

        currentTeam.add(developers.get(index));
        generateSubsets(index + 1, allTeams, currentTeam, developers);

        currentTeam.remove(currentTeam.size() - 1);
        generateSubsets(index + 1, allTeams, currentTeam, developers);
    }

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        int numberOfDevelopers = 0;

        while (true) {
            try {
                System.out.print("Enter number of developers: ");
                numberOfDevelopers = userInput.nextInt();

                if (numberOfDevelopers < 0) {
                    System.out.println("Number cannot be negative!");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input! Enter an integer.");
                userInput.nextLine();
            }
        }

        List<String> developers = new ArrayList<>();

        for (int i = 0; i < numberOfDevelopers; i++) {
            System.out.print("Enter developer name " + (i + 1) + ": ");
            developers.add(userInput.next());
        }

        List<List<String>> allTeams = new ArrayList<>();
        List<String> currentTeam = new ArrayList<>();

        generateSubsets(0, allTeams, currentTeam, developers);

        System.out.println("\nAll Possible Team Combinations:");
        System.out.println(allTeams);

        userInput.close();
    }
}
