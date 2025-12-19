package Story4;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
Library library = new Library();

        // Preload books (optional but useful)
        library.addBook(new Book("Harry Potter", "J K Rowling"));
        library.addBook(new Book("Clean Code", "Robert Martin"));
        library.addBook(new Book("Java Programming", "James Gosling"));
        while (true) {
            System.out.println("\n==== MENU ====");
            System.out.println("1. Cosmic Courier Challenge");
            System.out.println("2. Digital Library System");
            System.out.println("3. Factory Floor Robot");
            System.out.println("4. The Spy's Cipher");
            System.out.println("5. Concert Seat Manager");
            System.out.println("6. Weather Station Aggregator");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 0) {
                System.out.println("Exiting...");
                break;
            }

            switch (choice) {

                case 1: {
                    System.out.print("Enter number of routes: ");
                    int n = sc.nextInt();
                    if (n <= 0) break;

                    int[] arr = new int[n];
                    System.out.println("Enter route times:");
                    for (int i = 0; i < n; i++)
                        arr[i] = sc.nextInt();

                    System.out.println(
                        CosmicCourier.minimumDeadline(arr)
                    );
                    break;
                }

                case 2: {
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();

                    System.out.print("Partial match? (true/false): ");
                    boolean partial = sc.nextBoolean();

                    library.search( title, partial);
                    break;
                }

                case 3: {
                    System.out.print("Enter number of items: ");
                    int n = sc.nextInt();
                    if (n <= 0) break;

                    int[] weights = new int[n];
                    for (int i = 0; i < n; i++)
                        weights[i] = sc.nextInt();

                    System.out.println(
                        FactoryFloorRobot.labelItems(weights)
                    );
                    break;
                }

                case 4: {
                    System.out.print("Enter original string: ");
                    String original = sc.nextLine();
                    System.out.print("Enter scrambled string: ");
                    String scrambled = sc.nextLine();

                    if (original == null || scrambled == null) break;

                    System.out.println(
                        SpyCipher.findExtraChar(original, scrambled)
                    );
                    break;
                }

                case 5: {
                    System.out.print("Enter number of requests: ");
                    int n = sc.nextInt();
                    sc.nextLine();

                    List<String[]> requests = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        String customer = sc.next();
                        String seat = sc.next();
                        requests.add(new String[]{customer, seat});
                    }

                    System.out.println(
                        ConcertSeatManager.firstDuplicateSeat(requests)
                    );
                    break;
                }

                case 6: {
                    System.out.print("Enter number of days: ");
                    int n = sc.nextInt();
                    if (n <= 0) break;

                    int[] temps = new int[n];
                    for (int i = 0; i < n; i++)
                        temps[i] = sc.nextInt();

                    System.out.println(
                        WeatherDataCollector.countRecordDays(temps)
                    );
                    break;
                }

                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
