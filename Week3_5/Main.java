package Week3_5;

public class Main {
    public static void main(String[] args) {
        demoCosmicCourier();
        demoDigitalLibrary();
        demoFactoryRobot();
        demoSpyCipher();
        demoConcertSeatManager();
        demoWeatherAggregator();
        demoMidpointFinder();
        demoBrowserHistory();
    }

    private static void demoCosmicCourier() {
        int[][] tests = {
                {10, 5, 8, 12, 6},
                {3, 3, 3, 3},
                {1, 100, 2}
        };
        System.out.println("Cosmic Courier Challenge:");
        for (int[] t : tests) {
            System.out.println(CosmicCourier.minDeadline(t));
        }
        System.out.println();
    }

    private static void demoDigitalLibrary() {
        DigitalLibrary lib = new DigitalLibrary();
        lib.addBook("War");
        System.out.println("Digital Library (exact War): " + DigitalLibrary.formatBooks(lib.search("War")));
        lib.addBook("Data");
        lib.addBook("Database");
        System.out.println("Digital Library (partial Data): " + DigitalLibrary.formatBooks(lib.search("Data", true)));
        lib.removeBook("A");
        System.out.println("Digital Library (search A after remove): " + DigitalLibrary.formatBooks(lib.search("A")));
        System.out.println();
    }

    private static void demoFactoryRobot() {
        int[][] inputs = {
                {15, 6, 10, 7},
                {3, 5, 30},
                {1, 2, 4}
        };
        System.out.println("Factory Floor Robot:");
        for (int[] arr : inputs) {
            System.out.println(FactoryRobot.format(FactoryRobot.labelWeights(arr)));
        }
        System.out.println();
    }

    private static void demoSpyCipher() {
        System.out.println("Spy's Cipher:");
        System.out.println(SpyCipher.findExtraChar("abcd", "abcde"));
        System.out.println(SpyCipher.findExtraChar("aabc", "abacx"));
        System.out.println(SpyCipher.findExtraChar("hello", "hlleo"));
        System.out.println();
    }

    private static void demoConcertSeatManager() {
        System.out.println("Concert Seat Manager:");
        ConcertSeatManager.Request[] r1 = new ConcertSeatManager.Request[] {
            new ConcertSeatManager.Request("C1", 101),
            new ConcertSeatManager.Request("C2", 105),
            new ConcertSeatManager.Request("C3", 101)
        };
        System.out.println(ConcertSeatManager.firstDuplicate(r1));

        ConcertSeatManager.Request[] r2 = new ConcertSeatManager.Request[] {
            new ConcertSeatManager.Request("C1", 101),
            new ConcertSeatManager.Request("C2", 105),
            new ConcertSeatManager.Request("C3", 103),
            new ConcertSeatManager.Request("C4", 105)
        };
        System.out.println(ConcertSeatManager.firstDuplicate(r2));

        ConcertSeatManager.Request[] r3 = new ConcertSeatManager.Request[] {
            new ConcertSeatManager.Request("C1", 10),
            new ConcertSeatManager.Request("C2", 20)
        };
        System.out.println(ConcertSeatManager.firstDuplicate(r3));
        System.out.println();
    }

    private static void demoWeatherAggregator() {
        System.out.println("Weather Station Data Aggregator:");
        int[][] temps = {
                {15, 22, 15, 30, 28, 31},
                {5, 1, 2, 3, 4},
                {10, 10, 10}
        };
        for (int[] t : temps) {
            System.out.println(WeatherAggregator.countRecordDays(t));
        }
        System.out.println();
    }

    private static void demoMidpointFinder() {
        System.out.println("Midpoint Finder:");
        MidpointFinder.ListNode a1 = new MidpointFinder.ListNode("1");
        a1.next = new MidpointFinder.ListNode("2");
        a1.next.next = new MidpointFinder.ListNode("3");
        a1.next.next.next = new MidpointFinder.ListNode("4");
        a1.next.next.next.next = new MidpointFinder.ListNode("5");
        System.out.println(MidpointFinder.middleValue(a1));

        MidpointFinder.ListNode b1 = new MidpointFinder.ListNode("10");
        b1.next = new MidpointFinder.ListNode("20");
        b1.next.next = new MidpointFinder.ListNode("30");
        b1.next.next.next = new MidpointFinder.ListNode("40");
        System.out.println(MidpointFinder.middleValue(b1));

        MidpointFinder.ListNode c1 = new MidpointFinder.ListNode("A");
        c1.next = new MidpointFinder.ListNode("B");
        System.out.println(MidpointFinder.middleValue(c1));
        System.out.println();
    }

    private static void demoBrowserHistory() {
        System.out.println("Browser History Navigator:");
        BrowserHistoryNavigator bh = new BrowserHistoryNavigator();
        bh.visit("A");
        bh.visit("B");
        bh.back();
        System.out.println(bh.getCurrent());

        bh = new BrowserHistoryNavigator();
        bh.back();
        bh.visit("C");
        bh.forward();
        System.out.println(bh.getCurrent());

        bh = new BrowserHistoryNavigator();
        bh.visit("1");
        bh.visit("2");
        bh.visit("3");
        bh.back();
        bh.forward();
        System.out.println(bh.getCurrent());
        System.out.println();
    }
}
