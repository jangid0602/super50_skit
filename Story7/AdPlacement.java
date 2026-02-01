import java.util.*;


/**
 * @filename - AdPlacement.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

class AdPlacement {

    static class Advertisement {
        int durationInSeconds;
        int baseProfit;

        Advertisement(int durationInSeconds, int baseProfit) {
            this.durationInSeconds = durationInSeconds;
            this.baseProfit = baseProfit;
        }
    }

    static int calculateMaximumProfit(
            int totalVideoTime,
            List<Advertisement> advertisements) {

        int[] maxProfitAtTime = new int[totalVideoTime + 1];

        for (Advertisement ad : advertisements) {

            for (int currentTime = totalVideoTime; currentTime >= 0; currentTime--) {

                int usedTime = ad.durationInSeconds;
                int currentProfit = ad.baseProfit;

                while (currentTime + usedTime <= totalVideoTime
                        && currentProfit > 0) {

                    maxProfitAtTime[currentTime + usedTime] = Math.max(
                            maxProfitAtTime[currentTime + usedTime],
                            maxProfitAtTime[currentTime] + currentProfit);

                    currentProfit /= 2; // diminishing profit
                    usedTime += ad.durationInSeconds;
                }
            }
        }

        int answer = 0;
        for (int t = 0; t <= totalVideoTime; t++) {
            answer = Math.max(answer, maxProfitAtTime[t]);
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total video time (T): ");
        int totalVideoTime = sc.nextInt();

        System.out.print("Enter number of ads (M): ");
        int numberOfAds = sc.nextInt();

        List<Advertisement> advertisements = new ArrayList<>();

        for (int i = 0; i < numberOfAds; i++) {
            System.out.print("Enter duration of ad " + (i + 1) + ": ");
            int duration = sc.nextInt();

            System.out.print("Enter profit of ad " + (i + 1) + ": ");
            int profit = sc.nextInt();

            advertisements.add(new Advertisement(duration, profit));
        }

        int maximumProfit = calculateMaximumProfit(totalVideoTime, advertisements);

        System.out.println("Maximum Profit: " + maximumProfit);
    }
}
