import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Generates all possible team combinations (subsets) from a list of developers.
 * 
 * @author Aman Jeet Singh
 */
public class PerfectTeamAssembly {

    /**
     * Generates all possible team combinations using backtracking.
     * 
     * @param currentIndex Current position in the developers list
     * @param allTeamCombinations List to store all generated combinations
     * @param currentTeamCombination Current team being built
     * @param developerList List of all available developers
     */
    public static void generateSubsets(int currentIndex, List<List<String>> allTeamCombinations,
                                       List<String> currentTeamCombination, List<String> developerList) {
        // Base case: processed all developers, add current team to results
        if (currentIndex == developerList.size()) {
            allTeamCombinations.add(new ArrayList<>(currentTeamCombination));
            return;
        }

        // Choice 1: Include current developer in the team
        currentTeamCombination.add(developerList.get(currentIndex));
        generateSubsets(currentIndex + 1, allTeamCombinations, currentTeamCombination, developerList);

        // Choice 2: Exclude current developer (backtrack)
        currentTeamCombination.remove(currentTeamCombination.size() - 1);
        generateSubsets(currentIndex + 1, allTeamCombinations, currentTeamCombination, developerList);
    }

    /**
     * Main method to interact with user and generate all team combinations.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int numberOfDevelopers = 0;

        // Input validation: get number of developers
        while (true) {
            try {
                System.out.print("Enter number of developers: ");
                numberOfDevelopers = inputScanner.nextInt();

                if (numberOfDevelopers < 0) {
                    System.out.println("Number cannot be negative!");
                    continue;
                }
                break;
            } catch (Exception inputException) {
                System.out.println("Invalid input! Enter an integer.");
                inputScanner.nextLine();
            }
        }

        List<String> developerList = new ArrayList<>();

        // Collect all developer names
        for (int developerIndex = 0; developerIndex < numberOfDevelopers; developerIndex++) {
            System.out.print("Enter developer name " + (developerIndex + 1) + ": ");
            developerList.add(inputScanner.next());
        }

        List<List<String>> allTeamCombinations = new ArrayList<>();
        List<String> currentTeamCombination = new ArrayList<>();

        // Generate all possible team combinations
        generateSubsets(0, allTeamCombinations, currentTeamCombination, developerList);

        // Display all generated team combinations
        System.out.println("\nAll Possible Team Combinations:");
        System.out.println(allTeamCombinations);

        inputScanner.close();
    }
}
