package Story4;
import java.util.*;

class ConcertSeatManager {

    public static String firstDuplicateSeat(List<String[]> requests) {
        Set<Integer> usedSeats = new HashSet<>();

        for (String[] req : requests) {
            String customer = req[0];
            int seat = Integer.parseInt(req[1]);

            if (usedSeats.contains(seat)) {
                return customer; // first duplicate seat request
            }
            usedSeats.add(seat);
        }

        return "-1"; // no duplicate found
    }
}