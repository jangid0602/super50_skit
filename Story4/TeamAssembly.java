import java.util.List;
import java.util.ArrayList;

/**
 * @Filename- TeamAssembly.java
 * @Description- In this we see every possible combination of team members we could form
 * @Author- Arman Agrawal
 */





public class TeamAssembly {

    public static void generateTeams(
            String[] developers,
            int index,
            List<String> currentTeam,
            List<List<String>> allTeams) {

        if (index == developers.length) {
            allTeams.add(new ArrayList<>(currentTeam));
            return;
        }

        generateTeams(developers, index + 1, currentTeam, allTeams);

        currentTeam.add(developers[index]);
        generateTeams(developers, index + 1, currentTeam, allTeams);
        currentTeam.remove(currentTeam.size() - 1);
    }
}
