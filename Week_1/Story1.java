import java.util.*;
public class Story1{

    public static int farthestCity(ArrayList<Long> energyCost, long initialEnergy) {

        long currentEnergy = initialEnergy;
        int totalCities = energyCost.size();

        for(int cityIndex = 0; cityIndex < totalCities; cityIndex++) {

            currentEnergy -= energyCost.get(cityIndex);

            if(currentEnergy < 0) {
                return cityIndex - 1;
            }
        }

        return totalCities;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities: ");
        int numberOfCities = sc.nextInt();
        ArrayList<Long> energyCost = new ArrayList<>();

        System.out.println("Enter the energy cost for each city:");
        for(int i = 0; i < numberOfCities; i++) {
            energyCost.add(sc.nextLong());
        }

        System.out.print("Enter initial energy: ");
        long initialEnergy = sc.nextLong();

        int answer = farthestCity(energyCost, initialEnergy);

        System.out.println("Farthest reachable city index = " + answer);
    }
}
