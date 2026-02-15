package Week3_5;

public class ConcertSeatManager {
    public static class Request {
        public final String customerId;
        public final int seatNumber;
        public Request(String customerId, int seatNumber) {
            this.customerId = customerId;
            this.seatNumber = seatNumber;
        }
    }

    // Returns the customerId of the first duplicate seat request, or "-1" if none.
    public static String firstDuplicate(Request[] requests) {
        // Simple boolean array map for typical seat ranges; fall back to linear scan if out of range.
        // To avoid collections, we mark seen seats in a dynamic boolean map sized to max seat.
        int maxSeat = 0;
        for (Request r : requests) {
            if (r.seatNumber > maxSeat) maxSeat = r.seatNumber;
        }
        boolean[] seen = new boolean[maxSeat + 1];
        for (Request r : requests) {
            int seat = r.seatNumber;
            if (seat >= 0 && seat < seen.length) {
                if (seen[seat]) return r.customerId;
                seen[seat] = true;
            } else {
                // Out-of-range guard: fall back to nested scan without collections
                for (Request earlier : requests) {
                    if (earlier == r) break;
                    if (earlier.seatNumber == seat) return r.customerId;
                }
            }
        }
        return "-1";
    }
}
