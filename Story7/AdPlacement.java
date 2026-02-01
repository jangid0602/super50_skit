import java.util.*;

/**
 * @Filename- AdPlacement.java
 * @Description- In this we can include any ad multiple times, but there is a catch: if you place the same ad
twice, the profit of the second instance drops by 50%.
 * @Author- Arman Agrawal
 */


class Advertisement {
        int durationInSeconds;
        int baseProfit;

        Advertisement(int durationInSeconds, int baseProfit) {
            this.durationInSeconds = durationInSeconds;
            this.baseProfit = baseProfit;
        }
    }



public class AdPlacement {

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

                    maxProfitAtTime[currentTime + usedTime] =
                        Math.max(
                            maxProfitAtTime[currentTime + usedTime],
                            maxProfitAtTime[currentTime] + currentProfit
                        );

                    currentProfit /= 2;
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

        System.out.print("Enter total video time (T): ");
        int totalVideoTime = InputUtil.readInt();

        System.out.print("Enter number of ads (M): ");
        int numberOfAds = InputUtil.readInt();

        List<Advertisement> advertisements = new ArrayList<>();

        for (int i = 0; i < numberOfAds; i++) {
            System.out.print("Enter duration of ad " + (i + 1) + ": ");
            int duration = InputUtil.readInt();

            System.out.print("Enter profit of ad " + (i + 1) + ": ");
            int profit = InputUtil.readInt();

            advertisements.add(new Advertisement(duration, profit));
        }

        int maximumProfit =
            calculateMaximumProfit(totalVideoTime, advertisements);

        System.out.println("Maximum Profit: " + maximumProfit);
    }
}
