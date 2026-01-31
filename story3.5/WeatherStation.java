/**
 * Filename : WeatherDetection.java
 * Description : count how many days set a new temperature record.
 * Author : Nancy Jain
 */
public class WeatherStation {
    public static int recordDays(int[] days){
        if (days == null || days.length == 0) return 0;
        int count=1,maximumRecord = days[0];
        for(int day: days){
            if(day > maximumRecord){
                count++;
                maximumRecord=day;
            }
        }
        return count;
    }
}
